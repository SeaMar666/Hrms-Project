package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SchoolCV;

public interface SchoolForCVService {

	Result add(SchoolCV schoolForCV);
	Result update(SchoolCV schoolForCV);
	Result delete(int id);
	DataResult<SchoolCV> getById(int id);	
	DataResult<List<SchoolCV>> getAll();
	DataResult<List<SchoolCV>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	DataResult<List<SchoolCV>> getAllByJobseekerId(int id);
}
