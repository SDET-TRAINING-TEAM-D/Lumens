package Stepdef;

import java.util.List;
import java.util.Map;

import com.lumen.pages.Basepage;
import com.lumen.pages.Homepage;
import com.lumen.pages.Loginpage;
import com.lumen.util.ExcelReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Loginlivestep extends Basepage{

	Loginpage loginpage;
	Homepage  homepage;
	
	public Loginlivestep() {
		super();
	}
	
	
	@Given("^user Lumen login livechat  Page open the browser$")
	public void user_Lumen_login_livechat_Page_open_the_browser() throws Throwable {
		 Basepage.browserlaunch();
		 loginpage  = new Loginpage();
		 loginpage.registerpoppup();
		 loginpage.register();
		 homepage = new Homepage();
	}

	@Then("^user Lumen login livechat  Page enters the username \"([^\"]*)\" and password (\\d+)$")
	public void user_Lumen_login_livechat_Page_enters_the_username_and_password(String sheetName, int rowNumber) throws Throwable {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:\\\\Users\\\\NEOTECH\\\\Downloads\\\\lumens assesment\\\\lumens assesment\\\\UserData.xlsx",  sheetName);
		String mail = testData.get(rowNumber).get("mail");
		String password = testData.get(rowNumber).get("password");
		loginpage.loginsetup(mail,password);
	}

	@Then("^user Lumen login livechat  Page click on Login button$")
	public void user_Lumen_login_livechat_Page_click_on_Login_button() throws Throwable {
		loginpage.submitbutton();
	}

	@Then("^user  Lumen login livechat  Page$")
	public void user_Lumen_login_livechat_Page() throws Throwable {
		homepage.getlivechat();
	}

	
	
	
	
	
	
	
	
}
