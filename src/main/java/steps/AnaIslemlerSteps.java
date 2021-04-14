package steps;

import component.AnaIslemler;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Ve;
import io.cucumber.java.tr.Ozaman;


public class AnaIslemlerSteps extends AnaIslemler {

    @Diyelimki("taryıcıyı açarsam")
    public void taryiciyiAcarsam() {
        openBrowser();
    }

    @Eğerki("{string} adresine gidersem")
    public void adresineGidersem(String link) {
        goToLink(link);
    }

//    @Ve("{string} sayfasının açıldığını görürüm")
//    public void sayfasininAcildiginiGorurum(String arg0) {
//    }

    @Ve("{string} öğesine tıklarsam")
    public void ogesineTiklarsam(String oge) {
        clickElement(oge);
    }

    @Ve("{string} metnine tıklarsam")
    public void metnineTiklarsam(String arg0) {
    }

    @Ve("{int} saniye beklersem")
    public void saniyeBeklersem(int deger) {
        pause(deger);
    }

    @Ve("enter basarsam")
    public void enterBasarsam() {
        pressEnter();
    }

    @Ozaman("{string} metnini görürüm")
    public void metniniGorurum(String metin) {
        seeText(metin);
    }

    @Ve("{string} öğesini temizlersem")
    public void ogesiniTemizlersem(String arg0) {
    }

    @Ve("{string} öğesine {string} yazarsam")
    public void ogesineYazarsam(String oge, String yazi) {
        textElement(oge,yazi);
    }


    @Ve("tarayıcıyı kapatırım")
    public void tarayiciyiKapatirim() {
        closeBrowser();
    }

    @Ve("{string} selectbox öğesinden {string} değerini seçersem")
    public void selectboxOgesindenDegeriniSecersem(String oge, String deger) {
        setSelecbox(oge, deger);
    }

//    @Ve("{string} öğesine rasgele mail oluşturup yazarsam")
//    public void ogesineRasgeleMailOlusturupYazarsam(String oge) {
//        textRandomMAil(oge);
//    }



    @Ve("{string} yazarsam")
    public void yazarsam(String metin) {
        write(metin);
    }


    @Ve("{string} değerini {string} değişkenine atarsam")
    public void degeriniDegiskenineAtarsam(String deger, String degisken) {
        saveValueAs(degisken, deger);
    }

    @Ve("{int} karakter uzunluğunda random {string} karakter üretip {string} olarak kaydedersem")
    public void randomKarakterUretipKaydedersem(int uzunluk, String tur, String degisken) {
        createRandomCharacter(uzunluk,tur,degisken);
    }

    @Ve("{string} tuşuna basarsam")
    public void tuşunaBasarsam(String tus) {
        pressKey(tus);
    }

    @Ve("dili {string} olarak değiştirirsem")
    public void diliOlarakDegistirirsem(String dil) {
        changeLanguage(dil);
    }

    @Ve("{string} öğesine focus yaparsam")
    public void ögesineFocusYaparsam(String element) {
        focusElement(element);
    }
}
