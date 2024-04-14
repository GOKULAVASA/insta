package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver localdriver;
public Loginpage(WebDriver remotedriver){
	localdriver=remotedriver;
	PageFactory.initElements(remotedriver, this);
}

	@FindBy(xpath="//input[@name='username']")
	WebElement usernameOrEmailTxtBx;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTxtBx;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath="//div[@class='x1n2onr6']")
	WebElement ProfileBtn;
	
	public void enterUserEmail(String email) {
		usernameOrEmailTxtBx.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		passwordTxtBx.sendKeys(pass);
	}
	public void clickLoginBtn() {
		Loginbtn.click();
	}
	public void clickProfileIcon() {
		ProfileBtn.click();
	}
}
