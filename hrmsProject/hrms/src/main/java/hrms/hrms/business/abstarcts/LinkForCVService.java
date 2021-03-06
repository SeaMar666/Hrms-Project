package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LinkForCV;

public interface LinkForCVService {
	Result add(LinkForCV linkForCV);
	Result update(LinkForCV linkForCV);
	Result delete(int id);
	DataResult<LinkForCV> getById(int id);	
	DataResult<List<LinkForCV>> getAll();
	DataResult<List<LinkForCV>> getAllByJobseekerId(int id);
}
