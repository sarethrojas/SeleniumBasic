package org.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //dar click en lik tv
        driver.findElement(By.linkText("TV")).click();

        //click en el boton Add to Cart
        driver.findElement(By.cssSelector("a[title=\"LG LCD\"]+div.product-info>div.actions>button.button")).click();

        actualResult = driver.findElement(By.cssSelector("td[class=\"product-cart-total\"]>span>span")).getText();

        if(actualResult.equals(expectedResult)){
            System.out.print("Prueba Exitosa! el resultado actual es " + actualResult + " es igual a " + expectedResult);
        }else{
            System.out.print("Prueba Exitosa! el resultado actual es " + actualResult + " No es igual a " + expectedResult);
        }
        driver.close();
    }
}
