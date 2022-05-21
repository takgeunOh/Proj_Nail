package kr.siat.model;

public class FeedbackAnswerDTO {
	int num, boardnum;
	String author, answer;
	
	public FeedbackAnswerDTO() {
		this(0, 0, "", "");
	}
	
	public FeedbackAnswerDTO(int boardNum, String author, String answer) {
		this(0, boardNum, author, answer);
	}
	
	public FeedbackAnswerDTO(int num, int boardNum, String author, String answer) {
		this.num = num;
		this.boardnum = boardNum;
		this.author = author;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "FeedbackAnswerDTO [num=" + num + ", boardnum=" + boardnum + ", author=" + author + ", answer=" + answer
				+ "]";
	}

	public int getNum() {
		return num;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
