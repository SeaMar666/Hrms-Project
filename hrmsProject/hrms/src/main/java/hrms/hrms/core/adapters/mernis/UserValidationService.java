package hrms.hrms.core.adapters.mernis;

public interface UserValidationService {
	boolean userCheckByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);

}
