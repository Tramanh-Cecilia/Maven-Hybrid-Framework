package pojoTestData.OrangeHRMdata;

public class AdminInfor {
    public String password;
    public String userName;
    public static AdminInfor getAdminInfor(){
        return new AdminInfor();
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }






}
