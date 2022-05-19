package kr.siat.model;

public class MovieDTO {
   //cmd    Movietable      
   
   private int movieNum; //  ȣ
   private String movieGenre; // 帣
   private String movieTitle;  //    
   private String movieContent;  // ٰŸ 
   private String movieDirector;  //    
   private String movieYear;  //        
   private int moviePrice;  //    
   private String movieCountry; //         
   private String movieCompany; //  ޻ 
   private int movieLikeCnt; //   ƿ      
   private int movieHide;  //   迩  
   private int movieAge; //         
   
   
   
   
   
   
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
      this(0, "", "", "", "", "", 0,"","", 0, 0, 0);
   }
   

   public MovieDTO(String genre, String title, String content, String director, String year, int price,
         String country, String company, int hide, int age) {
      this(0, genre, title, content, director, year, price, country, company, 0, hide, age);
      
   }

   public MovieDTO(int movieNum, String movieGenre, String movieTitle, String movieContent, String movieDirector,
         String movieYear, int moviePrice, String movieCountry, String movieCompany, int movieLikeCnt, int movieHide,
         int movieAge) {
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

   public String getMovieYear() {
      return movieYear;
   }


   public void setMovieYear(String movieYear) {
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