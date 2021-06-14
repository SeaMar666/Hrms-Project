package hrms.hrms.business.abstarcts;

import java.util.List;


import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosition;


public interface JobTitleService {
	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);
	

}
