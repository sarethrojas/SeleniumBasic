package org.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forms {
    static WebDriver driver;

    public static void main(String[] args){
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }
}
