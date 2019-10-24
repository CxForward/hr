package pc.hcy.learn.dao;

import java.util.List;

import pc.hcy.learn.pojo.Salary;

public interface SalaryDao {
    List findAllSalaries();

    void saveSalary(Salary salary);

    void updateSalary(Salary salary);

    Salary findSalaryById(String id);

    void deleteSalary(String id);
}
