package hrms.hrms.core.utilities.image;

import java.io.IOException;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
@Service
public class ImageManager implements ImageService{
	
	private Cloudinary cloudinary;
	
	public ImageManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dayx2sam5",
				"api_key", "699443261618643",
				"api_secret", "LaC_8aO4_p-vseLXfpOJGuC-sjI"));
	}

	

	@Override
	public DataResult<Map> uplıadImageFile(MultipartFile imageFile) {
		try {
			
			Map<String, String> resultMap=(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		return new ErrorDataResult<Map>();
	}
	
	

}
