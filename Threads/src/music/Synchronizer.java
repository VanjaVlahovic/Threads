package music;


public class Synchronizer {
    
    public boolean firstVoiceFlag;
    public boolean secondVoiceFlag;
    
    public Synchronizer(boolean firstVoiceFlag, boolean secondVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
    }
    
    public synchronized void singFirstVoice(Song song, int delay) {
        while (!firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(song, delay, null);
    }
    
    public synchronized void singSecondVoice(Song song, int delay) {
        while (!secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(song, delay, null);
    }
    
    public synchronized void singGuitarSolo(String lyrics, int delay) {
        while (firstVoiceFlag || secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(null, delay, lyrics);
    }
    
    private void sing(Song song, int delay, String lyrics) {
        if (firstVoiceFlag && !secondVoiceFlag) {
        	singVerse(song.getStrophe1().getVerse1(), delay);
        	singVerse(song.getStrophe1().getVerse2(), delay);
        	singVerse(song.getStrophe1().getVerse3(), delay);
        	singVerse(song.getStrophe1().getVerse4(), delay);
        	singVerse(song.getStrophe1().getVerse5(), delay);
        	secondVoiceFlag = true;
        }else{ 
        	if (firstVoiceFlag && secondVoiceFlag) {
        		singVerse(song.getPreChorus().getVerse1(), delay);
            	singVerse(song.getPreChorus().getVerse2(), delay);
            	singVerse(song.getPreChorus().getVerse3(), delay);
            	singVerse(song.getPreChorus().getVerse4(), delay);
            	singVerse(song.getPreChorus().getVerse5(), delay);
            	
            	singVerse(song.getChorus().getVerse1(), delay);
            	singVerse(song.getChorus().getVerse2(), delay);
            	singVerse(song.getChorus().getVerse3(), delay);
            	singVerse(song.getChorus().getVerse4(), delay);
            	singVerse(song.getChorus().getVerse5(), delay);
            	
            	firstVoiceFlag = false;
            	secondVoiceFlag = false;
        	}else {
        		if(secondVoiceFlag) {
        			singVerse(song.getStrophe2().getVerse1(), delay);
                	singVerse(song.getStrophe2().getVerse2(), delay);
                	singVerse(song.getStrophe2().getVerse3(), delay);
                	singVerse(song.getStrophe2().getVerse4(), delay);
                	singVerse(song.getStrophe2().getVerse5(), delay);        			
        			firstVoiceFlag = true;
        		}else {
        			System.out.println(lyrics);
        			try {
        				wait(delay);
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}       
        			secondVoiceFlag = true;
        		}
        	}
        }
        notifyAll();
    }

    private void singVerse(String verse, int delay) {
    	System.out.println(verse);
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}

