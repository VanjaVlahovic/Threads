package music;

public class Strophe {
	private String verse1;
	private String verse2;
	private String verse3;
	private String verse4;
	private String verse5;
	
	public Strophe(String verse1, String verse2, String verse3, String verse4, String verse5 ) {
		this.verse1 =verse1;
		this.verse2 =verse2;
		this.verse3 =verse3;
		this.verse4 =verse4;
		this.verse5 =verse5;		
	}	
	public String getVerse1() {
		return verse1;
	}
	public void setVerse1(String verse1) {
		this.verse1 = verse1;
	}
	public String getVerse2() {
		return verse2;
	}
	public void setVerse2(String verse2) {
		this.verse2 = verse2;
	}
	public String getVerse3() {
		return verse3;
	}
	public void setVerse3(String verse3) {
		this.verse3 = verse3;
	}
	public String getVerse4() {
		return verse4;
	}
	public void setVerse4(String verse4) {
		this.verse4 = verse4;
	}
	public String getVerse5() {
		return verse5;
	}
	public void setVerse5(String verse5) {
		this.verse5 = verse5;
	}
	
	
}
