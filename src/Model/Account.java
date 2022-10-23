package Model;

public class Account {

    // User information
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Message information
    private String[] inbox = new String[10];
    private String[] outbox = new String[10];
    private boolean[] status = new boolean[10];
    private String[] subject = new String[10];
    private String[] sender = new  String[10];
    private String[] receiver = new  String[10];



    public Account(String firstName, String lastName, String email, String password, String[] inbox, String[] outbox, boolean[] status, String[] subject, String[] sender, String[] reciver) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.inbox = inbox;
        this.outbox = outbox;
        this.status = status;
        this.subject = subject;
        this.sender = sender;
        this.receiver = reciver;
    }

    public Account(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getInbox() {
        return inbox;
    }

    public void setInbox(String[] inbox) {
        this.inbox = inbox;
    }

    public String[] getOutbox() {
        return outbox;
    }

    public void setOutbox(String[] outbox) {
        this.outbox = outbox;
    }

    public boolean[] getStatus() {
        return status;
    }

    public void setStatus(boolean[] status) {
        this.status = status;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String[] getSender() {
        return sender;
    }

    public void setSender(String[] sender) {
        this.sender = sender;
    }

    public String[] getReceiver() {
        return receiver;
    }

    public void setReceiver(String[] receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
