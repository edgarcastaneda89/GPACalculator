package FinalProject;

public class Movie {
	private String title, actorOne, actorTwo, director;
	private int year, runtime;
	
	public Movie(String title, String director, String actorOne, String actorTwo, int year, int runtime) {
        this.title = title.trim();
        this.actorOne = actorOne.trim();
        this.actorTwo = actorTwo.trim();
        this.year = year;
        this.runtime = runtime;
        this.director = director.trim();
    }
	
	 public String getTitle() {
	        return title;
	    }
	 
	 public String getDirector() {
	        return director;
	    }

	    public String getActorOne() {
	        return actorOne;
	    }

	    public String getActorTwo() {
	        return actorTwo;
	    }

	    public int getYear() {
	        return year;
	    }

	    public int getRuntime() {
	        return runtime;
	    }
	    
	    @Override
	    public String toString() {
	    	StringBuilder sb = new StringBuilder();
	    	sb = sb.append(title).append(",");
	    	sb = sb.append(director).append(",");
	    	sb = sb.append(actorOne).append(",");
	    	sb = sb.append(actorTwo).append(",");
	    	sb = sb.append(year).append(",");
	    	sb = sb.append(runtime);

	    	return sb.toString();
	    }

	    
}
	
	
	
	


