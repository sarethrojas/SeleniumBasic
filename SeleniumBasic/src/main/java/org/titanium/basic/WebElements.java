package org.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL = "http://live.guru99.com/index.php/checkout/cart";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //dar click en lik tv
        WebElement lnkTV = driver.findElement(By.linkText("TV"));
        lnkTV.click();


        //click en el boton Add to Cart
        WebElement btnAddToCart = driver.findElement(By.cssSelector("a[title=\"LG LCD\"]+div.product-info>div.actions>button.button"));
        btnAddToCart.click();

        WebElement lblSubtotal =driver.findElement(By.cssSelector("td[class=\"product-cart-total\"]>span>span"));

        if(lblSubtotal.getText().equals(expectedResult)){
            System.out.print("Prueba Exitosa! el resultado actual es " + lblSubtotal.getText() + " es igual a " + expectedResult);
        }else{
            System.out.print("Prueba Exitosa! el resultado actual es " + lblSubtotal.getText() + " No es igual a " + expectedResult);
        }
        driver.close();
    }
}
