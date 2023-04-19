
import java.util.ArrayList;

public class Student {
    
    private int ogrenciNo; // Ogrenci numaralarini tutan integer degiskeni
    private String ogrenciAdSoyad; // Ogrenci Ad-Soyad tutan string degiskeni
    private ArrayList<String> ogrenciTelNo; // Ogrenci telefon numalarini tutan ArrayList

    public Student() { // Parametresiz Constructor
        
        this.ogrenciAdSoyad = null;
        this.ogrenciTelNo = null;
        
    }
    
    public Student(int ogrenciNo, String ogrenciAdSoyad) { // Parametreli Constructor
        
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAdSoyad = ogrenciAdSoyad;
        this.ogrenciTelNo = new ArrayList<>();
        
    }
    
    public Student(Student copyStudent) { // Copy Constructor
        
        ArrayList <String> ogrenciTelNo = new ArrayList<>();
        
        for(String s:copyStudent.ogrenciTelNo) { // Telefon numaralarini ekleyen dongu
            ogrenciTelNo.add(s);
        }
        
        this.ogrenciNo = copyStudent.ogrenciNo;
        this.ogrenciAdSoyad = copyStudent.ogrenciAdSoyad;
        this.ogrenciTelNo = copyStudent.ogrenciTelNo;
        
    }
    
    public void telNoEkle(String telNo) { // Ogrenci telefon numaralarini ekleyen metod
        
        ogrenciTelNo.add(telNo);
    
    }
    
    @Override
    public String toString() { // Bilgilerin dogru sekilde ekrana yazdirilmasini saglayan toString metodu
        return "Ogrenci No: " + getOgrenciNo() + "\nOgrenci Ad Soyad: " + getOgrenciAdSoyad() + "\nOgrenci Telefon No(lar): \n" + getOgrenciTelNo();
    }

    // Getter ve Setter metodlar
    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAdSoyad() {
        return ogrenciAdSoyad;
    }

    public void setOgrenciAdSoyad(String ogrenciAdSoyad) {
        this.ogrenciAdSoyad = ogrenciAdSoyad;
    }

    public String getOgrenciTelNo() {
        
        String telNo = "";
        
        for (String str: ogrenciTelNo) { // Telefon numaralarinin alt alta yazilmasini saglayan dongu
            telNo += str + "\n";
        }
        
        return telNo;
        
    }

    public void setOgrenciTelNo(ArrayList<String> ogrenciTelNo) {
        this.ogrenciTelNo = ogrenciTelNo;
    }
    
    public int compareTo(Student s) { // Ogrenci numaralarinin birbiriyle karsilastirilmasini saglayan metod
        
        int compareOgrNo = s.ogrenciNo;
        
        if(this.ogrenciNo < compareOgrNo) {
            return -1;
        }
        
        else if(this.ogrenciNo > compareOgrNo) {
            return 1;
        }

        else {
            return 0;

        }
    
    }
    
}

