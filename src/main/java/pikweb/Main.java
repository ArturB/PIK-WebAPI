package pikweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Main application class.
 * It contains embedded Tomcat server, so you don't have to install Tomcat server youself and deploy a WAR file.
 * Just run the application JAR and the web server will be started immediately.
 *
 * @author Artur M. Brodzki
 * @version 0.6
 */

@SpringBootApplication
public class Main {

    /**
     * Application entry point.
     * Spring Boot runs a web app and embedded Tomcat server here.
     * @param args - command line parameters
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }



}