package filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProperties {

    Properties prop = new Properties();
    FileInputStream fis = new FileInputStream("src/test/java/resources/testdata.properties");

    public readProperties() throws FileNotFoundException {
    }

    public Object getUsername() throws IOException {
        prop.load(fis);
        return prop.getProperty("username");
    }

    public Object getIncorrectSignUpUsername() throws IOException {
        prop.load(fis);
        return prop.getProperty("incorrectSignUpUsername");
    }

    public Object getIncorrectUsername() throws IOException {
        prop.load(fis);
        return prop.getProperty("incorrectUsername");
    }

    public Object getPassword() throws IOException {
        prop.load(fis);
        return prop.getProperty("password");
    }

    public Object getIncorrectPassword() throws IOException {
        prop.load(fis);
        return prop.getProperty("incorrectPassword");
    }
}
