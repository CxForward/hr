package pc.hcy.learn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 统一全站的中文编码
 */
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        //放行
        filterChain.doFilter(new MyRequest(req), resp);
        resp.setContentType("text/html;charset=utf-8");
    }

    @Override
    public void destroy() {

    }

    class MyRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            //post请求
            if (request.getMethod().equalsIgnoreCase("post")) {
                return request.getParameter(name);
            }
            //get请求
            String value = request.getParameter(name);
            if (value == null) {
                return null;
            }
            try {
                value = new String(request.getParameter(name).getBytes("iso8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
            ;
            return value;
        }
    }
}
