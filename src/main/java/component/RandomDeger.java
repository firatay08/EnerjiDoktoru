package component;

import java.security.SecureRandom;

public class RandomDeger {

    static final String rakam = "0123456789";
    static final String harf ="abcdefghijklmnopqrstuvwxyz";
    static final String karakter =rakam+harf;
    static SecureRandom rnd = new SecureRandom();

    public void createVeriable(int len, String type, String key){

        type=type.toUpperCase();
        StringBuilder sb = new StringBuilder( len );
        if(type.equals("NUMERIK") || type.equals("NUMERİK")) {
            for (int i = 0; i < len; i++)
                sb.append(rakam.charAt(rnd.nextInt(rakam.length())));
        }
        else if(type.equals("ALFABETIK") || type.equals("ALFABETİK")) {
            for (int i = 0; i < len; i++)
                sb.append(harf.charAt(rnd.nextInt(harf.length())));
        }
        else if(type.equals("ALFANUMERIK") || type.equals("ALFANUMERİK")) {
            for (int i = 0; i < len; i++)
                sb.append(karakter.charAt(rnd.nextInt(karakter.length())));
        }
        Degiskenler.putJson(key,sb.toString());
    }
}