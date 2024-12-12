# 2N Test ve Otomasyon Projesi

Bu proje Java, Selenium Web Driver, TestNG, Cucumber teknolojileri kullanılarak hazırlanmış, Behavior Driven Development prensibi ile geliştirilmiş bir test otomasyon projesidir. 
Bütün geliştirme süreci boyunca SOLID ve OOP prensiplerine bağlı kalınmaya çalışılmıştır. Gherkin grammer yapısı kullanılarak otomasyon test senaryoları hazırlanmıştır. 
Testlerin koşulması için TestNG'nin sağladığı test suitelerinden yararlanılmıştır. www.2ntech.com.tr/hr ve  2nhaber.com'a ait test senaryolarını içeren testler gerekli ayarlamalar yapılarak 
tek bir projede koşulabilmektedir. Ayrıca İstenilen manuel test senaryoları, performans ve yük testi planı proje içerisinde Documents klasörü altındadır.

## Proje Yapısı

 ### Documents Klasörü:
 Manuel test senaryoları, manuel test dökümü, performans ve yük testi dosyalarını içermektedir. Bu kapsamdaki testler documents klasörü altında kategorilenmiştir.
 
 ### Test Otomasyonu:
 2N Haber ve 2NTech web sitelerine ait vaka çalışması dosyasında istenilen senaryoları içerir. 
 Vaka çalışmasında istenilen Navbar elementine ait testler manuel testlerde koşulduğu için burada yer verilmemiştir.
 Test sonuçlarına ait raporlar Cucumber'ın otomatik raporlama özelliği sayesinde farklı formatlarda görüntülenebilir.
 Mimari yeni test senaryolarının eklenmesi için uygundur. Bağımlılıklar maven aracığıyla yönetilmiştir.
 
 ### Test Otomasyonunun Çalıştırılması

*  Test otomasyonu iki farklı url'e ait iki farklı test senaryosundan oluşmaktadır. İlk olarak src > test > resources > config.properties dosyası üzerinden test edilmek istenen 
 web sitesine ait url seçilir. (örnek: url = https://www.2ntech.com.tr/hr )

 |<img src="https://github.com/aliigan/TestOtomation2N/blob/master/img/configProperties.png" >|
 


 * src > test > java > features dizininde seçtiğimiz web sitesine ait senaryoya gelinir. Test verileri güncellenir. Test senaryosuna ait tag kopyalanır. (örnek: @UserForm) 

  |<img src="https://github.com/aliigan/TestOtomation2N/blob/master/img/exampleFeature.png" >|

  

* src > main > java > testRunners > Runner Class'ına gelinerek kopyalanan tag @CucumberOptions içerisindeki tags kısmına yapıştırılır. Bu işlemi yapmadığımızda bütün testler çalıştırılacaktır.
  Fakat otomasyon içerisinde iki farklı url'ye test senaryoları olduğu için diğer url'ye ait testler fail olacaktır.

  |<img src="https://github.com/aliigan/TestOtomation2N/blob/master/img/runnerClass.png" >|

  

* src > test > resources içerindeki ilgili test suite gelinerek run işlemi yapılır ve test çalıştırılır.
  
  |<img src="https://github.com/aliigan/TestOtomation2N/blob/master/img/testSuite.png" >|


* Reports > Reports.html browser üzerinde açılarak Cucumber tarafından sağlanan raporlama özelliği ile test sonuçları gözlenebilmektedir.
  
  |<img src="https://github.com/aliigan/TestOtomation2N/blob/master/img/cucumberReport.png" >|

#### NOT: Proje localde ayağa kaldırılmadan önce src > test > java > testClasses > UserForm2NTECH uploadCV() {...} altındaki String filePath değişkeni örnek bir pdf dosyasının pathi ile değiştirilmelidir.

  
  
  


 
 

 
