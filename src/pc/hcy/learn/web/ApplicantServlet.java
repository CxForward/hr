package pc.hcy.learn.web;

import pc.hcy.learn.service.impl.ApplicantServiceImpl;
import pc.hcy.learn.pojo.Applicant;
import pc.hcy.learn.service.ApplicantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class ApplicantServlet extends BaseServlet {
    private ApplicantService applicantService = new ApplicantServiceImpl();

    public String toAddPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/addapplicant.jsp").forward(req, resp);
        return null;
    }

    public String applicantAdd(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Applicant applicant = new Applicant();
        applicant.setName(req.getParameter("name"));
        applicant.setSex(new Byte(req.getParameter("sex")));
        applicant.setAge(Integer.valueOf(req.getParameter("age")));
        applicant.setJob(req.getParameter("job"));
        applicant.setSpecialty(req.getParameter("specialty"));
        applicant.setSchool(req.getParameter("school"));
        applicant.setExperience(req.getParameter("experience"));
        applicant.setStudyeffort(req.getParameter("studyeffort"));
        applicant.setTel(req.getParameter("tel"));
        applicant.setEmail(req.getParameter("email"));
        applicant.setCreatetime(new Date());
        applicant.setContent(req.getParameter("content"));
        applicantService.saveApplicant(applicant);
        List applicantList = applicantService.findApplicantByIsstock("0");
        req.setAttribute("applicantList", applicantList);
        req.getRequestDispatcher("/listapplicant.jsp").forward(req, resp);
        return null;
    }

    public List applicantList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List applicantList = applicantService.findApplicantByIsstock("0");
        req.setAttribute("applicantList", applicantList);
        req.getRequestDispatcher("/listapplicant.jsp").forward(req, resp);
        return null;
    }

    public List applicantDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Applicant applicant = applicantService.findApplicantById(id);
        req.setAttribute("applicant", applicant);
        req.getRequestDispatcher("/detailapplicant.jsp").forward(req, resp);
        return null;
    }

    public String applicantDelete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Applicant applicant = applicantService.findApplicantById(id);
        applicantService.deleteApplicant(id);
        List applicantList = applicantService.findApplicantByIsstock(applicant.getIsstock().toString());
        req.setAttribute("applicantList", applicantList);
        req.getRequestDispatcher("/listapplicant.jsp").forward(req, resp);
        return null;
    }

    public String applicantUpdate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        applicantService.updateApplicant(id);
        List applicantList = applicantService.findApplicantByIsstock("1");
        req.setAttribute("applicant", applicantList);
        req.getRequestDispatcher("/listapplicant.jsp").forward(req, resp);
        return null;
    }

    public String findApplicantByIsstock(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String isstock = req.getParameter("isstock");
        List<Applicant> applicantList = applicantService.findApplicantByIsstock(isstock);
        req.setAttribute("applicantList", applicantList);
        req.getRequestDispatcher("/listapplicant.jsp").forward(req, resp);
        return null;
    }
}
