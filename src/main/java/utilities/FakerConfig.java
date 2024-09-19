package utilities;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class FakerConfig {
    Faker faker = new Faker(new Locale("en-US"));
    public static FakerConfig getFaker() {
        return new FakerConfig();
    }



    public String getFirstName(){
        return faker.address().firstName();

    }

    public String getLasttName(){
        return faker.address().lastName();

    }

    public String getCityName(){
        return faker.address().cityName();

    }


    public String getStreetName(){
        return faker.address().streetName();

    }
    public String getEmailAddress(){
        return faker.internet().emailAddress();
    }

    public String getUserName() {
        return faker.name().fullName();
    }

    public String getPassword(){
        return faker.internet().password();

    }

    public String getCompany(){
        return faker.company().name();
    }

    public String getStreetAddress(){
        return faker.address().fullAddress();
    }

    public String getSecondAddress(){
        return faker.address().secondaryAddress();
    }

    public String getZipcode(){
        return faker.address().zipCode();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }
    public String getFaxnumber(){
        return faker.number().digit();
    }

    public String getRandomText(){
        Instant time = Instant.now();
        String randomText;
        return randomText= faker.demographic().toString()+ time;
    }

    public String getDOB() {
      return String.valueOf(faker.date().birthday());

    }
}
