public class LinkedList {
    Node head;

    //insert Contact
    public void insert(Contact contact){
        Node newNode = new Node(contact);
        if(head == null){
            head = newNode;
        }else{
            Node loopNode = head;
            while(loopNode.next != null){
                loopNode = loopNode.next;
            }
            loopNode.next = newNode;
        }
    }

    public void updateNode(int index, Contact newContact){
        if(index==0){
            head.contact = newContact;
        }else{
            Node loopNode = head;
            for(int i = 0; i < index - 1; i++) {
                loopNode = loopNode.next;
            }
            loopNode.next.contact = newContact;
        }
    }

    public void deleteNode(int index){
        if(index==0){
            head = head.next;
        }else{
            Node loopNode = head;
            for(int i = 0; i < index - 1; i++) {
                loopNode = loopNode.next;
            }
            Node oldNode = loopNode.next;
            loopNode.next = oldNode.next;
        }
    }

    public int getIndexOf(Contact contact){
        Node loopNode = head;
        int i=0;
        while(loopNode.next != null){
            if(contact.getName().equals(loopNode.contact.getName()) && contact.getNumber().equals(loopNode.contact.getNumber())){
                return i;
            }
            loopNode = loopNode.next;
            i++;
        }
        return i;
    }

    public int getSize(){
        if(head == null){
            return 0;
        }else{
            Node loopNode = head;
            int i=0;
            while(loopNode.next != null){
                loopNode = loopNode.next;
                i++;
            }
            return i+1;
        }
    }


    public void showList(){
        if(head == null){
            System.out.println("You don't have any contacts yet.");
        }else {
            Node loopNode = head;
            int i = 1;
            while (loopNode.next != null) {
                System.out.println(i + ".) " + loopNode.contact.getName() + ": " + loopNode.contact.getNumber());
                loopNode = loopNode.next;
                i++;
            }
            System.out.println(i + ".) " + loopNode.contact.getName() + ": " + loopNode.contact.getNumber());
        }
    }
}