package DramaModel;

public class dramaDTO {

	private int dramaNum; //번호
	private String dramaGenre; //장르
	private String dramaTitle;  //제목
	private String dramaContent;  //줄거리
	private String dramaDirector;  //감독
	private int dramaYear;  //개봉연도
	private int dramaPrice;  //가격
	private String dramaCountry; //제작 국가
	private String dramaCompany; //배급사
	private int dramaLikeCnt; //좋아요 개수
	private int dramaHide;  //숨김여부
	private int dramaAge; // 연령제한
	
	
	
	public dramaDTO() {
		this(0, "", "", "", "", 0, 0,"","", 0, 0, 0);
	}
	
	
	
	
	public dramaDTO(int dramaNum, String dramaGenre, String dramaTitle, String dramaContent, String dramaDirector,
			int dramaYear, int dramaPrice, String dramaCountry, String dramaCompany, int dramaLikeCnt, int dramaHide,
			int dramaAge) {
		super();
	
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
	public int getDramaYear() {
		return dramaYear;
	}
	public void setDramaYear(int dramaYear) {
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
