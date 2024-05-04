import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dosyaOkuma {
    public static void main(String[] args) {
        int customerID;
        int[][] puanMatrix= new int[20][20];

        Scanner fileIn=null;
        try{
            fileIn = new Scanner (new FileInputStream("Firma.txt")); 
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
            System.exit(0);
        }

        String first=fileIn.nextLine(); //read file 
        String[] firstLine=first.split(","); //ilk satiri bir diziye atadik ilk elemani ve kalanlari cekecegiz
        
        int numOfProduct=Integer.parseInt(firstLine[0]);
        // for(int i=1;i<numOfProduct;i++){//urunlerin ortalama degerini hesaplayabilmek icin her biri icin arraylist 
        //     //puanMatrix[0][i]=firstLine[i];
        // }

        List<String[]> customerDatas = new ArrayList<>();
        List<String[]> productDatas = new ArrayList<>();
        LinkedList linkedList=new LinkedList();
        int productQueue=1;
        int idQueue=0;
        List<CustomerData> customerList = new ArrayList<>(); //customerlari bir listede topladik
        while(fileIn.hasNextLine()){

            if (fileIn.hasNextLine()){
                String secondLine=fileIn.nextLine();
                String[] datas=secondLine.split(","); 
                customerDatas.add(datas);//customer datalari bu diziye atandi burdan cekilip islem yapilacak

                customerID=Integer.parseInt(customerDatas.get(0)[0]); //kullanici id alindi
                puanMatrix[idQueue][0]=customerID;//matrixe id eklendi

                //burda hata var onlara bak
                CustomerData newCustomer=new CustomerData(customerDatas.get(1)[1],customerDatas.get(2)[2],customerDatas.get(3)[3],customerDatas.get(4)[4],customerDatas.get(5)[5]);
                //customerList.add(newCustomer);//listeye ekledi
                linkedList.insertSort(customerID, newCustomer);
                newCustomer.toString();




                for (String[] words : customerDatas) {
                    for (String word : words) {
                        System.out.print(word + " ");
                    }
                    System.out.println();
                }
             
                customerDatas.clear();//verileri her seferinde siler
            
            }
            if (fileIn.hasNextLine()){
                String thirdLine=fileIn.nextLine();
                String[] productData=thirdLine.split(","); 
                productDatas.add(productData); //product datalar burada toplandi ikide yaptiklarini yap

                // for(int i=1;i<numOfProduct+1;i++){
                //     puanMatrix[idQueue][productQueue]=Integer.parseInt(productDatas.get(i)[i]); //puanlar matrixe yazildi
                // }



                productDatas.clear();//verileri her seferinde siler

            }

            idQueue++;
            productQueue++;
        }

        for (int row = 0; row < puanMatrix.length; row++) {
            for (int column = 0; column < puanMatrix[row].length; column++) {
                System.out.print(puanMatrix[row][column] + " "); 
            }
            System.out.println(); 
        }

    }
}
