package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions{
           static WebDriver driver;
        public static void main(String[] args){

            String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            String baseURL = "http://live.guru99.com/index.php/checkout/cart";
            String expectedResult = "$615.00";
            String actualResult = "";
            try{


                driver = new ChromeDriver();
                driver.get(baseURL);
                driver.manage().window().maximize();

                //dar click en lik tv
                WebElement lnkTV = driver.findElement(By.linkText("TV"));
                lnkTV.click();

                //click en el boton Add to Cart
                WebElement btnAddToCart = driver.findElement(By.cssSelector("a[title=\"LG LCD\"]+div.product-info>div.actions>button.button"));
                btnAddToCart.click();


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
