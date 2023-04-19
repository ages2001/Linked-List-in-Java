
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) {
        
        DoublyLinkedList ogrenciListesi = new DoublyLinkedList(); // DoublyLinkedList olusturuldu 
        
        // Gerekli giris (scanner) degiskenleri olusturuldu 
        Scanner scannerIslem = new Scanner(System.in);
        Scanner scannerStr1 = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        
        System.out.println("""
                           Programa hosgeldiniz! 
                           
                           Algoritma ve Programlama - II
                           Proje - 1
                           
                           Atakan Gesmeli - 05200000061
                           Mert Yusuf Yasar - 05210001035
                           
                           Lutfen asagidaki islemlerden birini secin:
                           
                           -----------------------------------------------------------------
                           1- Bir dosyadan ogrencileri ekleyin 
                           2- Ogrenciyi tum bilgilerini yazarak ekleyin
                           3- Ad-Soyad ile ogrenci bulun 
                           4- Ogrenci no girerek listeden ogrenci kaldirin 
                           5- Ogrenci no artacak sekilde ogrencileri sirali yazdirin 
                           6- Ogrenci no azalacak sekilde ogrencileri sirali yazdirin 
                           7- Programdan cikin 
                           -----------------------------------------------------------------""");
        
        while (true) {
            
            System.out.print("\nIslem seciniz (1-7): ");
            int islem = scannerIslem.nextInt(); // Kullanicidan islem bilgisi alinir 
            
            if (islem == 1) { // 1. islem secildiginde dosyadan ogrenciler okunur 
                
                Scanner dosya = null;  
                
                try {
                    dosya = new Scanner(new FileInputStream("ogrenciler.txt"));
                } 
                
                catch (FileNotFoundException e) {
                    System.out.println("Dosya bulunamadi veya okunamadi! ");
                    System.out.println("Programdan cikiliyor... ");
                    System.exit(0);
                }
                
                while (dosya.hasNext()) { // Dosyada line oldugunda
      
                    scannerStr1 = new Scanner(dosya.nextLine());
                    scannerStr1.useDelimiter(", "); // Line'da veriler arasinda virgulle ayrildigindan useDelimiter metodu kullanilir 
                    String ogrNo = scannerStr1.next(); // Ogrenci no bilgisi string olarak alinir          
                    String ogrenciAdSoyad = scannerStr1.next(); // Ogrenci Ad-Soyad bilgisi alinir
                    int ogrenciNo = Integer.parseInt(ogrNo); // Ogrenci no string olarak alindigindan integer'a cevrilir
                    Student student1 = new Student(ogrenciNo, ogrenciAdSoyad); // Ogrenci nesnesi olusturulur
                    
                    while (scannerStr1.hasNext()) {
                        student1.telNoEkle(scannerStr1.next()); // Telefon no'lar alinip eklenir
                    }
                    
                    ogrenciListesi.siraylaYerlestir(student1); // Ogrenciler listeye sirayla yerlestirilir
                
                }
                
                System.out.println("Dosya basariyla okundu! ");
                
            }
            
            else if (islem == 2) { // 2. islem secildiginde yeni ogrenci, kullanici girisiyle listeye eklenir
                
                Scanner scannerStr2 = new Scanner(System.in); // Gerekli scanner olusturuldu
                
                System.out.print("Eklemek istediginiz ogrencinin numarasini giriniz: ");
                int ogrenciNo = scannerInt.nextInt(); // Ogrenci no kullanicidan alinir
                
                System.out.print("Eklemek istediginiz ogrencinin Ad-Soyad giriniz: ");
                String ogrenciAdSoyad = scannerStr2.nextLine(); // Ogrenci Ad-Soyad bilgisi kullanicidan alinir
                
                Student ogrenci = new Student(ogrenciNo, ogrenciAdSoyad);
                
                System.out.println("Eklemek istediginiz ogrencinin telefon no giriniz (Birden fazla ise aralarina ',' koyunuz.): ");
                String ogrenciTelNo = scannerStr2.nextLine(); // Ogrenci telefon no kullanicidan alinir

                scannerStr2 = new Scanner(ogrenciTelNo);
                
                scannerStr2.useDelimiter(","); // Telefon numaralari bilgisi virgulle ayrilacak sekilde kullanicidan alinir
                
                while (scannerStr2.hasNext()) {
                    ogrenci.telNoEkle(scannerStr2.next()); // Telefon numaralari listeye eklenir
                }
                
                ogrenciListesi.siraylaYerlestir(ogrenci); // Eklenen ogrenci listeye siraya gore yerlestirilir
                
                System.out.println("Ogrenci listeye basariyla eklendi! ");
                
            }
            
            else if (islem == 3) { // 3. islem secildiginde bir ogrenci kullanicidan Ad-Soyad bilgisiyle listede aranir
                
                Scanner scannerStr3 = new Scanner(System.in);
                
                System.out.print("Bulunacak ogrencinin Ad-Soyad yaziniz: ");
                String ogrAdSoyad = scannerStr3.nextLine();
                
                ogrenciListesi.ogrenciBul(ogrAdSoyad);
                
            }
            
            else if (islem == 4) { // 4. islem secildiginde bir ogrenci kullanicidan ogrenci numarasi bilgisiyle listeden silinir
                
                Scanner scannerInt2 = new Scanner(System.in);
                
                System.out.print("Silinecek ogrencinin numarasini yaziniz: ");
                int ogrNo = scannerInt2.nextInt();
                
                ogrenciListesi.ogrenciSil(ogrNo);
                
            }
            
            else if (islem == 5) { // 5. islem secildiginde ogrenciler, ogrenci no kucukten buyuge sirayla ekrana yazdirilir
                
                System.out.println("Ogrenciler numara sirasi artacak sekilde yazdiriliyor... \n");
                ogrenciListesi.KucuktenBuyugeSirala(ogrenciListesi);
                
            }
            
            else if (islem == 6) { // 6. islem secildiginde ogrenciler, ogrenci no buyukten kucuge sekilde sirayla ekrana yazdirilir
                
                System.out.println("Ogrenciler numara sirasi azalacak sekilde yazdiriliyor... \n");
                ogrenciListesi.BuyuktenKucugeSirala(ogrenciListesi);
                
            }
            
            else if (islem == 7) { // 7. islem secildiginde programdan cikis yapilir
                
                System.out.println("\nProgrami kullandiginiz icin tesekkurler!");
                System.out.println("Programdan cikiliyor...");
                System.exit(0);
                
            }
            
            else { // Mevcut olmayan islem girildiginde hata bilgisi verilerek kullanicidan tekrar islem girilmesi istenir
                
                System.out.println("Gecersiz islem! ");
                
            }
            
        }
    
    }
    
}
