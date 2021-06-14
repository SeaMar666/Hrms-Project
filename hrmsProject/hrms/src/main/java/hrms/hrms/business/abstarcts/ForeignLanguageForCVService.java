package hrms.hrms.business.abstarcts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;

public interface ForeignLanguageForCVService {
	Result add(ForeignLanguageForCV foreignLanguageForCV);
	Result update(ForeignLanguageForCV foreignLanguageForCV);
	Result delete(int id);
	DataResult<ForeignLanguageForCV> getById(int id);	
	DataResult<List<ForeignLanguageForCV>> getAll();
	DataResult<List<ForeignLanguageForCV>> getAllByJobseekerId(int id);

}
