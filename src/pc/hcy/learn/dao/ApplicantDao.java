package pc.hcy.learn.dao;

import pc.hcy.learn.pojo.Applicant;

import java.util.List;

public interface ApplicantDao {
    void saveApplicant(Applicant applicant);

    List findAllApplicants();

    Applicant findApplicantById(String id);

    void updateApplicant(String id);

    void deleteApplicant(String id);

    List findApplicantByIsstock(String isstock);
}
