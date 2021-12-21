import java.util.Scanner;

class Orangtua 
{
    int noKK;
    Orangtua NextOrtu;
    Anak NextAnak;
}

class Anak 
{
    int NIK;
    String nama;
    int umur;
    String tglLahir;
    String tmptLahir;
    String pekerjaan;
    Anak Next;
}

public class Main { 
    static Orangtua Kepala;
    
    public void init() 
    {
        Kepala = new Orangtua();
        Kepala.NextAnak = null;
        Kepala.NextOrtu = null;
    }
    
    public void addList(int noKK)  
    {
        Orangtua Baru, Ot;
        
        Baru = new Orangtua();
        Baru.noKK = noKK;
        Baru.NextAnak = null;
        
        if(Kepala.NextOrtu == null)
        {
            Kepala.NextOrtu = Baru;
            Baru.NextOrtu = null;
        } else {
            Ot = Kepala.NextOrtu;
            while(Ot.NextOrtu != null && Ot.NextOrtu.noKK < Baru.noKK)
            {
                Ot = Ot.NextOrtu;
            }
            if(Ot.noKK > Baru.noKK)
            {
                Baru.NextOrtu = Kepala.NextOrtu;
                Kepala.NextOrtu = Baru;
            } else {
                Baru.NextOrtu = Ot.NextOrtu;
                Ot.NextOrtu = Baru;
            }
        }
    }
    
    public void addSubList(int NIK, String nama, int umur, String tglLahir, String tmptLahir, String pekerjaan, Orangtua simpul) 
    { 
        Anak Baru, an;
        Orangtua Ot;
        
        Baru = new Anak();
        Ot = new Orangtua();
        
        Baru.NIK = NIK;
        Baru.nama = nama;
        Baru.umur = umur;
        Baru.tglLahir = tglLahir;
        Baru.tmptLahir = tmptLahir;
        Baru.pekerjaan = pekerjaan;
        Ot = simpul;
        
        if(Ot.NextAnak == null)
        {
            Ot.NextAnak = Baru;
            Baru.Next = null;
        } else {
            an = Ot.NextAnak;
            
            while(an.Next != null && an.Next.NIK < Baru.NIK)
            {
                an = an.Next;
            }
            if(an.NIK > Baru.NIK)
            {
                Baru.Next = Ot.NextAnak;
                Ot.NextAnak = Baru;
            } else {
                Baru.Next = an.Next;
                an.Next = Baru;
            }
        }
    }
    
    public void hapusList(int noKK) 
    {
        Orangtua ot, delete;
        
        ot = new Orangtua();
        delete = new Orangtua();
        
        if(Kepala.NextOrtu == null)
        {
            System.out.println("Kosong\n");
        } else {
            delete = Kepala.NextOrtu;
            
            while(delete != null && delete.noKK != noKK)
            {
                ot = delete;
                delete = delete.NextOrtu;
            }
            if(Kepala == null)
            {
                System.out.println("Tidak ada\n");
            } 
            else if(Kepala.NextOrtu == delete)
            {
                Kepala.NextOrtu = delete.NextOrtu;
            } else {
                ot.NextOrtu = delete.NextOrtu;
            } 
        }
    }
    
    public void hapusSubList(int NIK, Orangtua simpul) 
    {
        Orangtua ot;
        Anak an, delete;
        
        ot = new Orangtua();
        an = new Anak();
        delete = new Anak();
        
        ot = simpul;
        
        if(ot.NextAnak == null)
        {
            System.out.println("Sub simpul kosong\n");
        } else {
            delete = ot.NextAnak;
            
            while(delete != null && delete.NIK != NIK)
            {
                an = delete;
                delete = delete.Next;
            }
            
            if(ot == null)
            {
                System.out.println("Tidak Ditemukan 1\n");
            } 
            else if(ot.NextAnak == delete)
            {
                ot.NextAnak = delete.Next;
            } else {
                an.Next = delete.Next;
            }
        }
    }
    
    public void printList() 
    {
        Orangtua simpulOt;
        
        if(Kepala.NextOrtu == null)
        {
            System.out.println("Kosong\n");
        } else {
            simpulOt = Kepala.NextOrtu;
            
            System.out.println("==============================\n");
            System.out.println("= NO KK                      =\n");
            System.out.println("==============================\n");
            
            while(simpulOt != null)
            {
                System.out.println(simpulOt.noKK);
                simpulOt = simpulOt.NextOrtu;
            }
        }
        System.out.println();
    }
    
