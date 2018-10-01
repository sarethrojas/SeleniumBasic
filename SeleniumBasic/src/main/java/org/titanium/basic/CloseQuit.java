package org.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {
    static String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
    static WebDriver driver;
    static String baseURL ="http://www.popuptest.com/popuptest2.html";
    public static void close(){
        driver = new ChromeDriver();
        driver.navigate().to(baseURL);
        driver.close();
    }
    public static void quit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        try {
            quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
