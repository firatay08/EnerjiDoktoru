#language: tr
Özellik: Login Ekrani

  @Test
  Senaryo: Kullanici ekle
    Diyelim ki "KullaniciEkle" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Ve 2 saniye beklersem
    Eğer ki "inputLoginMail" öğesine "firat.ay08@gmail.com" yazarsam
    Ve "inputLoginPassword" öğesine "123123" yazarsam
    Ve "giris" öğesine tıklarsam
    Ve 4 saniye beklersem
    Ve "https://192.168.4.69/?/settings/users/list" adresine gidersem
    Ve 5 saniye beklersem
    Ve "name" öğesine tıklarsam
    Ve "f" yazarsam
    Ve "name2" öğesine tıklarsam
    Ve "ırat" yazarsam
    Ve "surname" öğesine tıklarsam
    Ve "ay" yazarsam
    Ve "email" öğesine tıklarsam
    Ve 5 karakter uzunluğunda random "alfabetik" karakter üretip "@bu mail" olarak kaydedersem
    Ve "@bu mail" yazarsam
    Ve "@gmail.com" yazarsam
    Ve "phone" öğesine tıklarsam
    Ve "3333333333" yazarsam
    Ve "organization" öğesine tıklarsam
    Ve 1 saniye beklersem
    Ve "avva" öğesine tıklarsam
    Ve "roletype" öğesine tıklarsam
    Ve 1 saniye beklersem
    Ve "organizasyon sorumlusu" öğesine tıklarsam
    Ve "kaydet" öğesine tıklarsam
    Ve tarayıcıyı kapatırım