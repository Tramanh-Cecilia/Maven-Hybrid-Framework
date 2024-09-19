package pojoTestData;

public class UserInfo {

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    private String DOB;

    public String getCompanyName() {
        return company;
    }

    private String company;

    public static UserInfo getUser(){
        return new UserInfo();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompanyName(String company) {
        this.company = company;
    }
}
