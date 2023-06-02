package tek.capstone.dragons.pages;



public class POMFactory  {
	

	private RetailHomePage retailHomePage;
	private RetailSignInPage retailSignInPage;
	private RetailAccountPage retailAccountPage;
	private RetialOrderPage retailOrderPage;
	public POMFactory() {
		this. retailHomePage =  new RetailHomePage();
		this.retailSignInPage = new RetailSignInPage();
		this.retailAccountPage = new RetailAccountPage();
		this.retailOrderPage = new RetialOrderPage();
		
		}
	
	public  RetailHomePage  retailHomePage() {
		return this.retailHomePage;
		
	}
	public RetailSignInPage retailSignInPage() {
		return this.retailSignInPage;
	}
	public RetailAccountPage retailAccountPage() {
		return this.retailAccountPage;
	}
	public RetialOrderPage retailOrderpage() {
		return this.retailOrderPage;
	}
	
}