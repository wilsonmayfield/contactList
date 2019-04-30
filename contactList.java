import java.util.*;

/**
 * Lists, creates, and deletes contacts. Or it'll do that sometime. Eventually. Maybe.
 *
 * @wilson mayfield
 * @4-17-19 created
 * @4-22-19 code now takes input & communicates with contact.java
 * @4-23-19 creates array, can view & create contacts
 * @4-29-19 added delete() method & contact numbers
 * @4-30-19 added comments & cleaned code up, unimported java.io.*
 */
public class contactList
{
    public static String msg; //msg defined up here so it can be used in multiple methods
    public static ArrayList<Contact> Contacts = new ArrayList<Contact>(); //arraylist of contacts
    public static int num; // counter for number of contacts
    public static void main(){//basically populates the array & lets the user interact with the program
        //two test contacts
        Contacts.add(new Contact("Wilson", "Mayfield", "Programmer", "2164 Everett Road", "wilsonmayfield2003@gmail.com", "719-924-2778"));
        Contacts.add(new Contact("Charles", "Rothbaum", "Programmer", "5555 Charles Street", "charlesrothbaum@rothmail.com", "719-999-6666"));
        System.out.println("---CONTACT UTILITY---");
        Scanner in = new Scanner(System.in);//initializes scanner
        System.out.println("Type 'help' for help.");
        String text = in.nextLine().toLowerCase();//stores input and makes it lower-case to avoid capitalization problems

        while(!text.equals("exit")){//checks if the user entered "exit"
            switch(text){
                case "help" : //displays help
                help();
                break;
                case "view contacts" : //views contacts
                System.out.println("---CONTACTS---");
                viewContacts();
                break;
                case "delete contact" : //deletes contacts
                System.out.println("---DELETE CONTACTS---");
                deleteContact();
                break;
                case "create contact" : //creates contacts
                System.out.println("---CONTACT CREATOR---");
                Contacts.add(createContact());
                break;
                case "search" : //placeholder for search utility
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

    public static void help(){//displays all usable commands
        System.out.println("---HELP---");
        msg = "View Contacts: Lists all contacts & their information"+
        "\nCreate Contact: Creates a new contact"+
        "\nDelete Contact: Deletes a contact from your contacts list"+
        "\nHelp: Shows this list"+
        "\nExit: Closes program";
        //search not included yet since it doesn't exist
    }

    public static void viewContacts(){//lists all contacts
        num = 1;//counter for contacts, has to start at 1 so there is no contact 0
        sortContacts();//sorts contacts alphabetically
        for(Contact contact: Contacts) {//for loop that goes through every contact
            System.out.println("Contact "+num+++":");//prints out contact number & increments by 1
            System.out.println(contact);//prints out the contact object
        }
        if(Contacts.size() == 0){//if there's no contacts, it prints this
            msg = "You have no contacts.";
        }
        else if(Contacts.size() == 1){//if there's only one contact, it prints this to avoid a grammar problem
            msg = "You have one contact.";
        }
        else{//prints number of contacts
            msg = "You have "+Contacts.size()+" contacts.";
        }
    }

    public static void deleteContact(){//deletes contacts
        num = 1;//counter for number of contacts
        sortContacts();//sorts contacts alphabetically
        for(Contact contact: Contacts) {//prints contacts
            System.out.println("Contact "+num+++":");
            System.out.println(contact);
        }
        System.out.println("Enter the number of the contact you want to delete.");
        Scanner in = new Scanner(System.in);//starts new scanner for finding which contact to delete
        int del = in.nextInt() - 1;//only takes the contact number
        String fName = Contacts.get(del).firstName;//stores first name of the contact that will be deleted
        String lName = Contacts.get(del).lastName;//stores last name
        msg = fName+" "+lName+" has been removed from your contacts.";//prints deleted contact's name
        Contacts.remove(del);//removes contact from arraylist
    }

    public static Contact createContact(){//creates contacts
        Scanner in = new Scanner(System.in);//takes user input
        
        //the user inputs each respective piece of information and it stores it
        //the user can input nothing and it will store it as empty
        System.out.println("Please enter the contact's first name.");
        String firstName = in.nextLine();
        System.out.println("Please enter the contact's last name.");
        String lastName = in.nextLine();
        System.out.println("Please enter the contact's occupation.");
        String occupation = in.nextLine();
        System.out.println("Please enter the contact's address.");
        String address = in.nextLine();
        System.out.println("Please enter the contact's email.");
        String email = in.nextLine();
        System.out.println("Please enter the contact's phone number.");
        String phone = in.nextLine();

        Contact e = new Contact(firstName, lastName, occupation, address, email, phone);//creates contact with the new information
        msg = firstName+" "+lastName+" has been added to your contacts.";//prints out contact's name
        return e;//returns the new contact, e, 
    }

    public static String search(){//placeholder method for search, doesn't work yet
        return "";
    }

    public static void sortContacts(){//sorts contacts by first name
        Collections.sort(Contacts, Comparator.comparing(Contact::getFirstName));//java 8 object comparator, sorts by first name
    }
}
