/**
 * Node1
 */
public class Node1 {       
    int customerNo;
    CustomerData customerInfo;
    Node1 link;

    public Node1() {}
    public Node1(int customerNo, CustomerData customerInfo, Node1 link) {
        this.customerNo = customerNo;
        this.customerInfo = customerInfo;
        this.link = link;
    }
}