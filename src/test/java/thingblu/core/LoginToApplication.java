package thingblu.core;

public class LoginToApplication {

	public int Rowcount = 1;
	String checkType = "";
	int totalrowcount = 1;
	
	public void logInToApplication(String UserType){
		
		if (checkType == "") {
			checkType = UserType;
			Rowcount++;
		} else if (checkType == UserType) {
			Rowcount++;
		} else {
			checkType = UserType;
			Rowcount = 2;

		}

		switch (UserType) {
		case "Manager":
			//manager log in
			break;

		case "Employee":
			// employee login
			break;

		default:
		}
	}
}
