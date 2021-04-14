#language: tr
Özellik: Olay Kayitlari Ekrani

  @Test
  Senaryo: Olay Kayitlari Goruntuleme
    Diyelim ki "OlayKayitlari" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Ve 2 saniye beklersem
    Eğer ki "inputLoginMail" öğesine "fay@entes.com.tr" yazarsam
    Ve "inputLoginPassword" öğesine "123123" yazarsam
    Ve "giris" öğesine tıklarsam
    Ve 3 saniye beklersem
    Ve "avatar" öğesine focus yaparsam
    Ve "donanimlarim" öğesine tıklarsam
    Ve 5 saniye beklersem
    Ve "uc nokta gercek" öğesine tıklarsam
    Eğer ki "olay kayitlari gercek" öğesine tıklarsam
    Ve 5 saniye beklersem
    O zaman "Olay Kayıtları" metnini görürüm
    Ve "tablo icerik" öğesine tıklarsam
    Ve "uc nokta2" öğesine tıklarsam
    Ve 1 saniye beklersem
    Ve "exzele aktar" öğesine tıklarsam


  @Test
  Senaryo: Olay Kayitlari Olmayan Cihaz
    Diyelim ki "OlayKayitlari" ekranını açarsam
    Ve "advenced" öğesine tıklarsam
    Ve "unsafe" öğesine tıklarsam
    Ve 2 saniye beklersem
    Eğer ki "inputLoginMail" öğesine "fay@entes.com.tr" yazarsam
    Ve "inputLoginPassword" öğesine "123123" yazarsam
    Ve "giris" öğesine tıklarsam
    Ve 3 saniye beklersem
    Ve "avatar" öğesine focus yaparsam
    Ve "donanimlarim" öğesine tıklarsam
    Ve 5 saniye beklersem
    Ve "uc nokta sallama" öğesine tıklarsam
    Eğer ki "olay kayitlari sallama" öğesine tıklarsam
    Ve 5 saniye beklersem
    O zaman "     Veri Yok" metnini görürüm