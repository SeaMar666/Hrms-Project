package hrms.hrms.core.adapters.mernis;

import org.springframework.stereotype.Service;

import hrms.hrms.MernisService.FakeMernisService;

@Service
public class FakeMernisAdapter implements UserValidationService{

	
	@Override
	public boolean userCheckByMernis(long nationalId, String firstName, String lastName, int yearOfBirth) {
		FakeMernisService person = new FakeMernisService();
		
		
		boolean result =true;
		try {
			result = person.validateByPersonalInfo(nationalId, firstName, lastName, yearOfBirth);
		}
				catch (Exception e) {
					e.printStackTrace();
				}
				
		return result;
	}


	
}
