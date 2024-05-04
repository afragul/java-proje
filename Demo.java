import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    
    public void readFile(){
        Scanner file= null;
        try{
            file = new Scanner (new FileInputStream("Firma.txt")); 
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
            System.exit(0);
        }

    }





    public static void main(String[] args) {

        System.out.println("------MENU-----");
        Scanner input= new Scanner(System.in);
        System.out.print("enter the number what do you want ");
        int userChoice=input.nextInt();
        System.out.println();

        do{
            //dosya verileri okunacak
        }while(userChoice!=9){
            if (userChoice==1){
                //dosya okunacak
            }else if (userChoice==2){
                //Klavyeden yeni bir müşteri girişi sağlanması 
            }else if (userChoice==3){
                // Her bir ürün için o ürüne ait ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==4){
                //Her bir ürün için sadece ülkesi "Turkey" olan müşterileri dikkate alarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==5){
                //Her bir ürün için ülkesi "Turkey" dışındaki değerler olan müşterileri dikkate alarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==6){
                //Her bir ürün için sadece mesleği "Doctor" olan müşteriler dikkate alınarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==7){
                //Müşteri bilgileri bağlı listesini baştan sonra ekrana yazdırma.
            }else if(userChoice==8){
                //İki boyutlu diziyi ekrana yazdırma.
            }else if(userChoice==9){
                System.out.println("system is exit");
                System.exit(0);
            }else{
                System.out.println("invalid data");
            }
        }

    }
}