    public void printSubList() 
    {
        Orangtua simpulOt;
        Anak simpulAn;
        
        if(Kepala.NextOrtu == null)
        {
            System.out.println("Kosong\n");
        } else {
            simpulOt = Kepala.NextOrtu;
            
            System.out.println("==============================\n");
            System.out.println("= NO KK                      =\n");
            System.out.println("==============================\n");
            
            while(simpulOt != null)
            {
                System.out.println(simpulOt.noKK);
                simpulAn = simpulOt.NextAnak;
                
                while(simpulAn != null)
                {
                    System.out.print(" " + "NIK: " + " " + simpulAn.NIK); System.out.println("\t");
                    System.out.printf(" " + "NAMA: " + " %s\n", simpulAn.nama); 
                    System.out.print(" " + "UMUR: " + " " + simpulAn.umur); System.out.println("\t");
                    System.out.printf(" " + "TGL LAHIR: " + " %s\n", simpulAn.tglLahir);
                    System.out.printf(" " + "TMPT LAHIR: " + " %s\n", simpulAn.tmptLahir); 
                    System.out.printf(" " + "PEKERJAAN: " + " %s\n", simpulAn.pekerjaan); 
                    simpulAn = simpulAn.Next;
                }
                simpulOt = simpulOt.NextOrtu;
            }
        }
        System.out.println();
    }
    
    public static Orangtua Simpul(int NOKK) 
    {
        Orangtua ot;
        ot = Kepala.NextOrtu;
        
        while(ot != null && ot.noKK != NOKK)
        {
            ot = ot.NextOrtu;
        }
        if(ot == null)
        {
            return null;
        } else {
            return ot;
        }
    }
    
    public static void main(String[] args) { 
        int menu=0, NoKK, NiK, Umur;
        String Nama, TglLahir, TmptLahir, Pekerjaan;
        
        Main objek = new Main();
        
        objek.init();
        
        while(menu != 7)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("------------------------------------\n");
            System.out.println("- 1. Add Data pada List            -\n");
            System.out.println("- 2. Add Data pada SubList         -\n");
            System.out.println("- 3. Delete pada List              -\n");
            System.out.println("- 4. Delete pada SubList           -\n");
            System.out.println("- 5. Print List                    -\n");
            System.out.println("- 6. Print Semua List              -\n");
            System.out.println("- 7. Keluar                        -\n");
            System.out.println("Masukan menu: ");
            System.out.println("------------------------------------\n");
            menu = sc.nextInt();
            
            switch(menu) 
            {
                case 1:
                {
                    System.out.println("Masukan No KK: ");
                    NoKK = sc.nextInt();
                    objek.addList(NoKK);
                    break;
                }
                case 2:
                {
                    Orangtua ortu;
                    
                    System.out.println("Masukan No KK nya: ");
                    NoKK = sc.nextInt();
                    sc.nextLine();
                    ortu = Simpul(NoKK);
                    
                    if(ortu == null)
                    {
                        System.out.println("Tidak Ditemukan\n");
                    } else {
                        System.out.println("Masukan NIK: ");
                        NiK = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Masukan Nama:");
                        Nama = sc.nextLine();
                        System.out.println("Masukan Umur: ");
                        Umur = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Masukan Tanggal Lahir(ddmmyy): ");
                        TglLahir = sc.nextLine();
                        System.out.println("Masukan Tempat Lahir: ");
                        TmptLahir = sc.nextLine();
                        System.out.println("Masukan Pekerjaan: ");
                        Pekerjaan = sc.nextLine();
                        objek.addSubList(NiK, Nama, Umur, TglLahir, TmptLahir, Pekerjaan, ortu);
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Masukan No KK: ");
                    NoKK = sc.nextInt();
                    sc.nextLine();
                    objek.hapusList(NoKK);
                    break;
                }
                case 4:
                {
                    Orangtua ortu;
                    
                    System.out.println("Masukan No KK: ");
                    NoKK = sc.nextInt();
                    sc.nextLine();
                    
                    ortu = Simpul(NoKK);
                    if(ortu == null)
                    {
                        System.out.println("Tidak Ditemukan\n");
                    } else {
                        System.out.println("Masukan NIK: ");
                        NiK = sc.nextInt();
                        sc.nextLine();
                        objek.hapusSubList(NiK, ortu);
                    }
                    break;
                }
                case 5:
                {
                    objek.printList();
                    break;
                }
                case 6:
                {
                    objek.printSubList();
                    break;
                }
                case 7:
                {
                    System.out.println("Keluar...\n");
                    break;
                }
            }
        }
    }
}
