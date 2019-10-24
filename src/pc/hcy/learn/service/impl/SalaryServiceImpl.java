package pc.hcy.learn.service.impl;

import java.util.List;

import pc.hcy.learn.dao.SalaryDao;
import pc.hcy.learn.dao.impl.SalaryDaoImpl;
import pc.hcy.learn.pojo.Salary;
import pc.hcy.learn.service.SalaryService;

public class SalaryServiceImpl implements SalaryService {
    private SalaryDao salaryDao = new SalaryDaoImpl();

    @Override
    public List findAllSalaries() {
        return salaryDao.findAllSalaries();
    }

    @Override
    public void saveSalary(Salary salary) {

        salaryDao.saveSalary(salary);
    }

    @Override
    public Salary findSalaryById(String id) {

        return salaryDao.findSalaryById(id);
    }

    @Override
    public void updateSalary(Salary salary) {

        salaryDao.updateSalary(salary);
    }

    @Override
    public void delete(String id) {

        salaryDao.deleteSalary(id);
    }
}
