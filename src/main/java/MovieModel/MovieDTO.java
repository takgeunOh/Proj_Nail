package MovieModel;

public class MovieDTO {
	//cmd 로 Movietable 만들기
	
	private int movieNum; //번호
	private String movieGenre; //장르
	private String movieTitle;  //제목
	private String movieContent;  //줄거리
	private String movieDirector;  //감독
	private int movieYear;  //개봉연도
	private int moviePrice;  //가격
	private String movieCountry; //제작 국가
	private String movieCompany; //배급사
	private int movieLikeCnt; //좋아요 개수
	private int movieHide;  //숨김여부
	private int movieAge; // 연령제한
	
	
	
	
	
	
	/*public MovieDTO(int movieNum, String movieGenre, String movieTitle, String movieContent, String movieDirector,
			int movieYear, int moviePrice, String movieCountry, String movieCompany, int movieLikeCnt, int movieHide) {
		super();
		this.movieNum = movieNum;
		this.movieGenre = movieGenre;
		this.movieTitle = movieTitle;
		this.movieContent = movieContent;
		this.movieDirector = movieDirector;
		this.movieYear = movieYear;
		this.moviePrice = moviePrice;
		this.movieCountry = movieCountry;
		this.movieCompany = movieCompany;
		this.movieLikeCnt = movieLikeCnt;
		this.movieHide = movieHide;
	}
	*/
	
	
	public MovieDTO() {
		this(0, "", "", "", "", 0, 0,"","", 0, 0, 0);
	}
	

	

	public MovieDTO(int movieNum, String movieGenre, String movieTitle, String movieContent, String movieDirector,
			int movieYear, int moviePrice, String movieCountry, String movieCompany, int movieLikeCnt, int movieHide,
			int movieAge) {
		super();
		this.movieNum = movieNum;
		this.movieGenre = movieGenre;
		this.movieTitle = movieTitle;
		this.movieContent = movieContent;
		this.movieDirector = movieDirector;
		this.movieYear = movieYear;
		this.moviePrice = moviePrice;
		this.movieCountry = movieCountry;
		this.movieCompany = movieCompany;
		this.movieLikeCnt = movieLikeCnt;
		this.movieHide = movieHide;
		this.movieAge = movieAge;
	}



	public int getMovieAge() {
		return movieAge;
	}



	public void setMovieAge(int movieAge) {
		this.movieAge = movieAge;
	}



	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieContent() {
		return movieContent;
	}
	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	public String getMovieCountry() {
		return movieCountry;
	}
	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}
	public String getMovieCompany() {
		return movieCompany;
	}
	public void setMovieCompany(String movieCompany) {
		this.movieCompany = movieCompany;
	}
	public int getMovieLikeCnt() {
		return movieLikeCnt;
	}
	public void setMovieLikeCnt(int movieLikeCnt) {
		this.movieLikeCnt = movieLikeCnt;
	}
	public int getMovieHide() {
		return movieHide;
	}
	public void setMovieHide(int movieHide) {
		this.movieHide = movieHide;
	}
		
	@Override
	public String toString() {
		return "MovieDTO [movieNum=" + movieNum + ", movieGenre=" + movieGenre + ", movieTitle=" + movieTitle
				+ ", movieContent=" + movieContent + ", movieDirector=" + movieDirector + ", movieYear=" + movieYear
				+ ", moviePrice=" + moviePrice + ", movieCountry=" + movieCountry + ", movieCompany=" + movieCompany
				+ ", movieLikeCnt=" + movieLikeCnt + ", movieHide=" + movieHide + ", movieAge=" + movieAge + "]";
	}
		
}
