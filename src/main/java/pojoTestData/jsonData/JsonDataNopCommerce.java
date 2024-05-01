package pojoTestData.jsonData;

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

    @JsonProperty("address")
    String address;

    public String getFirstName() {
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


    public String getAddress() {
        return address;
    }


}
