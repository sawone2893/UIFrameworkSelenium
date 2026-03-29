package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        
        String envConfigPath = System.getProperty("user.dir")+"/src/main/resources/envConfig/";
        try{
        	// 1. Load Global Defaults
            FileInputStream globalFile = new FileInputStream(envConfigPath+"config-global.properties");
            props.load(globalFile);
            
           // 2. Identify Environment
            String env = System.getProperty("env", "qa"); // Defaults to qa if not specified
            // 3. Load Environment Specifics (Overwrites global if keys match)
            FileInputStream envFile = new FileInputStream(envConfigPath+"config" + env + ".properties");
            props.load(envFile);
        } catch (IOException e) {
        	throw new RuntimeException("Could not load configuration files.");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String getOrDefault(String key, String def) {
        return props.getProperty(key, def);
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(props.getProperty(key, "false"));
    }
}
