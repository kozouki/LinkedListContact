import java.util.Scanner;

public class Oppo implements Phone{
    LinkedList contactList = new LinkedList();

    public static void main(String[] args) {
        Oppo phone = new Oppo();
        Scanner scanner = new Scanner(System.in);
        phone.createNewContact("Matts","1234");

        //intro
        phone.intro();
        phone.showPhoneModel();
        phone.iosOrAndroid();

        int action=0;
        while (action != 5){
            showActionList();
            System.out.print("Enter your number of action: ");
            action = scanner.nextInt();
            if(action<=0 || action>5){
                System.out.println("Error! Please enter 1-5 only");
            }else{
                performAction(action, phone);
            }
        }
        System.out.println("Goodbye! I hope to see you again :)");
    }

    public void createNewContact(String name, String number){
        Contact c = new Contact(name, number);
        contactList.insert(c);
    }

    public void deleteContact(int index){
        contactList.deleteNode(index - 1);
    }

    public void updateContact(int index, String newName, String newNumber){
        Contact newContact = new Contact(newName, newNumber);
        contactList.updateNode(index-1, newContact);
    }

    public void showAllContacts(){
        contactList.showList();
    }

    public int getContactSize(){
        return contactList.getSize();
    }

    public static void showActionList(){
        System.out.println("\n---Enter number of action---");
        System.out.println("1. Show all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Exit phone");
        System.out.println();
    }

    public static void performAction(int action, Oppo phone){
        Scanner scanner = new Scanner(System.in);
        String name;
        String number;
        int index;
        switch (action) {
            case 1 -> phone.showAllContacts();
            case 2 -> {
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                System.out.print("Enter number: ");
                number = scanner.nextLine();
                phone.createNewContact(name, number);
                System.out.println("Successfully added!");
            }
            case 3 -> {
                phone.showAllContacts();
                if(phone.getContactSize() != 0){
                    System.out.print("Enter the corresponding number of the person that you want to update: ");
                    index = scanner.nextInt();
                    if(index < phone.getContactSize() || index > phone.getContactSize()){
                        System.out.println("Invalid choice, try again!");
                    }else {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print("Enter new name: ");
                        name = scanner2.nextLine();
                        System.out.print("Enter new number: ");
                        number = scanner2.nextLine();
                        phone.updateContact(index, name, number);
                        System.out.println("Successfully updated!");
                    }
                }
            }
            case 4 -> {
                phone.showAllContacts();
                if(phone.getContactSize() != 0) {
                    System.out.print("Enter the corresponding number of the person that you want to delete: ");
                    index = scanner.nextInt();
                    if(index < phone.getContactSize() || index > phone.getContactSize()){
                        System.out.println("Invalid choice, try again!");
                    }else {
                        phone.deleteContact(index);
                        System.out.println("Successfully deleted!");
                    }
                }
            }
        }
    }

    @Override
    public void intro() {
        System.out.println("Hello user!");
    }

    @Override
    public void showPhoneModel() {
        System.out.println("Your phone model is: "+"Oppo");
    }

    @Override
    public void iosOrAndroid() {
        System.out.println("Your phone OS is: "+"Android");
    }
}
