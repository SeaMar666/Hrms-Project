package hrms.hrms.core.adapters.verification;

public interface VerificationService {

	void sendLink(String email);
	String sendCode();
}
