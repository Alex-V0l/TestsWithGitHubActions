package TestPropertiesConfig;

import org.aeonbits.owner.Config;

import static Pages.BasePage.BASE_URL;
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface TestPropertiesConfig extends Config{

        @Config.Key("baseUrl")
        @Config.DefaultValue(BASE_URL)
        String getBaseURl();

        @Config.Key("username")
        String getUsername();

        @Config.Key("password")
        String getPassword();

        @Config.Key("browser")
        @Config.DefaultValue("chrome")
        String browser();

        @Config.Key("remoteUrl")
        String remoteUrl();
}
