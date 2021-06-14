package hrms.hrms.MernisService;

public class FakeMernisService {
	
	public boolean validateByPersonalInfo(long nationalId,String firstName , String lastName,int yearOfBirth) {
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}

}
