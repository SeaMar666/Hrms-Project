package hrms.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstarcts.ImageForCVService;
import hrms.hrms.core.utilities.image.ImageService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ImageForCVDao;
import hrms.hrms.entities.concretes.ImageForCV;

@Service
public class ImageForCVManager implements ImageForCVService{

	private ImageForCVDao imageForCVDao;
	private ImageService imageService;

	@Autowired
	public ImageForCVManager(ImageForCVDao imageForCVDao, ImageService imageService) {
		super();
		this.imageForCVDao = imageForCVDao;
		this.imageService = imageService;
	}
	
	@Override
	public Result add(ImageForCV imageForCV , MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.imageService.uplıadImageFile(imageFile).getData();
		imageForCV.setUrl(uploadImage.get("url"));
		this.imageForCVDao.save(imageForCV);
		return new SuccessResult("Image has been added.");
	}

	@Override
	public Result delete(int id) {
		this.imageForCVDao.deleteById(id);
		return new SuccessResult("Image has been deleted.");
	}

	@Override
	public DataResult<ImageForCV> getById(int id) {
		return new SuccessDataResult<ImageForCV>(this.imageForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ImageForCV>> getAll() {
		return new SuccessDataResult<List<ImageForCV>>(this.imageForCVDao.findAll());
	}

	@Override
	public DataResult<ImageForCV> getByCandidateId(int id) {
		return new SuccessDataResult<ImageForCV>(this.imageForCVDao.getByJobseeker_id(id));
	}


	@Override
	public Result update(ImageForCV imageForCV) {
		this.imageForCVDao.save(imageForCV);
		return new SuccessResult("Image has been updated.");
	}


}
