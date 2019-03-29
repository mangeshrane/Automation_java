package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class DashBoard extends LoadableComponent<DashBoard> {

	WebDriver driver;

	By accounts = By.xpath(
			"//body/div[@class='wrapper']/aside[@class='social-sidebar']/div/div[6]/div[@class='menu-content']/ul[@id='social-sidebar-menu']//a[@href='#ACCOUNTS']");

	public By checkpoint = By.xpath(
			"/html//ul[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin']/strong[.='Dashboard']");

	public DashBoard(WebDriver driver) {
		this.driver = driver;
	}

	public Accounts clickAccounts(WebDriver driver) {
		driver.findElement(this.accounts).click();
		return new Accounts(driver);
	}

	/*
	 * Loadable Component Methods
	 */

	@Override
	protected void isLoaded() throws Error {

	}

	@Override
	protected void load() {

	}

}
