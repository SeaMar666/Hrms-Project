package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.ForeignLanguageForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ForeignLanguageForCVDao;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;

@Service
public class ForeignLanguageForCVManager implements ForeignLanguageForCVService{
	
	private ForeignLanguageForCVDao  foreignLanguageForCvDao;
	
	@Autowired
	public ForeignLanguageForCVManager(ForeignLanguageForCVDao foreignLanguageForCvDao) {
		super();
		this.foreignLanguageForCvDao = foreignLanguageForCvDao;
	}

	@Override
	public Result add(ForeignLanguageForCV foreignLanguageForCV) {
		this.foreignLanguageForCvDao.save(foreignLanguageForCV);
		return new SuccessResult("Foreign language has been added.");
	}

	@Override
	public Result update(ForeignLanguageForCV foreignLanguageForCV) {
		this.foreignLanguageForCvDao.save(foreignLanguageForCV);
		return new SuccessResult("Foreign language has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageForCvDao.deleteById(id);
		return new SuccessResult("Foreign language has been deleted.");
	}

	@Override
	public DataResult<ForeignLanguageForCV> getById(int id) {
		return new SuccessDataResult<ForeignLanguageForCV>(this.foreignLanguageForCvDao.getById(id));
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCvDao.findAll());
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCvDao.getAllByJobseeker_id(id));

	}

}
