public class mainTry {
    public static void main(String[] args) {

        // They are already existing in the system properties
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.version"));

        // Load properties from the properties file, but it will print null as the system doesn't know it yet
        // That's why we are using loadProperties function, as it gets all properties we wrote
        System.out.println(System.getProperty("browserType"));
    }
}
