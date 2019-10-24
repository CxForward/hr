package pc.hcy.learn.service;

import java.util.List;

import pc.hcy.learn.pojo.Salary;

public interface SalaryService {
    List findAllSalaries();

    void saveSalary(Salary salary);

    void updateSalary(Salary salary);

    Salary findSalaryById(String id);

    void delete(String id);
}
