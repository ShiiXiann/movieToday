package movieToday;

public class Review {
	public Review(int id, int movie_id, int user_id, String review) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.user_id = user_id;
		this.review = review;
	}
	protected int id;
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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	protected int movie_id;
	protected int user_id;
	protected String review;

}
