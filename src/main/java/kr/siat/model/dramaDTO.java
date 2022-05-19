package kr.siat.model;

public class dramaDTO {

	private int dramaNum; //占쏙옙호
	private String dramaGenre; //占썲르
	private String dramaTitle;  //占쏙옙占쏙옙
	private String dramaContent;  //占쌕거몌옙
	private String dramaDirector;  //占쏙옙占쏙옙
	private String dramaYear;  //占쏙옙占쏙옙占쏙옙占쏙옙
	private int dramaPrice;  //占쏙옙占쏙옙
	private String dramaCountry; //占쏙옙占쏙옙 占쏙옙占쏙옙
	private String dramaCompany; //占쏙옙憑占�
	private int dramaLikeCnt; //占쏙옙占싣울옙 占쏙옙占쏙옙
	private int dramaHide;  //占쏙옙占썼여占쏙옙
	private int dramaAge; // 占쏙옙占쏙옙占쏙옙占쏙옙
	
	
	
	public dramaDTO() {
		  this(0, "", "", "", "", "", 0,"","", 0, 0, 0);
	}
	
	 public dramaDTO(String genre, String title, String content, String director, String year, int price,
	         String country, String company, int hide, int age) {
	      this(0, genre, title, content, director, year, price, country, company, 0, hide, age);
	      
	   }
	
	
	public dramaDTO(int dramaNum, String dramaGenre, String dramaTitle, String dramaContent, String dramaDirector,
			String dramaYear, int dramaPrice, String dramaCountry, String dramaCompany, int dramaLikeCnt, int dramaHide,
			int dramaAge) {
		
	
		this.dramaNum = dramaNum;
		this.dramaGenre = dramaGenre;
		this.dramaTitle = dramaTitle;
		this.dramaContent = dramaContent;
		this.dramaDirector = dramaDirector;
		this.dramaYear = dramaYear;
		this.dramaPrice = dramaPrice;
		this.dramaCountry = dramaCountry;
		this.dramaCompany = dramaCompany;
		this.dramaLikeCnt = dramaLikeCnt;
		this.dramaHide = dramaHide;
		this.dramaAge = dramaAge;
		
	}
	
	
	
	
	
	
	public int getDramaNum() {
		return dramaNum;
	}
	public void setDramaNum(int dramaNum) {
		this.dramaNum = dramaNum;
	}
	public String getDramaGenre() {
		return dramaGenre;
	}
	public void setDramaGenre(String dramaGenre) {
		this.dramaGenre = dramaGenre;
	}
	public String getDramaTitle() {
		return dramaTitle;
	}
	public void setDramaTitle(String dramaTitle) {
		this.dramaTitle = dramaTitle;
	}
	public String getDramaContent() {
		return dramaContent;
	}
	public void setDramaContent(String dramaContent) {
		this.dramaContent = dramaContent;
	}
	public String getDramaDirector() {
		return dramaDirector;
	}
	public void setDramaDirector(String dramaDirector) {
		this.dramaDirector = dramaDirector;
	}
	public String getDramaYear() {
		return dramaYear;
	}
	public void setDramaYear(String dramaYear) {
		this.dramaYear = dramaYear;
	}
	public int getDramaPrice() {
		return dramaPrice;
	}
	public void setDramaPrice(int dramaPrice) {
		this.dramaPrice = dramaPrice;
	}
	public String getDramaCountry() {
		return dramaCountry;
	}
	public void setDramaCountry(String dramaCountry) {
		this.dramaCountry = dramaCountry;
	}
	public String getDramaCompany() {
		return dramaCompany;
	}
	public void setDramaCompany(String dramaCompany) {
		this.dramaCompany = dramaCompany;
	}
	public int getDramaLikeCnt() {
		return dramaLikeCnt;
	}
	public void setDramaLikeCnt(int dramaLikeCnt) {
		this.dramaLikeCnt = dramaLikeCnt;
	}
	public int getDramaHide() {
		return dramaHide;
	}
	public void setDramaHide(int dramaHide) {
		this.dramaHide = dramaHide;
	}
	public int getDramaAge() {
		return dramaAge;
	}
	public void setDramaAge(int dramaAge) {
		this.dramaAge = dramaAge;
	}
	@Override
	public String toString() {
		return "dramaDTO [dramaNum=" + dramaNum + ", dramaGenre=" + dramaGenre + ", dramaTitle=" + dramaTitle
				+ ", dramaContent=" + dramaContent + ", dramaDirector=" + dramaDirector + ", dramaYear=" + dramaYear
				+ ", dramaPrice=" + dramaPrice + ", dramaCountry=" + dramaCountry + ", dramaCompany=" + dramaCompany
				+ ", dramaLikeCnt=" + dramaLikeCnt + ", dramaHide=" + dramaHide + ", dramaAge=" + dramaAge + "]";
	}
	
	
	
}
