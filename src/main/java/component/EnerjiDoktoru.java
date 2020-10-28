package component;


public class EnerjiDoktoru extends AnaIslemler {

    JsonIslemleri json=new JsonIslemleri();

    public void openPage(String ekranIsmi){
        String url="https://192.168.4.69"+json.getUrl(ekranIsmi);
        Degiskenler.acilanEkran=ekranIsmi;
        openBrowser();
        goToLink(url);
    }
}
