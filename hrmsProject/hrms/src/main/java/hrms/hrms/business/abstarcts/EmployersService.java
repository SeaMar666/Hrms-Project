package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;

public interface EmployersService{

	Result add(Employer employer);

	DataResult<List<Employer>> getAll();
}
