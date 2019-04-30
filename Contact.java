import java.util.ArrayList;

/**
 * Sets up contacts that can be filled in. Not sure how it does that yet, honestly. 
 *
 * @wilson
 * @4-17-19 created
 * @4-22-19 created constructor 
 * @4-23-19 added toString() override
 */
public class Contact
{
    public String firstName;
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
    }

    @Override
    public String toString() {
        return
        ("Name: "+this.getFirstName()+" "+this.getLastName()+
            "\nOccupation: "+this.getOccupation()+
            "\nAddress: "+this.getAddress()+
            "\nEmail: "+this.getEmail() +
            "\nPhone Number: " +this.getPhone()+
            "\n");
        }

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
