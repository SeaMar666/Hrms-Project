package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SchoolCVDao;
import hrms.hrms.entities.concretes.SchoolCV;

@Service
public class SchoolForCVManager implements SchoolForCVService{

	private SchoolCVDao schoolForCVDao;
	
	@Autowired
	public SchoolForCVManager(SchoolCVDao schoolForCVDao) {
		super();
		this.schoolForCVDao = schoolForCVDao;
	}

	@Override
	public Result add(SchoolCV schoolForCV) {
		this.schoolForCVDao.save(schoolForCV);
		return new SuccessResult("School has been update.");
	}

	@Override
	public Result update(SchoolCV schoolForCV) {
		this.schoolForCVDao.save(schoolForCV);
		return new SuccessResult("School has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.schoolForCVDao.deleteById(id);
		return new SuccessResult("School has been deleted.");
	}

	@Override
	public DataResult<SchoolCV> getById(int id) {
		return new SuccessDataResult<SchoolCV>(this.schoolForCVDao.getById(id));

	}

	@Override
	public DataResult<List<SchoolCV>> getAll() {
		return new SuccessDataResult<List<SchoolCV>>(this.schoolForCVDao.findAll());

	}

	@Override
	public DataResult<List<SchoolCV>> getAllByJobseekerIdOrderByEndAtDesc(int id) {
		return new SuccessDataResult<List<SchoolCV>>(this.schoolForCVDao.getAllByJobseeker_idOrderByEndAtDesc(id));

	}

	@Override
	public DataResult<List<SchoolCV>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<SchoolCV>>(this.schoolForCVDao.getAllByJobseeker_id(id));

	}

	
}
