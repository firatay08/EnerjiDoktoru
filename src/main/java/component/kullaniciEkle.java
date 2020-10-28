package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class kullaniciEkle {
    public static WebDriver webDriver;
    public static void main (String args[]) {
        EnerjiDoktoru e=new EnerjiDoktoru();
        e.openBrowser();
        e.goToLink("https://192.168.4.69/?/settings/users/list");
        webDriver.findElement(By.xpath("//*[@id='details-button']")).click();
        webDriver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        int a=1;
        while(a<4){
            System.out.println(a);
            a++;
        }
    }
}
