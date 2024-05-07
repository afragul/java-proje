import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        int customerID;
        int[][] puanMatrix= new int[20][20];

        //open file
        Scanner fileIn=null;
        try{
            fileIn = new Scanner (new FileInputStream("Firma.txt")); 
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
            System.exit(0);
        }

        System.out.println("------MENU-----");
        Scanner input= new Scanner(System.in);
        Scanner input2= new Scanner(System.in);

        System.out.print("enter the number what do you want: ");
        int userChoice=input.nextInt();
        System.out.println();
        
        String[] firstLine=fileIn.nextLine().split(","); //read first line
        int numOfProduct=Integer.parseInt(firstLine[0]); //number of products
        LinkedList linkedList=new LinkedList();
        int idQueue=0;
        List<CustomerData> customerList = new ArrayList<>(); 
        
        while(fileIn.hasNextLine()){

            if (fileIn.hasNextLine()){
                String[] customerDatas=fileIn.nextLine().split(","); 

                customerID=Integer.parseInt(customerDatas[0]); 
                puanMatrix[idQueue][0]=customerID;//customer id add to matrix

                CustomerData newCustomer=new CustomerData(customerDatas[1],customerDatas[2],customerDatas[3],customerDatas[4],customerDatas[5]);
                customerList.add(newCustomer);//add to list
                linkedList.insertSort(customerID, newCustomer); //linked liste ekleme yapildi AMA BIR TERSLIK VAR BAKMAN LAZIM!!!!
                linkedList.printList();
            
            }
            if (fileIn.hasNextLine()){
                String[] productDatas=fileIn.nextLine().split(","); 

                for(int i=1;i<=numOfProduct;i++){
                    puanMatrix[idQueue][i]=Integer.parseInt(productDatas[i-1]); //puans add to matrix
                }
            }
            idQueue++;
        }
        
        while(userChoice!=9){
            if (userChoice==1){
                System.out.println("file already read");
            }else if (userChoice==2){
                System.out.print("enter user id: ");
                int keyboardID=input.nextInt();
                puanMatrix[idQueue][0]=keyboardID;
                System.out.print("enter user name: ");
                String keyboardName=input2.nextLine();
                System.out.print("enter user surname: ");
                String keyboardSurname=input2.nextLine();
                System.out.print("enter city : ");
                String keyboardCity=input2.nextLine();
                System.out.print("enter country : ");
                String keyboardCountry=input2.nextLine();
                System.out.print("enter occupation : ");
                String keyboardOccupation=input2.nextLine();
                System.out.println();
                CustomerData keyboardCustomer=new CustomerData(keyboardName,keyboardSurname,keyboardCountry,keyboardCity,keyboardOccupation);
                customerList.add(keyboardCustomer);
                //linkedList.insertSort(keyboardID, keyboardCustomer);//add to linked list

                //statistics:
                int[] results= new int[customerList.size()];
                int minValue=100;
                int totalminValue=0; // calculate the total score if there is more than one similar person
                for(int i=1;i<numOfProduct;i++){
                    System.out.print("enter " + i + ". product's point: ");
                    int productPoint=input.nextInt();
                    puanMatrix[idQueue][i]=productPoint;
                }

                for(int i=0;i<customerList.size()-1;i++){
                    int totalDifference=0;
                    for(int j=1;j<numOfProduct;j++){//points difference for each product
                        int fark=0;
                        fark=puanMatrix[i][j]-puanMatrix[idQueue][j];
                        if(fark<0){
                            fark=fark*(-1);
                        }
                        totalDifference=totalDifference+fark;

                    }
                    results[i]=totalDifference; 
                }

                for(int i=0;i<results.length-1;i++){
                    if(minValue>results[i]){
                        minValue=results[i];
                        totalminValue=minValue;
                    }else if(minValue==results[i]){
                        totalminValue=(minValue+results[i])/2;
                    }
                }
                puanMatrix[idQueue][numOfProduct]=totalminValue;
                System.out.println("your point for last product probably will be: "+totalminValue);
                idQueue++;

            }else if (userChoice==3){
                for(int i=1;i<numOfProduct+1;i++){ 
                    int puanOfProduct=0; //total puan for every product
                    for(int j=0;j<customerList.size();j++){
                        puanOfProduct=puanOfProduct+puanMatrix[j][i];
                    }
                    System.out.println("total score of the "+(i+1)+". product: "+ puanOfProduct);
                }
            }else if(userChoice==4){
                //Her bir ürün için sadece ülkesi "Turkey" olan müşterileri dikkate alarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==5){
                //Her bir ürün için ülkesi "Turkey" dışındaki değerler olan müşterileri dikkate alarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==6){
                //Her bir ürün için sadece mesleği "Doctor" olan müşteriler dikkate alınarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırma.
            }else if(userChoice==7){
                //Müşteri bilgileri bağlı listesini baştan sonra ekrana yazdırma.
            }else if(userChoice==8){
                for (int row = 0; row < puanMatrix.length; row++) {
                    for (int column = 0; column < puanMatrix[row].length; column++) {
                        System.out.print(puanMatrix[row][column] + " "); 
                    }
                    System.out.println(); 
                }
            }else if(userChoice==9){
                System.out.println("system is exit");
                System.exit(0);
            }else{
                System.out.println("invalid data");
            }
            System.out.print("enter the number what do you want: ");
            userChoice=input.nextInt();
        }
    }
}
