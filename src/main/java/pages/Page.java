package pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.DriverProvider;

public class Page {

	private ConcurrentHashMap<WebDriver, ConcurrentHashMap<String, Object>> pageHashMap = new ConcurrentHashMap<>();

	private synchronized void setPageHashMap(WebDriver driver, String pageName, Object obj) {
		if (!pageHashMap.containsKey(driver)) {
			ConcurrentHashMap<String, Object> pageHashMapPageNamePageObj = new ConcurrentHashMap<>();
			pageHashMapPageNamePageObj.put(pageName, obj);
			pageHashMap.put(driver, pageHashMapPageNamePageObj);
		} else {
			if (!pageHashMap.get(driver).containsKey(pageName)) {
				pageHashMap.get(driver).put(pageName, obj);
			}
		}
	}

	private synchronized Object getPageHashMap(WebDriver driver, String pageName) {
		if (pageHashMap.containsKey(driver)) {
			return pageHashMap.get(driver).get(pageName);
		} else {
			return null;
		}
	}

	// This method creates a new screen with given Screen Name and Screen Class
	// parameters
	private synchronized <TPage extends LoadableComponent<TPage>> TPage createPage(String pageName,
			Class<TPage> Clazz) {
		TPage tPage = (TPage) getPageHashMap(DriverProvider.getDriver(), pageName);
		if (tPage != null) {
			return tPage;
		} else {
			tPage = instantiateNewPage(DriverProvider.getDriver(), Clazz);
			setPageHashMap(DriverProvider.getDriver(), pageName, tPage.get());
			return (TPage) getPageHashMap(DriverProvider.getDriver(), pageName);
		}
	}

	// This Method Instantiates a new screen. I got this method from PageFactory
	// Class and modify it.
	private static <TPage extends LoadableComponent<TPage>> TPage instantiateNewPage(WebDriver driver,
			Class<TPage> Clazz) {
		try {
			try {
				Constructor<TPage> constructor = Clazz.getConstructor(WebDriver.class);
				return constructor.newInstance(driver);
			} catch (NoSuchMethodException var3) {
				return Clazz.newInstance();
			}
		} catch (InstantiationException var4) {
			throw new RuntimeException(var4);
		} catch (IllegalAccessException var5) {
			throw new RuntimeException(var5);
		} catch (InvocationTargetException var6) {
			throw new RuntimeException(var6);
		}
	}
	
	
	/**
	 * Getting By using @FindBy attribute 
	 * @param fieldName
	 * @return By element 
	 */
	private By getBy(String fieldName) {
	       try {
	            return new Annotations(this.getClass().getDeclaredField(fieldName)).buildBy();
	       } catch (NoSuchFieldException e) { return null; }
	   }

	/*
	 * public synchronized HomePage homePage() { return createPage("homePage",
	 * HomePage.class); }
	 * 
	 * public synchronized LoginPage loginPage() { return
	 * createPage("loginPage", LoginPage.class); }
	 */
}