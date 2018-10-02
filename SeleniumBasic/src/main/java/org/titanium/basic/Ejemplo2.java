package org.titanium.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejemplo2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        WebDriverWait waitVar = new WebDriverWait(driver, 10);

        try {
        driver.switchTo().frame("iframeResult");
        WebElement btnTry = driver.findElement(By.xpath("/html/body/button"));
        waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
        btnTry.click();
        Thread.sleep(4000);

        waitVar.until(ExpectedConditions.alertIsPresent());
        Alert alrtWindow = driver.switchTo().alert();
        String alrtText = alrtWindow.getText();
        System.out.println(alrtText);
        alrtWindow.sendKeys("Sareth R");
        alrtWindow.accept();

        String finalText = driver.findElement(By.id("demo")).getText();
        System.out.println(finalText.contains("Sareth")?finalText:"Prueba fallida!");

        }catch (NoSuchElementException ne){
            System.err.println("No se encontro el Webelement" + ne.getMessage());
        }catch (NoSuchFrameException fe){
            System.err.println("No se encontro el frame" + fe.getMessage());
        }catch (NoAlertPresentException na){
            System.err.println("No se encontro la alerta" + na.getMessage());
        }catch (TimeoutException te){
            System.err.println("Tiempo de espera excedido" + te.getMessage());
        }catch (WebDriverException we){
            System.err.println("Webdriver fallo" + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            driver.quit();
        }

    }
}
