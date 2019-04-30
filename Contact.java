import java.util.ArrayList;

/**
 * Sets up contacts that can be filled in. Not sure how it does that yet, honestly. 
 *
 * @wilson mayfield
 * @4-17-19 created
 * @4-22-19 created constructor 
 * @4-23-19 added toString() override
 * @4-30-19 added comments
 */
public class Contact
{
    public String firstName; //defining strings for the object
    public String lastName;
    public String occupation;
    public String address;
    public String email;
    public String phone;

    public Contact(String firstName, String lastName, String occupation, String address, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.address = address;
        this.email = email;
        this.phone = phone;
        //defines the Contact object for creating contacts & filling in their info
    }

    @Override //This is for printing the array.
    public String toString() { //Need to override .toString() in order to print everything in the Contact object.
        return //Prints out each piece of data on a new line, except for the first & last names.
        ("Name: "+this.getFirstName()+" "+this.getLastName()+
            "\nOccupation: "+this.getOccupation()+
            "\nAddress: "+this.getAddress()+
            "\nEmail: "+this.getEmail() +
            "\nPhone Number: " +this.getPhone()+
            "\n");
        }
        //Set & get individual pieces of information for each Contact object. Needed to build & print contacts.
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String f){
        firstName = f;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String l){
        lastName = l;
    }

    public String getOccupation(){
        return occupation;
    }

    public void setOccupation(String o){
        occupation = o;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String a){
        address = a;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String e){
        email = e;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String p){
        phone = p;
    }
}
