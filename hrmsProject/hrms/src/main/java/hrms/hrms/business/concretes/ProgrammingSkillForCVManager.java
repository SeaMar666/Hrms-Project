package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.ProgrammingSkillForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ProgrammingSkillForCVDao;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;

@Service
public class ProgrammingSkillForCVManager implements ProgrammingSkillForCVService{

private ProgrammingSkillForCVDao programmingSkillForCVDao;
	
	
	@Autowired

	public ProgrammingSkillForCVManager(ProgrammingSkillForCVDao programmingSkillForCVDao) {
		super();
		this.programmingSkillForCVDao = programmingSkillForCVDao;
	}


	@Override
	public Result add(ProgrammingSkillForCV programmingSkillForCV) {
		this.programmingSkillForCVDao.save( programmingSkillForCV);
		return new SuccessResult("Programming skill has been added.");
	}

	@Override
	public Result update(ProgrammingSkillForCV programmingSkillForCV) {
		this.programmingSkillForCVDao.save(programmingSkillForCV);
		return new SuccessResult("Programming skill has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.programmingSkillForCVDao.deleteById(id);
		return new SuccessResult("Programming skill has been deleted.");
	}

	@Override
	public DataResult<ProgrammingSkillForCV> getById(int id) {
		return new SuccessDataResult<ProgrammingSkillForCV>(this.programmingSkillForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ProgrammingSkillForCV>> getAll() {
		return new SuccessDataResult<List<ProgrammingSkillForCV>>(this.programmingSkillForCVDao.findAll());
	}

	@Override
	public DataResult<List<ProgrammingSkillForCV>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<ProgrammingSkillForCV>>(this.programmingSkillForCVDao.getAllByJobseeker_id(id));
	}

	


}
