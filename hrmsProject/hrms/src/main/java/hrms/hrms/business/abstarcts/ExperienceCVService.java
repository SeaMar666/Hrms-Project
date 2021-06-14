package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ExperienceForCV;

public interface ExperienceCVService {

	Result add(ExperienceForCV experienceForCV);
	Result update(ExperienceForCV experienceForCV);
	Result delete(int id);
	DataResult<ExperienceForCV> getById(int id);
	DataResult<List<ExperienceForCV>> getAll();
	DataResult<List<ExperienceForCV>> getAllByJobseeker_idOrderByEndAtDesc(int id);
	DataResult<List<ExperienceForCV>> getAllByJobseeker_id(int id);
	
}
