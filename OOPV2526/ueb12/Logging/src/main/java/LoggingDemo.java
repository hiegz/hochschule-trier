import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
	static {
		System.setProperty("logback.configurationFile", LoggingDemo.class.getClassLoader().getResource("logback.xml").toExternalForm());
	}
	
	static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
	
	public static void main(String[] args) {
		logger.debug("Debug-Nachricht");
		logger.info("Information");
		logger.warn("Warnung");
		logger.error("Fehlermeldung", new RuntimeException());
		method();
	}
	
	public static void method() {
		logger.info("Weitere Information");
	}

}
