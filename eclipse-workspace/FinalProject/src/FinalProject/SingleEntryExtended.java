package FinalProject;

import java.util.ArrayList;
import java.util.Scanner;
import FinalProject.KeyboardInputs;
import FinalProject.FileIO;
import FinalProject.Movie;


public class SingleEntryExtended {
	private ArrayList<Movie> db;
	private final String filename;
	
	public SingleEntryExtended(String filename) {
		this.filename = filename;
		db = FileIO.readFromFile(filename);
		
	}
	
	// New Entry!
	public void newEntry() {
		
		 int year, runtime;
		 
	    System.out.print("Enter Title> ");
	    String title = KeyboardInputs.readString();

	    // Check for a minimum of 3 chars in title
	    if (title.length() < 3) {
	        System.out.println("Please enter a valid title!!");
	        return;
	    }
	    
	    // Prompts user for Year
	    System.out.print("Enter Year> ");
	    String yearInput = KeyboardInputs.readString();
	    
	    try {
	        year = Integer.parseInt(yearInput);
	    } catch (NumberFormatException e) {
	        System.out.println("Please enter a valid integer (no decimals) value for the runtime!\n");
	        return;
	    }
	    
	    // Prompts user for Runtime
	    System.out.print("Enter Runtime (minutes)> ");
	    String runtimeInput = KeyboardInputs.readString();
	    
	    try {
	        runtime = Integer.parseInt(runtimeInput);
	    } catch (NumberFormatException e) {
	        System.out.println("Please enter a valid integer (no decimals) value for the runtime!\n");
	        return;
	    }
	    
	    // Prompts user for Actor One & Two
	    System.out.print("Enter Actor 1> ");
	    String actor1 = KeyboardInputs.readString();
	    
	    System.out.print("Enter Actor 2> ");
	    String actor2 = KeyboardInputs.readString();
	    
	    // Prompts user for Director
	    System.out.print("Enter Director> ");
	    String director = KeyboardInputs.readString();
	    System.out.println();

	    Movie movie = new Movie(title, director, actor1, actor2, year, runtime);
	    db.add(movie);
	}
	
	
	// Search by Actor method 
	public void searchByActor(String actorGiven) {
	    String titlesStarredIn = "";
	    
	    if (db == null) {
	        System.out.println("Not in database! Try again\n");
	    }
	    
	    actorGiven = actorGiven.trim();
	    
	    if (actorGiven.isEmpty()) {
	        System.out.println("Not a valid Actor, please try again!\n");
	        
	    } else {
	    	
	    	// Search for actor in movies and add matching titles to result
	    	// This is done for Actor One & Two
		    for (Movie movie : db) {
		    	
		    	// Making input non case sensitive
		        if (movie.getActorOne().toLowerCase().equals(actorGiven.toLowerCase())) {
		            if (titlesStarredIn.isEmpty()) {
		                titlesStarredIn += movie.getTitle();
		            } else {
		                titlesStarredIn += ", " + movie.getTitle();
		            }
		        }
		        
		        if (movie.getActorTwo().toLowerCase().equals(actorGiven.toLowerCase())) {
		            if (titlesStarredIn.isEmpty()) {
		                titlesStarredIn += movie.getTitle();
		            } else {
		                titlesStarredIn += ", " + movie.getTitle();
		            }
		        }
		    }

		    // Print result
		    if (titlesStarredIn.isEmpty()) {
		        System.out.println("Actor not found!");     
		
		    	} else {
		        System.out.println(actorGiven + " has starred in the following movies: " + titlesStarredIn + "\n");   
		    	}
		    }
	    
	}

	// search by Year
	public void searchByYear (String yearGiven) {
	    ArrayList<String> movieTitles = new ArrayList<>();
	    
	    if (db == null) {
	        System.out.println("Not in database! Try again\n");
	    }
	    
	    for (Movie movie : db) {
	    	if (String.valueOf(movie.getYear()).equals(yearGiven)){
	    		movieTitles.add(movie.getTitle());
	    	}
	    }
	    
	    // Print result
	    if (movieTitles.isEmpty()) {
	        System.out.println("Title not found for the year you inputted!\n");
	    } else {
	        System.out.println("Movie(s) found made in " + yearGiven + ": ");
	        for (String title : movieTitles) {
	            System.out.println("- " + title);
	        }
	        System.out.println();
	    
	    }
	}
	
	// Search by Runtime in Mins
	public void searchByRuntime(int runtimeInput) {
	    ArrayList<String> movieTitles = new ArrayList<>();
	    
	    if (db == null) {
	        System.out.println("Not in database! Try again\n");
	    }
	    
	    for (Movie movie : db) {
	        if (movie.getRuntime() == runtimeInput) {
	            movieTitles.add(movie.getTitle());
	        }
	    }
	    
	    // Print result
	    if (movieTitles.isEmpty()) {
	        System.out.println("Title not found for the Runtime you inputted!\n");
	    } else {
	        System.out.println("Movie(s) found with " + runtimeInput + " (mins) of runtime: ");
	        for (String runTimeTitles : movieTitles) {
	            System.out.println("- " + runTimeTitles);
	        }
	        System.out.println();
	    }
	}
 
