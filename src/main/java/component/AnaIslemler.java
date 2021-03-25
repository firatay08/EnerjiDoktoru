package component;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class AnaIslemler {

    public static WebDriver webDriver;

    public WebElement webElement(String Locator){
        JsonIslemleri jsonIslemleri=new JsonIslemleri();
        WebElement webElement;
        try {
            webElement=webDriver.findElement(By.xpath(jsonIslemleri.getElement(Locator)));
        }
        catch (Exception e){
            webElement=webDriver.findElement(By.id(Locator));
        }
        return webElement;
    }


    public void openBrowser(){
        System.out.println("Tarayıcı açılıyor...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver( options );
    }


    public void closeBrowser(){
        System.out.println("Tarayıcı kapatılıyor...");
        webDriver.close();
    }


    public void goToLink(String link){
        webDriver.get(link);
    }


    public void pause(Integer seconds){
        try {
            int milliseconds=seconds*1000;
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickElement(String element){
        Degiskenler.sonTiklananOge=element;
        webElement(element).click();
    }


    public void pressEnter()  {
        webElement(Degiskenler.sonTiklananOge).sendKeys(Keys.ENTER);
    }

    public void pressKey(String key)  {
        switch(key) {
            case "tab":
                webElement(Degiskenler.sonTiklananOge).sendKeys(Keys.TAB);
                break;
            case "space":
                webElement(Degiskenler.sonTiklananOge).sendKeys(Keys.SPACE);
                break;
            default:
                // code block
        }
    }


    public void clickText(String text){
        String newText="//*[text()='"+text+"']";
        webDriver.findElement(By.xpath(newText)).click();
    }


    public void logconsole(String message){
        System.out.println(message);
    }


    public void checkThePage(String page){
        if(webDriver.getTitle() != null && webDriver.getTitle().contains(page)){
            System.out.println("Tarayıcı açıldı.");
        }
        else{
            System.out.println("Tarayıcı açılamadı.");
            Assert.assertTrue(false);
        }
    }


    public void clearElement(String element){
        webDriver.findElement(By.xpath(element)).clear();
    }


    public void textElement(String element, String text){
        Degiskenler.sonTiklananOge=element;
        webElement(element).sendKeys(text);

    }


    public void seeText(String text){
        String newText="//*[contains(text(),'"+text+"')]";
        int counter=0;
        while(true) {
            By countInstructors = By.xpath(newText);
            int elementCount = webDriver.findElements(countInstructors).size();
            if (elementCount>0)
                break;
            else if (counter>Degiskenler.beklemeSuresi) {
                Assert.assertTrue(false);
            }
            counter++;
            pause(1);
        }
    }


    public void setSelecbox(String element, String value){
        //JsonIslemleri json=new JsonIslemleri();
        WebElement test =webDriver.findElement(By.id("#Ecom_Payment_Card_ExpDate_Month"));
        Select dropdown = new Select(test);
        dropdown.selectByIndex(4);
    }



    public void write(String text){
        if(text.contains("@bu") ){
            text=Degiskenler.getJson(text).toString();
        }
        JsonIslemleri json=new JsonIslemleri();

        try {
            webDriver.findElement(By.xpath(json.getElement(Degiskenler.sonTiklananOge))).sendKeys(text);
        }
        catch (Exception e){
            webDriver.findElement(By.id(Degiskenler.sonTiklananOge)).sendKeys(text);
        }
    }


    public void saveValueAs(String key, String value){
        Degiskenler.putJson(key, value);
    }

    public void createRandomCharacter(int lengt, String type, String key){
        RandomDeger randomDeger=new RandomDeger();
        randomDeger.createVeriable(lengt,type,key);

    }

}
