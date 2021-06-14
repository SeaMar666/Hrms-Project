package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;

public interface ProgrammingSkillForCVService {

	Result add(ProgrammingSkillForCV programmingSkillForCV);
	Result update(ProgrammingSkillForCV programmingSkillForCV);
	Result delete(int id);
	DataResult<ProgrammingSkillForCV> getById(int id);	
	DataResult<List<ProgrammingSkillForCV>> getAll();
	DataResult<List<ProgrammingSkillForCV>> getAllByJobseekerId(int id);
}
