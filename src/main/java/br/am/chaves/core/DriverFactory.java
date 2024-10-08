package br.am.chaves.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory(){}

    public static WebDriver getDriver(){
        if (driver == null) {
            switch (Propriedades.BROWSER){
                case CHROME: driver = new ChromeDriver(); break;
                case FIREFOX: driver = new FirefoxDriver(); break;
                case EDGE: driver = new EdgeDriver(); break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
