package org.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
    //Instanciar un objeto Webdriver= interfaz
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

        //Abrir el navegador
        driver = new ChromeDriver();
    }
}
