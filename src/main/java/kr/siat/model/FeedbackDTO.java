package kr.siat.model;

public class FeedbackDTO {
	int num, viewcnt, answerCheck;			// answerCheck 값이 0이면 답변대기, 1이면 답변처리중, 2면 답변완료
	String author, title, content, regidate;
	
	
	public int getAnswerCheck() {
		return answerCheck;
	}

	public void setAnswerCheck(int answerCheck) {
		this.answerCheck = answerCheck;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public FeedbackDTO() {
		this(0, "", "", "", "", 0, 0);
	}
	
	public FeedbackDTO(String author, String title, String content) {
		this(0, author, title, content, "", 0, 0);
	}
	public FeedbackDTO(int num, String author, String title, String content, String regidate, int viewcnt, int answerCheck) {
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.regidate = regidate;
		this.viewcnt = viewcnt;
		this.answerCheck = answerCheck;
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
	
}
