package hrms.hrms.business.abstarcts;


import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
	

}
