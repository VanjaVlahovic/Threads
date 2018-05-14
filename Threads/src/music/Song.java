package music;

public class Song {
	private Strophe strophe1;
	private Strophe preChorus;
	private Strophe strophe2;
	private Strophe preChorus2;
	private Strophe chorus ;	
	
	public Song() {
		this.strophe1 = new Strophe( "Take me now baby here as I am", 
				"Pull me close, try and understand", 
				"Desire is hunger in the fire I breathe", 
				"Love is a banquet on which we feed", 
				" "); 
		this.preChorus = new Strophe("Come on now try and understand", 
				"The way I feel when I'm in your hands", 
				"Take my hand come undercover", 
				"They can't hurt you now,", 
				"Can't hurt you now, can't hurt you now");
		this.strophe2 = new Strophe("Have I doubt when I'm alone", 
				"Love is a ring, the telephone", 
				"Love is an angel disguised as lust", 
				"Here in our bad until the morning comes", 
				" ");
		this.preChorus2 = new Strophe("With love we sleep, with doubt the vicious circle", 
				"Turn and burns without you I cannot live", 
				"Forgive, the yearning burning", 
				"I believe it's time, too real to feel", 
				"So touch me now, touch me now, touch me now");
		this.chorus = new Strophe("Because the night belongs to lovers", 
				"Because the night belongs to lust", 
				"Because the night belongs to lovers", 
				"Because the night belongs to us", 
				" ");	
	}
	public Strophe getStrophe1() {
		return strophe1;
	}
	public void setStrophe1(Strophe strophe1) {
		this.strophe1 = strophe1;
	}
	public Strophe getPreChorus() {
		return preChorus;
	}
	public void setPreChorus(Strophe preChorus) {
		this.preChorus = preChorus;
	}
	public Strophe getStrophe2() {
		return strophe2;
	}
	public void setStrophe2(Strophe strophe2) {
		this.strophe2 = strophe2;
	}
	public Strophe getPreChorus2() {
		return preChorus2;
	}
	public void setPreChorus2(Strophe preChorus2) {
		this.preChorus2 = preChorus2;
	}
	public Strophe getChorus() {
		return chorus;
	}
	public void setChorus(Strophe chorus) {
		this.chorus = chorus;
	}
	
	
}