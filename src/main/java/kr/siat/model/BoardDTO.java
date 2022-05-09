package kr.siat.model;

public class BoardDTO {
	int boardNum, boardViewCnt, boardLikeCnt, boardRepRoot, boardRepStep, boardRepIndent;
	String boardAuthor, boardTitle, boardContent, boardPassword, boardRegidate;
	
	public BoardDTO() {
		this(0, "", "", "", "", "", 0, 0, 0, 0, 0);
	}
	
	public BoardDTO(String boardAuthor, String boardTitle, String boardContent, String boardPassword) {
		this(0, boardAuthor, boardTitle, boardContent, boardPassword, "", 0, 0, 0, 0, 0);
	}
	
	public BoardDTO(int boardNum, String boardAuthor, String boardTitle, String boardContent, String boardPassword, String boardRegidate, int boardViewCnt,
			int boardLikeCnt, int boardRepRoot, int boardRepStep, int boardRepIndent) {
		this.boardNum = boardNum;
		this.boardAuthor = boardAuthor;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardPassword = boardPassword;
		this.boardRegidate = boardRegidate;
		this.boardViewCnt = boardViewCnt;
		this.boardLikeCnt = boardLikeCnt;
		this.boardRepRoot = boardRepRoot;
		this.boardRepStep = boardRepStep;
		this.boardRepIndent = boardRepIndent;
	}
	
	
	
	
	public String getBoardPassword() {
		return boardPassword;
	}

	public void setBoardPassword(String boardPassword) {
		this.boardPassword = boardPassword;
	}

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getBoardViewCnt() {
		return boardViewCnt;
	}
	public void setBoardViewCnt(int boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
	}
	public int getBoardLikeCnt() {
		return boardLikeCnt;
	}
	public void setBoardLikeCnt(int boardLikeCnt) {
		this.boardLikeCnt = boardLikeCnt;
	}
	public int getBoardRepRoot() {
		return boardRepRoot;
	}
	public void setBoardRepRoot(int boardRepRoot) {
		this.boardRepRoot = boardRepRoot;
	}
	public int getBoardRepStep() {
		return boardRepStep;
	}
	public void setBoardRepStep(int boardRepStep) {
		this.boardRepStep = boardRepStep;
	}
	public int getBoardRepIndent() {
		return boardRepIndent;
	}
	public void setBoardRepIndent(int boardRepIndent) {
		this.boardRepIndent = boardRepIndent;
	}
	public String getBoardAuthor() {
		return boardAuthor;
	}
	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardRegidate() {
		return boardRegidate;
	}
	public void setBoardRegidate(String boardRegidate) {
		this.boardRegidate = boardRegidate;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", boardViewCnt=" + boardViewCnt + ", boardLikeCnt=" + boardLikeCnt
				+ ", boardRepRoot=" + boardRepRoot + ", boardRepStep=" + boardRepStep + ", boardRepIndent="
				+ boardRepIndent + ", boardAuthor=" + boardAuthor + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardRegidate=" + boardRegidate + "]";
	}
	
	
}
