package steps;

import component.EnerjiDoktoru;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ve;


public class EnerjiDoktoruSteps extends EnerjiDoktoru{

    @Diyelimki("{string} ekranını açarsam")
    public void ekraniniAcarsam(String ekran) {
        openPage(ekran);
    }

    @Eğerki("{string} ekranını açıp login olursam")
    public void ekraniniAcipLoginOlursam(String ekran) {

    }

    @Ve("{string} ekranına gidersem")
    public void ekraninaGidersem(String ekran) { goToPage(ekran); }
}
