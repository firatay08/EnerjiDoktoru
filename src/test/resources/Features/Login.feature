#language: tr
Özellik: Login Ekrani

  @Test
  Senaryo: Dogru kullanici bilgileri ile login islemi
    Diyelim ki "Login" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Ve 1 saniye beklersem
    Eğer ki "inputLoginMail" öğesine "fay@entes.com.tr" yazarsam
    Ve "inputLoginPassword" öğesine "123123" yazarsam
    Ve enter basarsam
    Ve 3 saniye beklersem
    O zaman "Fırat Ay" metnini görürüm
    #Ve tarayıcıyı kapatırım

  @Test
  Senaryo: Hatali kullanici bilgileri ile login islemi
    Diyelim ki "kullanici bul" sql cümlesini çalıştırırsam
    Ve "789789" değerini "@bu sifre" değişkenine atarsam
    Eğer ki "Login" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Ve 1 saniye beklersem
    Eğer ki "inputLoginMail" öğesine tıklarsam
    Ve "@bu email" yazarsam
    Ve "inputLoginPassword" öğesine tıklarsam
    Ve "@bu sifre" yazarsam
    Ve "giris" öğesine tıklarsam
    #Ve 1 saniye beklersem
    O zaman "Lütfen kullanıcı adınızı ve şifrenizi tekrar kontrol edin" metnini görürüm
    Ve tarayıcıyı kapatırım

