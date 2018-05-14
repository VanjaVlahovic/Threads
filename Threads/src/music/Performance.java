package music;

public class Performance {
    
    private Song song;
    private int delay;
    private String lyrics;
    
    public Performance(Song song, int delay) {
        super();
        this.song = song;
        this.delay = delay;
    }
    
    public Performance(String lyrics, int delay) {
    	super();
    	this.lyrics = lyrics;
    	this.delay = delay;
    }
    
    public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Performance() {
    }
    
    public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public int getDelay() {
        return delay;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }

}
