package steps;

import component.EnerjiDoktoru;
import org.openqa.selenium.By;

public class test {
    public static void main (String args[]) {
        AnaIslemlerSteps a=new AnaIslemlerSteps();
        EnerjiDoktoruSteps e=new EnerjiDoktoruSteps();
        e.ekraniniAcarsam("KullaniciEkle");
        a.ogesineTiklarsam("advenced");
        a.ogesineTiklarsam("unsafe");
        a.saniyeBeklersem(2);
        a.ogesineYazarsam("inputLoginMail","firat.ay08@gmail.com");
        a.ogesineYazarsam("inputLoginPassword","123123");
        a.ogesineTiklarsam("giris");
        a.saniyeBeklersem(4);
        a.adresineGidersem("https://192.168.4.69/?/settings/users/list");
        int b=0;
        while (b<5) {
            a.saniyeBeklersem(4);
            a.ogesineTiklarsam("name");
            a.yazarsam("f");
            a.ogesineTiklarsam("name2");
            a.yazarsam("ırat");
            a.ogesineTiklarsam("surname");
            a.yazarsam("ay");
            a.ogesineTiklarsam("email");
            a.randomKarakterUretipKaydedersem(5, "alfabetik", "@bu mail");
            a.yazarsam("@bu mail");
            a.yazarsam("@gmail.com");
            a.ogesineTiklarsam("phone");
            a.yazarsam("3333333333");
            a.ogesineTiklarsam("organization");
            a.saniyeBeklersem(1);
            a.ogesineTiklarsam("avva");
            a.ogesineTiklarsam("roletype");
            a.saniyeBeklersem(1);
            a.ogesineTiklarsam("organizasyon sorumlusu");
            a.ogesineTiklarsam("kaydet");
            b++;
        }

    return;
    }

}
