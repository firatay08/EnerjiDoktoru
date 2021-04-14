package component;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

        JsonIslemleri jsonIslemleri=new JsonIslemleri();
        String tarayici= jsonIslemleri.getConfig("browser");
        System.out.println(tarayici+" açılıyor...");
        if("chrome".equals(tarayici)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);
        }
        else if("firefox".equals(tarayici)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--start-maximized");
            webDriver = new FirefoxDriver(options);
        }
        else if("internet explorer".equals(tarayici)) {
            WebDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver();
        }
        else if("microsoft edge".equals(tarayici)){
            WebDriverManager.edgedriver().setup();
            EdgeOptions options= new EdgeOptions();
            options.addArguments("--start-maximized");
            webDriver=new EdgeDriver(options);
        }
        else if("safari".equals(tarayici)){
            WebDriverManager.operadriver().setup();
            OperaOptions options= new OperaOptions();
            options.addArguments("--start-maximized");
            webDriver=new OperaDriver(options);
        }
        else if("opera".equals(tarayici)) {
            System.setProperty("webdriver.opera.driver","src/test/resources/Browser/operadriver.exe");
            WebDriver webDriver;
            webDriver=new OperaDriver();
            webDriver.manage().window().maximize();
//            WebDriverManager.operadriver().setup();
//            OperaOptions options=new OperaOptions();
//            options.addArguments("--start-maximized");
//            webDriver = new OperaDriver(options);
        }
         else {
            System.out.println(tarayici +" Tarayıcısı bulunamadı");
        }
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
        JsonIslemleri json=new JsonIslemleri();
        String textValue=text;
        if(text.contains("@bu") ){
            if (Degiskenler.getJson(text)!=null){
                textValue=Degiskenler.getJson(text).toString(); //bu isinde değişken varsa onu alır
            }
            else{
                textValue=json.getDataText(text); //bu isimde metin.json' da tanımlanmış öğe varsa onu alır
            }
        }
        String newText="//*[contains(text(),'"+textValue+"')]";
        int counter=0;
        while(true) {//bekleme süresi için döngüye alındı
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
    public void changeLanguage(String lang){

        Degiskenler.dilSecimi=lang;
        //Angular kısmı, bu kısım için ekstra çalışma yapılacak
        int elementCount = webDriver.findElements(By.xpath("//app-language")).size();
        if(elementCount>0) {
            WebElement webElement = webDriver.findElement(By.xpath("//app-language"));
            webElement.click();
            //webElement = webDriver.findElement(By.xpath("//div[@class='flag'][text()='EN']"));
            //webElement.click();
        }
        else{
            if ("TR".equals(lang)) {
                WebElement webElement = webDriver.findElement(By.xpath("//div[@class='flag'][text()='TR']"));
                webElement.click();
                webElement = webDriver.findElement(By.xpath("//div[@class='flag'][text()='EN']"));
                webElement.click();
            } else if ("EN".equals(lang)) {
                WebElement webElement = webDriver.findElement(By.xpath("//div[@class='flag'][text()='TR']"));
                webElement.click();
                webElement = webDriver.findElement(By.xpath("//div[@class='flag'][text()='EN']"));
                webElement.click();
            }
        }
    }

    public void focusElement(String element){
        JsonIslemleri jsonIslemleri= new JsonIslemleri();
        String xpath= jsonIslemleri.getElement(element);
        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(By.xpath(xpath))).build().perform();

    }

}
