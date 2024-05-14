package pojoTestData.jsonData;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class JsonDataNopCommerce {

    public static JsonDataNopCommerce getJsonDataNopCommerce(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCES_PATH+filename), JsonDataNopCommerce.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("companyname")
    private String companyName;

    @JsonProperty("day")
    private String dayOfDOB;
    @JsonProperty("month")
    private String monthOfDOB;
    @JsonProperty("year")
    private String yearOfDOB;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;

    @JsonProperty("postalcode")
    private String postalcode;

    @JsonProperty("phonenumber")
    private String phonenumber;

    @JsonProperty("faxnumber")
    private String faxnumber;

    @JsonProperty("state")
    private String state;
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;

    }



    @JsonProperty("address")
    String address;

    public String getFirstName() {
        System.out.println(firstname);
        return firstname;
    }


    public String getLastName() {
        return lastname;
    }


    public String getPassword() {
        return  password;
    }


    public String getEmail() {
        return emailAddress;
    }



    public String getDob() {
        return dob;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDayOfDOB() {
        return dayOfDOB;
    }

    public String getMonthOfDOB() {
        return monthOfDOB;
    }

    public String getYearOfDOB() {
        return yearOfDOB;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getFaxnumber() {
        return faxnumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
