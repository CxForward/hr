package pc.hcy.learn.service;

import pc.hcy.learn.pojo.Applicant;

import java.util.List;

public interface ApplicantService {
    void saveApplicant(Applicant applicant);

    List findAllApplicants();

    Applicant findApplicantById(String id);

    void updateApplicant(String id);

    void deleteApplicant(String id);

    List findApplicantByIsstock(String isstock);
}
