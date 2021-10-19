import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    Properties prop;
    String configFileName;

    public PropertiesManager(String configFile) throws FileNotFoundException {
        this.prop = new Properties();
        this.configFileName = configFile;
    }

    public void load() throws IOException {
        this.prop.load(new FileInputStream(this.configFileName));
    }

    public void save() throws IOException {
        this.prop.store(new FileOutputStream(this.configFileName), null);
    }

    public String get(String key) {
        return this.prop.getProperty(key);
    }
}
