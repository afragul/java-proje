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
}
