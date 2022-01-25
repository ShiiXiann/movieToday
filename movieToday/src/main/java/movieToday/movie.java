package movieToday;

public class movie {

	protected int id;
	protected String movieName;
	protected String movieGenre;
	protected String movieDescription;
	protected String movieCasts;
	protected float movieDuration;
	protected String movieDateRelease;
	protected String movieImage;
	
	public movie(int id, String movieName, String movieGenre, String movieDescription, String movieCasts, float movieDuration, String movieDateRelease, String movieImage) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDescription = movieDescription;
		this.movieCasts = movieCasts;
		this.movieDuration = movieDuration;
		this.movieDateRelease = movieDateRelease;
		this.movieImage = movieImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieCasts() {
		return movieCasts;
	}

	public void setMovieCasts(String movieCasts) {
		this.movieCasts = movieCasts;
	}

	public float getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(float movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieDateRelease() {
		return movieDateRelease;
	}

	public void setMovieDateRelease(String movieDateRelease) {
		this.movieDateRelease = movieDateRelease;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}


}
