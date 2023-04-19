
public class DoublyLinkedList {
    
    class Node { // Node sinifi inner class seklinde yazildi  
        
        private Student studentData; // Ogrenci bilgisi tutan degisken
        private Node prev;  // Onceki node'u tutan node
        private Node next; // Sonraki node'u tutan node
        
        public Node(Student studentData) { // Sadece ogrenci bilgisi parametre alan Constructor
            
            this.studentData = studentData;
            this.next = null;
            this.prev = null;
        
        }
   
        public Node(Student studentData, Node next, Node prev) { // Parametreli Constructor 
            
            this.studentData = studentData;
            this.next = next;
            this.prev = prev;
            
        }

        // Getter ve Setter metodlar
        public void setStudentData(Student studentData) {
            this.studentData = studentData;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Student getStudentData() {
            return studentData;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }
        
    }
    
    private Node head = null; // Listenin head tutan degisken
    private Node tail = null; // Listenin tail tutan degisken
    
    public boolean isEmpty() { // Liste bossa head degerini null yapan metod 
      return head == null; 
    }
    
    public void siraylaYerlestir(Student student1) { // Ogrenci no sirasina gore listeye ogrenci ekleyen metod
        
        Node current1 = new Node(student1); // Sartlarin saglanmasi icin gerekli Node'lar 
        Node current2 = new Node(student1, head, null);
        Node current3 = new Node(student1, null, tail);
        
        if (isEmpty() != false) { // Liste bos oldugunda ilk eleman hem head hem de tail olur 
            head = current1;
            tail = current1;
            return;
        }
        
        Node current4 = head; // Ogrenci bastan baslanarak(head) yerlestirilecek
        Node current5 = null; // Diger sartlar icin gerekli ve yeni node'lar
        
        while (current4 != null) {
            
            if (student1.compareTo(current4.getStudentData()) == 1) { // Eklenen ogrencinin no sirasi sonra geliyorsa 1 ilerler  
                
                current4 = current4.getNext();
            
            }
        
            else { // Eklenen ogrencinin no sirasi geldiyse gerekli sartlara gore ekleme yapilir 
                
                if (current4 == head) { // Eger ogrenci no sirasi bastaysa head e eklenir 
                    
                    head.setPrev(current2);
                    head = current2;
                    
                }
                
                else { // Eger ogrenci no sirasi ortadaysa gerekli islemler yapilir 
                    
                    current5 = new Node(student1, current4, current4.getPrev());
                    current4.getPrev().setNext(current5);
                    current4.setPrev(current5);
                    
                }
                
                return;
                
            }
        
        }
        
        // Eger yukaridaki sartlarin hicbiri olmadiysa ogrenci no sirasi sondadir demektir ve ona gore islemler yapilir 
        tail.setNext(current3);
        tail = current3;
        
    }  
    
    public void ogrenciBul(String adSoyad) { // Ad-Soyad parametresiyle ogrenci aramayi saglayan metod 
            
        if (isEmpty() != false) { // Liste bossa
            
            System.out.println("Ogrenci listesi bos! ");
            return;
            
        }
        
        Node current = head; // current bastan(head) baslar
        int count = 0; // Bulunan ogrenci sayisi degiskeni
        
        while(true) {
                
            if (current.getStudentData().getOgrenciAdSoyad().equals(adSoyad)) { // Ogrenci Ad-Soyad eslesirse ekrana yazdirilir
                    
                System.out.println("\nBulunan ogrenci: ");
                System.out.println(current.getStudentData());
                count++;
                
            }
            
            current = current.getNext();
                
            if (current == null) {  // Arama tamamlandiginda:
                
                if (count == 0) { // ogrenci bulunamadiysa ekrana bilgisi yazdirilir
                    
                    System.out.println("\nOgrenci bulunamadi! ");
                    
                }
                
                else { // ogrenci bulunduysa ekrana yazdirilir ve sayisi verilir 
                    
                    System.out.println("Bulunan ogrenci sayisi: " + count);
                    
                }
                
                return;
                
            }
        
        }
        
    }

    public void KucuktenBuyugeSirala(DoublyLinkedList list1) { // Ogrenci no kucukten buyuge ogrencileri yazdiran metod
        
        if (isEmpty() != false) { // Liste bossa
            
            System.out.println("Ogrenci listesi bos! ");
            return;
            
        }
        
        System.out.println("Ogrenciler (Kucukten buyuge): \n");
        
        // Ogrenciler bastan baslanarak(head) siralanacak ve ekrana yazdirilacak (liste bos degilse)
        Node current = head; 
        int count = 0;
            
        while (current != null) {
                
            count++;
            System.out.println("Ogrenci " + count + ":\n");
            System.out.println(current.getStudentData());
            current = current.getNext();
                
        }
            
    }

    public void BuyuktenKucugeSirala(DoublyLinkedList list1) { // Ogrenci no buyukten kucuge ogrencileri yazdiran metod
        
        if (isEmpty() != false) { // Liste bossa
            
            System.out.println("Ogrenci listesi bos! ");
            return;
            
        }
        
        System.out.println("Ogrenciler (Buyukten kucuge): \n");
        
        // Ogrenciler sondan baslanarak(tail) siralanacak ve ekrana yazdirilacak (liste bos degilse)
        Node current = tail;
        int count = 0;
        
        while (current != null) {
            
            count++;
            System.out.println("Ogrenci " + count + ":\n");
            System.out.println(current.getStudentData());
            current = current.getPrev();
            
        }
            
    }
    
    public void kaldir(Node current) { // Ogrenci silme islemini birinci silme metodundaki sartlara gore uygulayan ikinci silme metodu
        
        if (current == head && current == tail) { // Listede tek bir ogrenci kaldiysa bu sart gerceklesip ogrenci silinir
            
            head = null;
            tail = null;

            return;
            
        }
        
        else if (current == head) { // Ogrenci listenin basindaysa head islemlerine gore ogrenci silinir
            
            head = current.next;
            head.setPrev(null);
            
        }
        
        else if (current == tail) { // Ogrenci listenin sonundaysa tail islemlerine gore ogrenci silinir
            
            tail = current.prev;
            tail.setNext(null);
            
        }
        
        else { // Ogrenci listenin aralarindaysa buna gore islemler yapilip ogrenci silinir 
            
            current.prev.next = current.next;
            current.next.prev = current.prev;
            
        }
        
        // Son silme islemleri yapilir 
        current.prev = null;
        current.next = null;
        current = null;
        
    }
    
    public boolean ogrenciSil(int ogrNo) { // Ogrenci no girilerek ogrenci silmeye yarayan birinci silme metodu
        
        if (isEmpty() != false) { // Liste bossa
            
            System.out.println("Ogrenci listesi bos! ");
            return false;
            
        }
        
        // Ogrenci no ya gore arama bastan baslanip(head) dongude ogrenci bulunup bulunmadigina bakilip ikinci silme metoduna buna gore islemler yapilir
        Node current = head;
        
        while (current != null) {
            
            if (current.studentData.getOgrenciNo() == ogrNo) {
                
                kaldir(current);
                System.out.println("Ogrenci basariyla kaldirildi! ");
                return true;
                
            }
            
            current = current.next;
            
        }
        
        // Ogrenci bulunamazsa 
        System.out.println("Ogrenci bulunamadi! ");
        return false;
        
    }
    
}
