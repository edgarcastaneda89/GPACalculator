package FinalProject;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileReader;

public class FileIO {

    public static void writeToFile(String filename, ArrayList<Movie> db) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Movie se : db) {
            	writer.write(se.toString());
            	writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Movie> readFromFile(String filename) {
    	
    	ArrayList<Movie> db = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while((line = reader.readLine()) != null) {
            	if (line.trim().isEmpty()) {
            		continue;
            	}

            	
            	StringTokenizer st = new StringTokenizer(line, ",");           	
            	
            	if(st.countTokens() >= 6) {
                    String title = st.nextToken().trim();
                    String director = st.nextToken().trim();
                    String actorOne = st.nextToken().trim();
                    String actorTwo = st.nextToken().trim();
                    int year = Integer.parseInt(st.nextToken().trim());
                    int runtime = Integer.parseInt(st.nextToken().trim());
                    Movie movie = new Movie(title, director, actorOne, actorTwo, year, runtime);
                    db.add(movie);
            	} else {
            		System.out.println("****** WARNING ******");
            		System.out.println("-This movie does not have required parameters:\n" + "-" + line + "\n-Please note: that specific movie wont handle commands properly" + 
            							" until it is fixed\n");
            	}
      
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
            }

		return db;  
    }
}
