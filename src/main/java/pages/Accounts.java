package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Accounts extends LoadableComponent<Accounts>{

	private WebDriver driver;

	By ADMINS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/admins/']");
	By SUPPLIERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/admins/']");
	By CUSTOMERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/customers/']");
	By GUESTCUSTOMERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/guest/']");

	public Accounts(WebDriver driver) {
		this.driver = driver;
	}

	public CustomerManagement clickCustomers() {
		driver.findElement(this.CUSTOMERS).click();
		return new CustomerManagement(driver);
	}

	@Override
	protected void isLoaded() throws Error {
		
	}

	@Override
	protected void load() {
		
	}
}