package steps;

import component.SqlIslemleri;
import io.cucumber.java.tr.Diyelimki;



public class SqlIslemleriSteps extends SqlIslemleri {

    @Diyelimki("{string} sql cümlesini çalıştırırsam")
    public void sqlCumlesiniCalistirirsam(String key) {
        findQuery(key);
    }
}
