package pc.hcy.learn.service.impl;

import pc.hcy.learn.dao.ApplicantDao;
import pc.hcy.learn.dao.impl.ApplicantDaoImpl;
import pc.hcy.learn.pojo.Applicant;
import pc.hcy.learn.service.ApplicantService;

import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {
    private ApplicantDao applicantDao = new ApplicantDaoImpl();

    @Override
    public void saveApplicant(Applicant applicant) {
        applicantDao.saveApplicant(applicant);
    }

    @Override
    public List findAllApplicants() {
        return applicantDao.findAllApplicants();
    }

    @Override
    public Applicant findApplicantById(String id) {
        return applicantDao.findApplicantById(id);
    }

    @Override
    public void updateApplicant(String id) {
        applicantDao.updateApplicant(id);
    }

    @Override
    public void deleteApplicant(String id) {
        applicantDao.deleteApplicant(id);
    }

    @Override
    public List findApplicantByIsstock(String isstock) {
        return applicantDao.findApplicantByIsstock(isstock);
    }
}
