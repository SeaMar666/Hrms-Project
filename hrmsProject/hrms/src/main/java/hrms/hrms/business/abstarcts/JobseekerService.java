package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.CandidateCVDto;

public interface JobseekerService {
	Result add(Jobseeker jobseeker);
	Result update(Jobseeker jobseeker);
	Result delete(int id);
	DataResult<Jobseeker> getById(int id);
	
	DataResult<List<Jobseeker>> getAll();
	DataResult<Jobseeker> getCandidateByNationalId(String nationalId);
	DataResult<CandidateCVDto> getCandidateCVById(int id);
	

}
