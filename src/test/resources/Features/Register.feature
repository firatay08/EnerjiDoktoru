#language: tr
Özellik: Register Ekrani


  @Test
  Senaryo: Kayit ol
    Diyelim ki "Register" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Eğer ki "inputRegisterName" öğesine tıklarsam
    Ve "test" yazarsam
    Ve "inputRegisterSurName" öğesine tıklarsam
    Ve "test" yazarsam
    Ve "inputRegisterPhone" öğesine tıklarsam
    Ve "1111111111" yazarsam
    Ve "inputRegisterMail" öğesine tıklarsam
    Ve 7 karakter uzunluğunda random "alfabetik" karakter üretip "@bu mail" olarak kaydedersem
    Ve "@bu mail" yazarsam
    Ve "@test.com.tr" yazarsam
    Ve "inputRegisterPassword" öğesine tıklarsam
    Ve "123123" yazarsam
    Ve "inputRegisterRePassword" öğesine tıklarsam
    Ve "123123" yazarsam
    Ve 1 saniye beklersem
    Eğer ki "inputRegisterRePassword" öğesine tıklarsam
    Ve "tamamla" öğesine tıklarsam
    O zaman "Kullanıcı oluşturuldu" metnini görürüm
    Ve tarayıcıyı kapatırım

  @Test
  Senaryo: Kayit ol test1
    Diyelim ki 23 karakter uzunluğunda random "alfaBETıK" karakter üretip "@bu sayi" olarak kaydedersem
    Ve "Register" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Eğer ki "inputRegisterName" öğesine tıklarsam
    Ve "@bu sayi" yazarsam