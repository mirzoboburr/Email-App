package EmailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateMail;
    private int defaultPasswordLength = 10;
    private String email;
    private String companySuffix = "boburcompany.com";


    //receive to the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + " " + this.lastName);


    //call a method asking for the dep - return the department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //  System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.println("New worker: " + firstName + ". Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoise = in.nextInt();
        if (depChoise == 1) {
            return "sales";
        } else if (depChoise == 2) {
            return "development";
        } else if (depChoise == 3) {
            return "accounting";
        } else {
            return "";
        }
    }
    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
//            System.out.println(rand);
//            System.out.println(passwordSet.charAt(rand));
        }
        return new String(password);
    }
    //using encapsulation
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }


    public void setAlternateEmail(String altEmail) {
        this.alternateMail = altEmail;
    }
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {  return mailboxCapacity; }

    public String getAlternateEmail() { return alternateMail;}

    public String getPassword() { return  password;}


    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}
