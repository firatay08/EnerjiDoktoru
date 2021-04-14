package component;

import org.json.simple.JSONObject;

public class Degiskenler {
    public static String acilanEkran;
    public static String sonTiklananOge;
    public static String dilSecimi="TR";
    public static int beklemeSuresi=20;
    public static String arananMetin;
    public static JSONObject jsonObject = new JSONObject();

    public static void yazobjeyi(){ System.out.println(jsonObject);}

    public static void putJson(String key, String value){
        jsonObject.put(key,value);
    }

    public static Object getJson(String key){
        return jsonObject.get(key);
    }

    public static String cleanKey(String key){
        if(key.contains("bu") ){
            key= key.substring(4, key.length());
        }
        return key;
    }
}