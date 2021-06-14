package hrms.hrms.business.abstarcts;

import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;

public interface AuthService {

	Result registerEmployer(Employer employer , String confirmPassword);
	Result registerJobseeker(Jobseeker jobseeker , String confirmPassword);
}