	public void searchByDirector(String directorGiven) {
	    String titlesCreated = "";
	    
	    if (db == null) {
	        System.out.println("Not in database! Try again\n");
	    }
	    
	    directorGiven = directorGiven.trim();
	    if (directorGiven.isEmpty()) {
	        System.out.println("Not a valid director, please try again!\n");
	    } else {

		    // Search for director in movies and add matching titles to result
		    for (Movie movie : db) {
		        // Making input non case sensitive
		        if (movie.getDirector().toLowerCase().equals(directorGiven.toLowerCase())) {
		            if (titlesCreated.isEmpty()) {
		                titlesCreated += movie.getTitle();
		            } else {
		                titlesCreated += ", " + movie.getTitle();
		            }
		        }
		    }
	
		    // Print result
		    if (titlesCreated.isEmpty()) {
		        System.out.println("Director not found!\n");     
		    } else {
		        System.out.println(directorGiven + " has made the following movie(s): " + titlesCreated + "\n");
		    }
	    
	    }
	}

	
	// Search By Title 
	public void searchByTitle(String titleGiven) {
	    String movieDescription = "";

	    if (db == null) {
	        System.out.println("Not in database! Try again\n");
	    }
	    
		titleGiven = titleGiven.trim();
	    
	    if (titleGiven.isEmpty()) {
	        System.out.println("Not a valid title, please try again!\n");
	    } else { 

		    // Search for title in movies and add matching movie description to result
		    for (Movie movie : db) {
	
		        // Making input non-case sensitive
		        if (movie.getTitle().toLowerCase().equals(titleGiven.toLowerCase())) {
		            if (movieDescription.isEmpty()) {
		                movieDescription = "Actors: " + movie.getActorOne() + ", " + movie.getActorTwo() + "\nDirector: " + movie.getDirector() + 
		                        "\nYear: " + movie.getYear() + "\nRuntime: " +  movie.getRuntime() + " mins";
		            }
		        }
		    }
	
		    // Print result
		    if (movieDescription.isEmpty()) {
		        System.out.println("Title not found!\n");     
	
		    } else {
		        System.out.println(titleGiven + " description: \n" + movieDescription + "\n");
		    }
	    }
	}
		
	// Main menu prompt 
	public static void mainMenu() {
		System.out.print(" a.)new entry\n b.)search by actor\n c.)search by year\n d.)search by runtime (in minutes)\n " + 
				"e.)search by director\n f.)search by title\n g.)quit\n"); 
	}

	// Run Workhorse method
	public void run() {
		boolean quitRequest = false;
		
		while (!quitRequest) {
		
		 String input, actor, year, director, title;

		 int runtime;
		 mainMenu();
	     System.out.print("\nEnter command > ");
	     input = KeyboardInputs.readString();
	     
	     switch (input.toLowerCase()) {
	     case "a":
	      	 newEntry();
	         break;
	    	 
	         case "b":
	        	 System.out.print("Enter Actor > ");
	        	 actor = KeyboardInputs.readString();
	        	 System.out.println();
	        	 searchByActor(actor);	
	             break;
	             
	         case "c":
	        	 System.out.print("Enter Year > ");
	        	 year = KeyboardInputs.readString();
	        	 System.out.println();
	        	 searchByYear(year);	
	             break;
	             
	         case "d":
	        	 System.out.print("Enter runtime (minutes) > ");
	        	 runtime = KeyboardInputs.readInteger();
	        	 System.out.println();
	        	 searchByRuntime(runtime);	
	             break;
	             
	         case "e":
	        	 System.out.print("Enter Director > ");
	        	 director = KeyboardInputs.readString();
	        	 System.out.println();
	        	 searchByDirector(director);
	             break;
	             
	         case "f":
	        	 System.out.print("Enter Title > ");
	        	 title = KeyboardInputs.readString();
	        	 System.out.println();
	        	 searchByTitle(title);
	             break;
	             
	         case "g":
	        	 KeyboardInputs.close();
	        	 System.out.println("Program Terminated :)");
	        	 quitRequest = true;
	        	 FileIO.writeToFile(filename, db);
	        	 break;

	         default:
	             System.out.println("Invalid command:" + input);
	             break;
	        }
					    
		}
	}

	public static void main(String args[]) {
		
		// prints menu
		System.out.println("Welcome to Google KnockOff LLC Datebase and other stuff. Please choose from the following options: \n");
		
		SingleEntryExtended see = new SingleEntryExtended("db.txt");
		see.run();
		KeyboardInputs.close();
		
	}

}