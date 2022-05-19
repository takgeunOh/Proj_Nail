package kr.siat.model;

public class CartDTO {
	int num, price, likeCnt, hide, age;
	String genre, title, content, director, year, country, company;
	
	public CartDTO() {
		this(0, "", "", "", "", "", 0, "", "", 0, 0, 0);
	}

	public CartDTO(int num, String genre, String title, String content, String director, String year, int price, String country, String company, int likeCnt, int hide, int age) {
		this.num = num;
		this.genre = genre;
		this.title = title;
		this.content = content;
		this.director = director;
		this.year = year;
		this.price = price;
		this.country = country;
		this.likeCnt = likeCnt;
		this.hide = hide;
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", price=" + price + ", likeCnt=" + likeCnt + ", hide=" + hide + ", age=" + age
				+ ", genre=" + genre + ", title=" + title + ", content=" + content + ", director=" + director
				+ ", year=" + year + ", country=" + country + ", company=" + company + "]";
	}
	
	
}
