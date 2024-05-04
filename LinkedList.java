public class LinkedList {
    private Node1 head;

    public LinkedList(){
        head=null;
    }
    public void insertSort(int customerNo, CustomerData customerData ){
        Node1 newNode=new Node1(customerNo,customerData,head);
        if(head==null || head.customerNo>=customerNo){
            newNode.link=head;
            head=newNode;
        }
        Node1 current=head;
        while(current.link!=null && current.link.customerNo<customerNo){
            current=current.link;
        }
        newNode.link=current.link;
        current.link=newNode;
    }
    //find customer from turkey 
    public int findTurkey(String item){
        Node1 position= head;
        while(position!=null){
            if(position.customerInfo.getName().equals(item)){
                return position.customerNo;
            }
            position=position.link;
        }
        return -1;
    }
    //find doctor customer
    public int findDoctor(String item){
        Node1 position= head;
        while(position!=null){
            if(position.customerInfo.getOccupation().equals(item)){
                return position.customerNo;
            }
            position=position.link;
        }
        return -1;
    }

    public int size(){ // number of customers
        int count=0;
        Node1 position=head;
        while(position!=null){
            count ++;
            position=position.link;

        }
        return count;
    }
    public void printList(){
        Node1 position=head;
        while(position!=null){
            System.out.println(position.customerNo +" "+position.customerInfo);
            position=position.link;
        }
    }
}
