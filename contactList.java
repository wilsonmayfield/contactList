import java.util.*;
import java.io.*;

/**
 * Lists, creates, and deletes contacts. Or it'll do that sometime. Eventually. Maybe.
 *
 * @wilson
 * @4-17-19 created
 * @4-22-19 code now takes input & communicates with contact.java
 * @4-23-19 creates array, can view & create contacts
 * @4-29-19 added delete() method & contact numbers
 */
public class contactList
{
    public static String msg;
    public static ArrayList<Contact> Contacts = new ArrayList<Contact>();
    public static int num;
    public static void main(){
        Contacts.add(new Contact("Wilson", "Mayfield", "Programmer", "2164 Everett Road", "wilsonmayfield2003@gmail.com", "719-924-2778"));
        Contacts.add(new Contact("Charles", "Rothbaum", "Programmer", "5555 Charles Street", "charlesrothbaum@rothmail.com", "719-999-6666"));

        System.out.println("---CONTACT UTILITY---");
        Scanner in = new Scanner(System.in);
        System.out.println("Type 'help' for help.");
        String text = in.nextLine().toLowerCase();

        while(!text.equals("exit")){
            switch(text){
                case "help" :
                help();
                break;
                case "view contacts" :
                System.out.println("---CONTACTS---");
                viewContacts();
                break;
                case "delete contact" :
                System.out.println("---DELETE CONTACTS---");
                deleteContact();
                break;
                case "create contact" :
                System.out.println("---CONTACT CREATOR---");
                Contacts.add(createContact());
                break;
                case "search" :
                System.out.println("");
                msg = "";
                break;
                default : msg = "I can't figure out what you mean because I'm stupid.";
            }
            System.out.println(msg);
            System.out.println("Type 'help' for help.");
            text = in.nextLine();
        }
        System.out.println("Stopped.");
    }

    public static void help(){
        System.out.println("---HELP---");
        msg = "View Contacts: Lists all contacts & their information"+
        "\nCreate Contact: Creates a new contact"+
        "\nDelete Contact: Deletes a contact from your contacts list"+
        "\nHelp: Shows this list"+
        "\nExit: Closes program";
    }

    public static void viewContacts(){
        num = 1;
        sortContacts();
        for(Contact contact: Contacts) {
            System.out.println("Contact "+num+++":");
            System.out.println(contact);
        }
        if(Contacts.size() == 0){
            msg = "You have no contacts.";
        }
        else if(Contacts.size() == 1){
            msg = "You have "+Contacts.size()+" contact.";
        }
        else{
            msg = "You have "+Contacts.size()+" contacts.";
        }
    }

    public static void deleteContact(){
        num = 1;
        sortContacts();;
        for(Contact contact: Contacts) {
            System.out.println("Contact "+num+++":");
            System.out.println(contact);
        }
        System.out.println("Enter the number of the contact you want to delete.");
        Scanner in = new Scanner(System.in);
        int del = in.nextInt() - 1;
        String fName = Contacts.get(del).firstName;
        String lName = Contacts.get(del).lastName;
        msg = fName+" "+lName+" has been removed from your contacts.";
        Contacts.remove(del);
    }

    public static Contact createContact(){
        String firstName = "";
        String lastName = "";
        String occupation = "";
        String address = "";
        String email = "";
        String phone = "";

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the contact's first name.");
        firstName = in.nextLine();
        System.out.println("Please enter the contact's last name.");
        lastName = in.nextLine();
        System.out.println("Please enter the contact's occupation.");
        occupation = in.nextLine();
        System.out.println("Please enter the contact's address.");
        address = in.nextLine();
        System.out.println("Please enter the contact's email.");
        email = in.nextLine();
        System.out.println("Please enter the contact's phone number.");
        phone = in.nextLine();

        Contact e = new Contact(firstName, lastName, occupation, address, email, phone);
        msg = firstName+" "+lastName+" has been added to your contacts.";
        return e;
    }

    public static String search(){
        return "";
    }

    public static void sortContacts(){
        Collections.sort(Contacts, Comparator.comparing(Contact::getFirstName));
    }
}
