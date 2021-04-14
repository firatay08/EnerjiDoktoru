package component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonIslemleri {
    public String getUrl(String elementKey){
        String sonuc = (String) getDataFile("Jsons/"+elementKey+".json").get("url");
        return sonuc;
    }


    public String getElement(String elementKey){
        String sonuc = (String) getDataFile("Jsons/"+Degiskenler.acilanEkran+ ".json").get(elementKey);
        return sonuc;
    }
    public String getQuery(String elementKey){
        String sonuc=(String) getDataFile("sql.json").get(elementKey);
        return sonuc;
    }
    public String getConfig(String elementKey){
        String sonuc=(String) getDataFile("config.json").get(elementKey);
        return sonuc;
    }

    protected JSONObject getDataFile(String dataFileName) {
        String dataFilePath = "src/test/resources/";
        JSONObject testObject = null;

        try {
            FileReader reader = new FileReader(dataFilePath + dataFileName);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            testObject = (JSONObject) jsonObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testObject;
    }



    public String getDataText(String elementKey){
        JSONParser jsonP = new JSONParser();

        try(FileReader reader = new FileReader("src/test/resources/metin.json")){
            //Read JSON File
            Object obj = jsonP.parse(reader);
            JSONArray empList = (JSONArray) obj;

            //Iterate over emp array
            empList.forEach(emp ->parseEmpObj((JSONObject)emp,elementKey,Degiskenler.dilSecimi));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Degiskenler.arananMetin;
    }

    public static void parseEmpObj(JSONObject emp, String key, String dil) {
        JSONObject empObj = (JSONObject) emp.get("metinler");
        String gelenDegisken = (String) empObj.get("degisken");
        if (gelenDegisken.equals(key)) {
            if (dil.equals("TR")) {
                String gelenTr = (String) empObj.get("TR");
                System.out.println(gelenTr);
                Degiskenler.arananMetin=gelenTr;
            } else if (dil.equals("EN")) {
                String gelenEn = (String) empObj.get("EN");
                System.out.println(gelenEn);
                Degiskenler.arananMetin=gelenEn;
            }
        }
    }
}



