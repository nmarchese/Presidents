package data;

public class President {
	private int termNum;
	private String name;
	private String dates;
	private String party;
	private String fact;
	private String imgUrl;

	public President(int termNum, String name, String dates, String party, String fact, String imgUrl) {
		super();
		this.name = name;
		this.termNum = termNum;
		this.dates = dates;
		this.party = party;
		this.fact = fact;
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}
	public int getTermNum() {
		return termNum;
	}
	public String getDates() {
		return dates;
	}
	public String getParty() {
		return party;
	}
	public String getFact() {
		return fact;
	}
	public String getImgUrl() {
		return imgUrl;
	}
}