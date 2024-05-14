package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:environmentConfig/${serverName}_poperties"})
public interface EnvironmentConfig extends Config {

    @Key("App.Url")
    String appUrl();
    @Key("App.User")
    String appUser();
    @Key("App.Password")
    String appPassword();


}
