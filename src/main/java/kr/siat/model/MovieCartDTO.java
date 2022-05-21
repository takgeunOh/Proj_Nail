package kr.siat.model;

public class MovieCartDTO {
	int num, movieNum, dramaNum, price;
	String title, content;
	
	public MovieCartDTO() {
		this(0, 0, 0, "", "", 0);
	}
	
	public MovieCartDTO(int num, int movieNum, int dramaNum, String title, String content, int price) {
		this.num = num;
		this.movieNum = movieNum;
		this.dramaNum = dramaNum;
		this.title = title;
		this.content = content;
		this.price = price;
	}

	public int getDramaNum() {
		return dramaNum;
	}

	public void setDramaNum(int dramaNum) {
		this.dramaNum = dramaNum;
	}


	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
