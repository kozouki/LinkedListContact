public class Node {
    Contact contact;
    Node next;
    Node(Contact contact){
        this.contact = contact;
    }

    public Node checkNext(){
        return next;
    }
}
