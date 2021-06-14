package hrms.hrms.business.abstarcts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ImageForCV;

public interface ImageForCVService {
	Result add(ImageForCV imageForCVService, MultipartFile imageFile);
	Result update(ImageForCV imageForCVService);
	Result delete(int id);
	DataResult<ImageForCV> getById(int id);	
	DataResult<List<ImageForCV>> getAll();
	DataResult<ImageForCV> getByCandidateId(int id);
}
