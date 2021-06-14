package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.ExperienceCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ExperienceForCVDao;
import hrms.hrms.entities.concretes.ExperienceForCV;

@Service
public class ExperienceForCVManager implements ExperienceCVService{

	private ExperienceForCVDao experienceCVDao;
	
	@Autowired
	public ExperienceForCVManager(ExperienceForCVDao experinceCVDao) {
		super();
		this.experienceCVDao = experinceCVDao;
	}

	@Override
	public Result add(ExperienceForCV experienceForCV) {
		this.experienceCVDao.save(experienceForCV);
		return new SuccessResult("Experience has been added.");
	}

	@Override
	public Result update(ExperienceForCV experienceForCV) {
		this.experienceCVDao.save(experienceForCV);
		return new SuccessResult("Experience has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.experienceCVDao.deleteById(id);
		return new SuccessResult("Experience has been deleted.");
	}


	@Override
	public DataResult<List<ExperienceForCV>> getAllByJobseeker_idOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<ExperienceForCV>>(this.experienceCVDao.getAllByJobseeker_idOrderByEndAtDesc(id));
	}

	@Override
	public DataResult<List<ExperienceForCV>> getAllByJobseeker_id(int id) {
		return new SuccessDataResult<List<ExperienceForCV>>(this.experienceCVDao.getAllByJobseeker_id(id));

	}

	@Override
	public DataResult<ExperienceForCV> getById(int id) {
		return new SuccessDataResult<ExperienceForCV>(this.experienceCVDao.getById(id));
	}

	@Override
	public DataResult<List<ExperienceForCV>> getAll() {
		return new SuccessDataResult<List<ExperienceForCV>>(this.experienceCVDao.findAll());

	}

}
