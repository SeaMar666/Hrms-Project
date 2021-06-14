package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.JobseekerService;
import hrms.hrms.business.abstarcts.ExperienceCVService;
import hrms.hrms.business.abstarcts.ForeignLanguageForCVService;
import hrms.hrms.business.abstarcts.LinkForCVService;
import hrms.hrms.business.abstarcts.ProgrammingSkillForCVService;
import hrms.hrms.business.abstarcts.SchoolForCVService;
import hrms.hrms.core.utilities.image.ImageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.CandidateCVDto;

@Service
public class JobseekerManager implements JobseekerService
{

	private CandidateDao candidateDao;
	private ExperienceCVService experienceForCVService;
	private ForeignLanguageForCVService foreignLanguageForCVService;
	private ImageService imageService;
	private LinkForCVService linkForCVService;
	private ProgrammingSkillForCVService programmingSkillForCVService;
	private SchoolForCVService schoolForCVService;
	
	@Autowired
	public JobseekerManager(CandidateDao candidateDao, ExperienceCVService experienceForCVService,
			ForeignLanguageForCVService foreignLanguageForCVService, ImageService imageService,
			LinkForCVService linkForCVService, ProgrammingSkillForCVService programmingSkillForCVService,
			SchoolForCVService schoolForCVService) {
		super();
		this.candidateDao = candidateDao;
		this.experienceForCVService = experienceForCVService;
		this.foreignLanguageForCVService = foreignLanguageForCVService;
		this.imageService = imageService;
		this.linkForCVService = linkForCVService;
		this.programmingSkillForCVService = programmingSkillForCVService;
		this.schoolForCVService = schoolForCVService;
	}



	@Override
	public Result add(Jobseeker jobseeker) {
		this.candidateDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been added.");
	}


	@Override
	public Result update(Jobseeker jobseeker) {
		this.candidateDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}



	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}



	@Override
	public DataResult<Jobseeker> getById(int id) {
		return new SuccessDataResult<Jobseeker>(this.candidateDao.getById(id));
	}



	@Override
	public DataResult<List<Jobseeker>> getAll() {
          return new SuccessDataResult<List<Jobseeker>>(this.candidateDao.findAll());
	}



	@Override
	public DataResult<Jobseeker> getCandidateByNationalId(String nationalId) {
		return new SuccessDataResult<Jobseeker>(this.candidateDao.findJobseekerByNationalId(nationalId));

	}



	@Override
	public DataResult<CandidateCVDto> getCandidateCVById(int id) {
		Jobseeker jobseeker = this.candidateDao.getById(id);
		CandidateCVDto cv = new CandidateCVDto();
		cv.experiences = jobseeker.getExperiences();
		cv.languages = jobseeker.getLanguages();
		cv.image = jobseeker.getImage();
		cv.links = jobseeker.getLinks();
		cv.programingSkills = jobseeker.getProgramingSkills();
		cv.schools = jobseeker.getSchools();
		return new SuccessDataResult<CandidateCVDto>(cv);
		
	}


	
}
