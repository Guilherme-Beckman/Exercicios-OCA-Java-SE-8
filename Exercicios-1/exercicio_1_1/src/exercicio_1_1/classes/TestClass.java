package exercicio_1_1.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class TestClass{
public static void main(String[] args){ 
try {
Files.createDirectories(Paths.get("logs"));

DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
LocalDateTime now= LocalDateTime.now();
String date = now.format(df);
String logFilename = "logs\\testlog-" + date + ".txt";
FileHandler myFileHandler = new FileHandler(logFilename);
myFileHandler.setFormatter(new SimpleFormatter());
Logger ocajLogger = Logger.getLogger("Ocaj Logger");
ocajLogger.setLevel(Level.ALL);
ocajLogger.addHandler(myFileHandler);
ocajLogger.info("\nThis is a logged information message.");
myFileHandler.close();
}
catch (IOException e) {
	System.out.println("Erro");
}
	
}
}