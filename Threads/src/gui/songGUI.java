package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import music.Performance;

import music.Song;

import music.Voice;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class songGUI extends JFrame{

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnStop;
	private JButton btnStart;
	private JButton btnStartPatty;
	private JButton btnStartBruce;
	private JScrollPane scrollPane;
	public JTextArea textArea;
	private JButton btnStopPatty;
	private JButton btnStopBruce;
	private JButton btnStartInstrumental;
	private JButton btnStopInstrumental;
	
	private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer guitar;
    private Song song= new Song();
    private String lyrics3 = "Instrumental";
    boolean stopIt = false;

    SynchronizerGUI synch = new SynchronizerGUI(true, false, false, false);
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					songGUI frame = new songGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public songGUI() {
		createContents();
	}
	private void createContents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
		initializeSingingInThreads();
	}
	
	 private void initializeSingingInThreads() {
	 
	        
	        
	        Performance firstVoicePerformance = new Performance(song, 1500);
	        Performance secondVoicePerformance = new Performance(song, 1500);
	        Performance guitarPerformance = new Performance(lyrics3, 1500);
	        
	        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
	        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
	        guitar  = new Singer("Giutar", Voice.BACKGROUND, guitarPerformance, stopIt, synch );
	 }
	
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(120, 50));
			panel.setLayout(null);
			panel.add(getBtnStop());
			panel.add(getBtnStart());
			panel.add(getBtnStartPatty());
			panel.add(getBtnStartBruce());
			panel.add(getBtnStopPatty());
			panel.add(getBtnStopBruce());
			panel.add(getBtnStartInstrumental());
			panel.add(getBtnStopInstrumental());
		}
		return panel;
	}
	
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pattiSmith.start();
					bruceSpringsteen.start();
					guitar.start();
				}
			});
			btnStart.setBounds(19, 11, 91, 23);
		}
		return btnStart;
	}
	
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					synch.setStopP(true);
					synch.setStopB(true);
					synch.stop=true;
					pattiSmith.setStopIt(true);
					bruceSpringsteen.setStopIt(true);
					guitar.setStopIt(true);
				}
			});
			btnStop.setBounds(19, 44, 91, 23);
		}
		return btnStop;
	}
	private JButton getBtnStartPatty() {
		if (btnStartPatty == null) {
			btnStartPatty = new JButton("Start Patty");
			btnStartPatty.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pattiSmith.start();
				}
			});
			btnStartPatty.setBounds(19, 78, 91, 23);
		}
		return btnStartPatty;
	}
	private JButton getBtnStartBruce() {
		if (btnStartBruce == null) {
			btnStartBruce = new JButton("Start Bruce ");
			btnStartBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					synch.setSecondVoiceFlag(true);
					synch.setFirstVoiceFlag(true);
					synch.setStopP(true);
					synch.setStopB(false);
					bruceSpringsteen.start();
				}
			});
			btnStartBruce.setBounds(19, 146, 91, 23);
		}
		return btnStartBruce;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JButton getBtnStopPatty() {
		if (btnStopPatty == null) {
			btnStopPatty = new JButton("Stop Patty");
			btnStopPatty.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					synch.setStopP(true);
					pattiSmith.setStopIt(true);
				}
			});
			btnStopPatty.setBounds(19, 112, 91, 23);
		}
		return btnStopPatty;
	}
	private JButton getBtnStopBruce() {
		if (btnStopBruce == null) {
			btnStopBruce = new JButton("Stop Bruce");
			btnStopBruce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					synch.setStopB(true);
					bruceSpringsteen.setStopIt(true);
				}
			});
			btnStopBruce.setBounds(19, 183, 91, 23);
		}
		return btnStopBruce;
	}
	private JButton getBtnStartInstrumental() {
		if (btnStartInstrumental == null) {
			btnStartInstrumental = new JButton("Start instrumental");
			btnStartInstrumental.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					synch.setFirstVoiceFlag(false);
					synch.setSecondVoiceFlag(false);
					guitar.start();
				}
			});
			btnStartInstrumental.setBounds(0, 218, 120, 23);
		}
		return btnStartInstrumental;
	}
	private JButton getBtnStopInstrumental() {
		if (btnStopInstrumental == null) {
			btnStopInstrumental = new JButton("Stop instrumental");
			btnStopInstrumental.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					synch.stop = true;
					guitar.setStopIt(true);
				}
			});
			btnStopInstrumental.setBounds(0, 252, 120, 23);
		}
		return btnStopInstrumental;
	}
	
	class SynchronizerGUI {
	    
	    private boolean firstVoiceFlag;
	    private boolean secondVoiceFlag;
	    public boolean stop=false;
	    public boolean isFirstVoiceFlag() {
			return firstVoiceFlag;
		}
		public void setFirstVoiceFlag(boolean firstVoiceFlag) {
			this.firstVoiceFlag = firstVoiceFlag;
		}
		public boolean isSecondVoiceFlag() {
			return secondVoiceFlag;
		}
		public void setSecondVoiceFlag(boolean secondVoiceFlag) {
			this.secondVoiceFlag = secondVoiceFlag;
		}

		private boolean stopB=false;
		private boolean stopP=false;
	    
	    public boolean isStopB() {
	        return stopB;
	    }
	    public void setStopB(boolean stopB) {
	        this.stopB = stopB;
	    }
	    public boolean isStopP() {
	        return stopP;
	    }
	    public void setStopP(boolean stopP) {
	        this.stopP = stopP;
	    }
	    
	    public SynchronizerGUI(boolean firstVoiceFlag, boolean secondVoiceFlag, boolean stopP, boolean stopB) {
	        super();
	        this.firstVoiceFlag = firstVoiceFlag;
	        this.secondVoiceFlag = secondVoiceFlag;
	        this.stopP = stopP;
	        this.stopB = stopB;
	    }
	    
	    public synchronized void singFirstVoice(Song song, int delay, String name) {
	        while (!firstVoiceFlag) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        sing(song, delay, null, name);
	    }
	    
	    public synchronized void singSecondVoice(Song song, int delay, String name) {
	        while (!secondVoiceFlag) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        sing(song, delay, null, name);
	    }
	    
	    public synchronized void singGuitarSolo(String lyrics, int delay, String name) {
	        while (firstVoiceFlag || secondVoiceFlag) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        sing(null, delay, lyrics, name);
	    }
	    
	    private void sing(Song song, int delay, String lyrics, String name) {
	        if (firstVoiceFlag && !secondVoiceFlag) {
	        	 
	        		singVerseP(song.getStrophe1().getVerse1(), delay, name);	        	 
	        		singVerseP(song.getStrophe1().getVerse2(), delay, name);	        	 
	        		singVerseP(song.getStrophe1().getVerse3(), delay, name);	        	 
	        		singVerseP(song.getStrophe1().getVerse4(), delay, name);	        	 
	        		singVerseP(song.getStrophe1().getVerse5(), delay, name);
	        	
	        	secondVoiceFlag = true;
	        }else{ 
	        	if (firstVoiceFlag && secondVoiceFlag) {
	  
	        		singVerseP(song.getPreChorus().getVerse1(), delay, name);
	        		singVerseP(song.getPreChorus().getVerse2(), delay, name);	        		
	        		singVerseP(song.getPreChorus().getVerse3(), delay, name);	        		
	        		singVerseP(song.getPreChorus().getVerse4(), delay, name);	        		
	        		singVerseP(song.getPreChorus().getVerse5(), delay, name);	            	
	        		
	        		singVerseP(song.getChorus().getVerse1(), delay, name);	        		
	        		singVerseP(song.getChorus().getVerse2(), delay, name);	        		
	        		singVerseP(song.getChorus().getVerse3(), delay, name);	        		
	        		singVerseP(song.getChorus().getVerse4(), delay, name);	        		
	        		singVerseP(song.getChorus().getVerse5(), delay, name);		
	        			        			
	        		singVerseB(song.getPreChorus().getVerse1(), delay, name);
	        		singVerseB(song.getPreChorus().getVerse2(), delay, name);	        		
	        		singVerseB(song.getPreChorus().getVerse3(), delay, name);	        		
	        		singVerseB(song.getPreChorus().getVerse4(), delay, name);	        		
	        		singVerseB(song.getPreChorus().getVerse5(), delay, name);	            	
	        		
	        		singVerseB(song.getChorus().getVerse1(), delay, name);	        		
	        		singVerseB(song.getChorus().getVerse2(), delay, name);	        		
	        		singVerseB(song.getChorus().getVerse3(), delay, name);	        		
	        		singVerseB(song.getChorus().getVerse4(), delay, name);	        		
	        		singVerseB(song.getChorus().getVerse5(), delay, name);	        
	            	firstVoiceFlag = false;
	            	secondVoiceFlag = false;
	        	}else {
	        		if(secondVoiceFlag) {
	        			
	        			singVerseB(song.getStrophe2().getVerse1(), delay, name);	        			
	        			singVerseB(song.getStrophe2().getVerse2(), delay, name);	        			
	        			singVerseB(song.getStrophe2().getVerse3(), delay, name);	        			
	        			singVerseB(song.getStrophe2().getVerse4(), delay, name);	        			
	       				singVerseB(song.getStrophe2().getVerse5(), delay, name);   
	        			
	        			firstVoiceFlag = true;
	        		}else {
	        			if (!stop)
	        				textArea.setText(textArea.getText()+'\n'+name+":		"+lyrics);
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

	    private void singVerseP(String verse, int delay, String name) {
	    	if(!stopP)
	    		textArea.setText(textArea.getText()+'\n'+name+":		"+verse);
	    	else 
	    		return;
			try {
				wait(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    private void singVerseB(String verse, int delay, String name) {
	    	if(!stopB)
	    		textArea.setText(textArea.getText()+'\n'+name+":		"+verse);
	    	else 
	    		return;
			try {
				wait(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
}
	class Singer extends Thread {
	    
	    private String singerName;
	    private Voice voice;
	    private Performance performance;    
	    private boolean stopIt;
	    private SynchronizerGUI synch;
	    
	    public Singer(String singerName, Voice voice, Performance performance, boolean stopIt, SynchronizerGUI synch) {
	        super();
	        this.singerName = singerName;
	        this.voice = voice;
	        this.performance = performance;
	        this.stopIt = stopIt;
	        this.synch = synch;
	    }
	    
	    @Override
	    public void run() {
	        sing();
	    }
	    
	    private synchronized void sing() {
	        while (!stopIt) {
	            if (this.voice == Voice.FIRST) {
	                this.synch.singFirstVoice(performance.getSong(), performance.getDelay(), getSingerName());
	            } else {
	            	if (this.voice == Voice.SECOND)
	            		this.synch.singSecondVoice(performance.getSong(), performance.getDelay(), getSingerName());
	            	else
	            		this.synch.singGuitarSolo(performance.getLyrics(), performance.getDelay(), getSingerName());
	            }
	        }
	    }
	    
	    public String getSingerName() {
	        return singerName;
	    }
	    public void setSingerName(String singerName) {
	        this.singerName = singerName;
	    }
	    public Voice getVoice() {
	        return voice;
	    }
	    public void setVoice(Voice voice) {
	        this.voice = voice;
	    }
	    public Performance getPerformance() {
	        return performance;
	    }
	    public void setPerformance(Performance performance) {
	        this.performance = performance;
	    }
	    public boolean isStopIt() {
	        return stopIt;
	    }
	    public void setStopIt(boolean stopIt) {
	        this.stopIt = stopIt;
	    }

	    public SynchronizerGUI getSynch() {
	        return synch;
	    }

	    public void setSynch(SynchronizerGUI synch) {
	        this.synch = synch;
	    }

	}
}
