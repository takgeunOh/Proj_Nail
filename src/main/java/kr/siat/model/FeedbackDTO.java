package kr.siat.model;

public class FeedbackDTO {
	int num, viewcnt;
	String author, title, content, password, repauthor, repcontent, regidate;
	
	
	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public FeedbackDTO() {
		this(0, "", "", "", "", "", 0, "", "");
	}
	
	public FeedbackDTO(String author, String title, String content, String password, String repauthor, String repcontent) {
		this(0, author, title, content, password, "", 0, repauthor, repcontent);
	}
	public FeedbackDTO(int num, String author, String title, String content, String password, String regidate, int viewcnt,
			String repauthor, String repcontent) {
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.password = password;
		this.regidate = regidate;
		this.viewcnt = viewcnt;
		this.repauthor = repauthor;
		this.repcontent = repcontent;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepauthor() {
		return repauthor;
	}
	public void setRepauthor(String repauthor) {
		this.repauthor = repauthor;
	}
	public String getRepcontent() {
		return repcontent;
	}
	public void setRepcontent(String repcontent) {
		this.repcontent = repcontent;
	}
	
	
}
