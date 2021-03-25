package component;

import com.datastax.driver.core.*;
import com.datastax.driver.core.ResultSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.testng.Assert;

import static org.junit.Assert.fail;


public class SqlIslemleri {


    public static void executeQuery(String query) {

        Cluster cluster;
        Session session;
        try {
            JsonIslemleri json=new JsonIslemleri();
            JsonArray conf = new JsonArray();
            // Cluster ve keyspace 'e bağlanıyoruz "entwatch_cross"
            cluster = Cluster.builder().addContactPoint(json.getConfig("database_ip")).withPort(Integer.parseInt(json.getConfig("database_port"))).withAuthProvider(new PlainTextAuthProvider(json.getConfig("database_username"), json.getConfig("database_password"))).build();
            session = cluster.connect(json.getConfig("database_keyspace"));

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
                Degiskenler.yazobjeyi();
            }

            cluster.close();
        }
        catch(Exception e) {
            System.out.println("sql hatası: " + e);
            //Assert.assertTrue(false);
            fail();
        }


    }
    public void findQuery(String key){
        JsonIslemleri jsonIslemleri =new JsonIslemleri();
        String query=jsonIslemleri.getQuery(key);
        executeQuery(query);
    }
}