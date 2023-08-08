package movie24.info.model.vo;

import java.sql.Date;

public class MovieInfo {
	private int movieNum;
	private String movieName;
	private String movieSrc;
	private int dDay;
	private int reservationRate;
	private String reservationYN;
	private String director;
	private String actor;
	private String genre;
	private String basicInfo;
	private Date openDate;
	private String contentInfo;
	private String video;
	
	public MovieInfo() {}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieSrc() {
		return movieSrc;
	}

	public void setMovieSrc(String movieSrc) {
		this.movieSrc = movieSrc;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	public int getReservationRate() {
		return reservationRate;
	}

	public void setReservationRate(int reservationRate) {
		this.reservationRate = reservationRate;
	}

	public String getReservationYN() {
		return reservationYN;
	}

	public void setReservationYN(String reservationYN) {
		this.reservationYN = reservationYN;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getContentInfo() {
		return contentInfo;
	}

	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	
}
