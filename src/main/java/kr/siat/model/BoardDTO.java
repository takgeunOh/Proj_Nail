package kr.siat.model;

public class BoardDTO {
	
	int num, viewCnt, likeCnt, repRoot, repStep, repIndent;
	String userEmail, author, title, content, regidate, videoName;
	
	// num, userEmail, author, title, content, regidate, viewcnt, likecnt, reproot, repstep, repindent, videoname 순
	public BoardDTO() {
		this(0, "", "", "", "", "", 0, 0, 0, 0, 0, "");
	}
	
	// userEmail, author, title, content, videoName
	public BoardDTO(String userEmail, String author, String title, String content, String videoName) {
		this(0, userEmail, author, title, content, "", 0, 0, 0, 0, 0, videoName);
	}
	
	public BoardDTO(int num ,String userEmail, String author, String title, String content, String regidate,
			int viewCnt, int likeCnt, int repRoot, int repStep, int repIndent, String videoName) {
		this.num = num;
		this.userEmail = userEmail;
		this.author = author;
		this.title = title;
		this.content = content;
		this.regidate = regidate;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
		this.videoName = videoName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	
}
