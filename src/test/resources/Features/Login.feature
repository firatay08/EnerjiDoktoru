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
    Ve "giris" öğesine tıklarsam
    Ve 3 saniye beklersem
    O zaman "Fırat Ay" metnini görürüm
#    Ve tarayıcıyı kapatırım

  @Test
  Senaryo: Hatali kullanici bilgileri ile login islemi(EN)
    Diyelim ki "kullanici bul" sql cümlesini çalıştırırsam
    Ve "789789" değerini "@bu sifre" değişkenine atarsam
    Eğer ki "Login" ekranını açarsam
#    Ve "advenced" öğesine tıklarsam
#    Ve "unsafe" öğesine tıklarsam
    Ve 1 saniye beklersem
    Ve dili "EN" olarak değiştirirsem
    Eğer ki "inputLoginMail" öğesine tıklarsam
    Ve "@bu email" yazarsam
    Ve "inputLoginPassword" öğesine tıklarsam
    Ve "@bu sifre" yazarsam
    Ve "giris" öğesine tıklarsam
    O zaman "@bu login_hata_mesaji" metnini görürüm
    Ve tarayıcıyı kapatırım



  @Test
  Senaryo: Hatali kullanici bilgileri ile login islemi(TR)
    Diyelim ki "kullanici bul" sql cümlesini çalıştırırsam
    Ve "789789" değerini "@bu sifre" değişkenine atarsam
    Eğer ki "Login" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve 2 saniye beklersem
    Ve "unsafe" öğesine tıklarsam
    Ve 1 saniye beklersem
    Eğer ki "inputLoginMail" öğesine tıklarsam
    Ve "@bu email" yazarsam
    Ve "inputLoginPassword" öğesine tıklarsam
    Ve "@bu sifre" yazarsam
    Ve "giris" öğesine tıklarsam
    O zaman "@bu login_hata_mesaji" metnini görürüm
    Ve tarayıcıyı kapatırım

  @Test
  Senaryo: Birden fazla tarayıcı ile dene
    Diyelim ki "Login" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve 2 saniye beklersem
    Ve "unsafe" öğesine tıklarsam
    Ve 1 saniye beklersem
    Eğer ki "inputLoginMail" öğesine tıklarsam
    Ve "fay@entes.com.tr" yazarsam
    Ve "inputLoginPassword" öğesine tıklarsam
    Ve "123123" yazarsam
    Ve "giris" öğesine tıklarsam
    Ve 2 saniye beklersem
    Ve "afd" öğesine focus yaparsam
    Ve "test" öğesine tıklarsam
    Ve 5 saniye beklersem
