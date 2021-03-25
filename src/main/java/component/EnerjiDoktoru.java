package component;


public class EnerjiDoktoru extends AnaIslemler {

    JsonIslemleri json=new JsonIslemleri();

    public void openPage(String ekranIsmi){
        String url=json.getConfig("url_body")+json.getUrl(ekranIsmi);
        Degiskenler.acilanEkran=ekranIsmi;
        openBrowser();
        goToLink(url);
    }

    public void goToPage(String ekranIsmi){
        String url=json.getConfig("url_body")+json.getUrl(ekranIsmi);
        Degiskenler.acilanEkran=ekranIsmi;
        goToLink(url);
    }
}
