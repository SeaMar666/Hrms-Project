package hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstarcts.AuthService;
import hrms.hrms.business.abstarcts.JobseekerService;
import hrms.hrms.business.abstarcts.EmployersService;
import hrms.hrms.business.abstarcts.UserService;
import hrms.hrms.business.abstarcts.VerificationCodeService;
import hrms.hrms.core.adapters.mernis.UserValidationService;
import hrms.hrms.core.adapters.verification.VerificationService;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.VerificationCode;


@Service
public class AuthManager implements AuthService{
	
	private UserService userService;
	private EmployersService employerService;
	private JobseekerService jobseekerService;
	private VerificationService verificationService;
	private UserValidationService userValidationService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public AuthManager(UserService userService, EmployersService employerService, JobseekerService jobseekerService,
			VerificationService verificationService, UserValidationService userValidationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.verificationService = verificationService;
		this.userValidationService = userValidationService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if(!checkIfNullInfoForEmployer(employer)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
	    if(!checkDomain(employer.getEmail(), employer.getWebsite())) {
			return new ErrorResult("Invalid email address.");
		}
	    if(!checkIFEmailExists(employer.getEmail() + "already exists.")) {
	    	return new ErrorResult(employer.getEmail() + " already exists.");
	    }
	    if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
	    }
	    employerService.add(employer);
	    String code = verificationService.sendCode();
	    verificationCodeRecord(code, employer.getId(), employer.getEmail());
	    return new  SuccessResult("Registration has been successfully completed");
	}

	@Override
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) {
		if (checkIfRealPerson(Long.parseLong(jobseeker.getNationalId()), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForCandidate(jobseeker, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfTCNoExists(jobseeker.getNationalId())) {

			return new ErrorResult(jobseeker.getNationalId() + " already exists.");
		}

		if (!checkIFEmailExists(jobseeker.getEmail())) {

			return new ErrorResult(jobseeker.getEmail() + " already exists.");
		}

		
		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}
	
	private boolean checkIfNullInfoForEmployer(Employer employer){
		
		if(employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
			&& employer.getPhoneNumber() != null && employer.getPassword() != null){
				return true;
			}
			return false;
		
	}
	
	private boolean checkIfTCNoExists(String nationalId) {
		
		if(this.jobseekerService.getCandidateByNationalId(nationalId).getData() == null) {
			return true;
		}
		return false;
		
	}
	
	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (userValidationService.userCheckByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}
	
	private boolean checkIFEmailExists(String email) {
		if(this.userService.getUserByEmail(email).getData() == null) {
			return false;
		}
		return true;
	}
	
	private boolean checkDomain(String email , String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}
	
	private boolean checkIfNullInfoForCandidate(Jobseeker jobseeker , String confirmPassword) {
		if (jobseeker.getFirstName() != null && jobseeker.getLastName() != null && jobseeker.getNationalId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null && jobseeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

	if (!password.equals(confirmPassword)) {
		return false;
	}

	return true;
}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
	VerificationCode verificationCode = new VerificationCode(id, code, false);
	this.verificationCodeService.add(verificationCode);
	System.out.println("Verification code has been sent to " + email );

}

}
