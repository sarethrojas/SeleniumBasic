package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Forms {
    static WebDriver driver;

    public static void main(String[] args){
        String baseURL = "http://newtours.demoaut.com";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try{
            driver.findElement(By.linkText("REGISTER")).click();

            WebElement txtfirstname = driver.findElement(By.name("firstName"));
            Thread.sleep(1500);
            txtfirstname.clear();
            Thread.sleep(1500);
            txtfirstname.sendKeys("Sareth");

            driver.findElement(By.name("address1")).sendKeys("Test address");

            Select drpCountry = new Select(driver.findElement(By.name("country")));
            drpCountry.selectByVisibleText("BAHAMAS");
            Thread.sleep(1500);

            driver.findElement(By.name("email")).sendKeys("sarethrojas@mail.com");
            driver.findElement(By.name("password")).sendKeys("abc1234");

            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            txtConfirmPass.sendKeys("abc1234");
            txtConfirmPass.submit();

            System.out.println("Prueba Exitosa! " + driver.findElement(By.xpath("//b[contains(text(),\"Note:\")]")).getText());

        }catch(NoSuchElementException ne){
            System.err.println("No se encontró el WebElement" + ne.getMessage());
        }catch (WebDriverException we){
            System.err.println("WebDriver falló" + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.close();
        }


    }
}
