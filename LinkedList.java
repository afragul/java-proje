import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node1 head;

    public LinkedList(){
        head=null;
    }
    public void insertSort(int customerNo, CustomerData customerData ){ //add to customers by id order
        Node1 newNode=new Node1(customerNo,customerData,head);
        if(head==null || head.customerNo>=customerNo){
            newNode.link=head;
            head=newNode;
        }else{

            Node1 current=head;
            while(current.link!=null && current.link.customerNo<customerNo){
                current=current.link;
            }
            newNode.link=current.link;
            current.link=newNode;
        }
    }
    
    //find customers from turkey 
    public List<Integer> findTurkey(String item){
        List<Integer> turkishCustomer= new ArrayList<>();
        Node1 position= head;
        while(position!=null){
            if(position.customerInfo.getCountry().equals(item)){
                turkishCustomer.add(position.customerNo);
            }
            position=position.link;
        }
        return turkishCustomer;
    }

    //find non turkish custumers
    public List<Integer> findOtherNations(){
        List<Integer> nonTurkishCustomer= new ArrayList<>();
        Node1 position= head;
        while(position!=null){
            if(!position.customerInfo.getCountry().equals("Turkey")){
                nonTurkishCustomer.add(position.customerNo);
            }
            position=position.link;
        }
        return nonTurkishCustomer;
    }

    //find doctor customer
    public List<Integer> findDoctor(String item){
        List<Integer> doctorCustomer= new ArrayList<>();
        Node1 position= head;
        while(position!=null){
            if(position.customerInfo.getOccupation().equals(item)){
                doctorCustomer.add(position.customerNo);
            }
            position=position.link;
        }
        return doctorCustomer;
    }

    public void printList(){
        Node1 position=head;
        while(position!=null){
            System.out.println("customer no: "+position.customerNo +" "+position.customerInfo);
            position=position.link;
        }
    }
}
