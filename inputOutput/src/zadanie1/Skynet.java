package zadanie1;

public class Skynet {
	
	private String systemLogin = "Reese";
	private String systemPassword = "#Terminate";
		
	public static void main(String args[]) {

		Skynet skynet = new Skynet();

		///////   Display SkyNET logo from logo.txt
		skynet.printSkyNetLogo();

		///////   Get user login and password
		String login = skynet.getTextFromInput("login");
		String password = skynet.getTextFromInput("password");

		///////   Load system credentials from file
		skynet.readCredentialsFromFile();

		///////   Verify user login and password
		if (skynet.verifyCredentials(login, password))
			System.out.println("\n\t\tWelcome!");
		else
			System.out.println("\n\t\tFAIL!");		
	}
	

	
	private String getTextFromInput(String label) {
		// TODO print label and return the user input 
		return null;
	}
	
	private boolean verifyCredentials(String login, String password) {
		return this.systemLogin.equals(login) && this.systemPassword.equals(password);
	}
	 
	private void readCredentialsFromFile() {
		// TODO read credentials from the file "res/zadanie1/skynet.conf"
		// and update systemLogin and systemPassword values 
	}
	
	private void printSkyNetLogo() {
		// TODO print logo from file "res/zadanie1/logo.txt"
	}
}
