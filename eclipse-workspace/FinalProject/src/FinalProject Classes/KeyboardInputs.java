package FinalProject;
import java.util.Scanner;

public class KeyboardInputs {
    private static Scanner scanner = new Scanner(System.in);
    
    public static String readString() {
        return scanner.nextLine();
    }
    
    public static int readInteger() {
    	String in = scanner.nextLine();
    	try {
    		return Integer.parseInt(in);
    	} catch (NumberFormatException ex) {
    		return -1;
    	}
    }
    
    // Must close after retrieving any input from user! 
    public static void close() {
        scanner.close();
    }

}
