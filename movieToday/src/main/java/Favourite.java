

public class Favourite {
	protected int id;
	protected int movie_id;
	protected int user_id;
	
	public Favourite(int id, int movie_id, int user_id) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
