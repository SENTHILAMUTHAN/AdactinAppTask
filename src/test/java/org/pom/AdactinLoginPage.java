package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPage extends BaseClass{
	
	public AdactinLoginPage() {

	PageFactory.initElements(driver, this);
		
	}

	@FindBy (id="username")
	private WebElement userNameTxt;
	
	@FindBy (id="password")
	private WebElement passWordTxt;
	
	@FindBy (xpath="//a[@href=\"ForgotPassword.php\"]")
	private WebElement forgotPassWord;
	
	@FindBy (id="login")
	private WebElement loginBtn;
	
	@FindBy (xpath="//a[contains(text(),'Register')]")
	private WebElement newRegistration;
	
	@FindBy (xpath="(//strong[contains(text(),'Build')])[2]")
	private WebElement diffBuild;

	public WebElement getUserNameTxt() {
		return userNameTxt;
	}

	public WebElement getPassWordTxt() {
		return passWordTxt;
	}

	public WebElement getForgotPassWord() {
		return forgotPassWord;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getNewRegistration() {
		return newRegistration;
	}

	public WebElement getDiffBuild() {
		return diffBuild;
	}
	
	
}
