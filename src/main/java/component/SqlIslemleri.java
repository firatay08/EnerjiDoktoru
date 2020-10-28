package component;

import com.datastax.driver.core.*;
import com.datastax.driver.core.ResultSet;
import org.testng.Assert;


public class SqlIslemleri {

    public static void executeQuery(String query) {
        Cluster cluster;
        Session session;
        try {
            // Cluster ve keyspace 'e bağlanıyoruz "entwatch_firat"
            cluster = Cluster.builder().addContactPoint("192.168.4.69").withPort(9042).withAuthProvider(new PlainTextAuthProvider("cassandra", "Ente$2019")).build();
            session = cluster.connect("entwatch_firat");

            ResultSet results = session.execute(query);

            for (Row row : results) {
                for(int i=0;i<row.getColumnDefinitions().size();i++) {
                    String key="@bu "+row.getColumnDefinitions().getName(i);
                    System.out.println(key);
                    switch(row.getColumnDefinitions().getType(i).toString()) {
                        case "varchar":
                            Degiskenler.putJson(key,row.getString(i));
                            break;
                        case "int":
                            Degiskenler.putJson(key,String.valueOf(row.getInt(i)));
                            break;
                        case "timestamp":
                            Degiskenler.putJson(key,row.getTimestamp(i).toString());
                            break;
                        case "boolean":
                            Degiskenler.putJson(key,String.valueOf(row.getBool(i)));
                            break;
                    }

                }
                //Degiskenler.yazobjeyi();
            }

            cluster.close();
        }
        catch(Exception e) {
            System.out.println("sql hatası");
            Assert.assertTrue(false);
        }


    }
    public void findQuery(String key){
        JsonIslemleri jsonIslemleri =new JsonIslemleri();
        String query=jsonIslemleri.getQuery(key);
        executeQuery(query);
    }
}
