package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import music.Performance;
import music.Singer;
import music.Song;
import music.Synchronizer;
import music.Voice;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class songGUI extends JFrame {

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
    private Song song;
    
    private void initializeSingingInThreads() {
    	String lyrics3 = "Instrumental";
        boolean stopIt = false;
        Synchronizer synch = new Synchronizer(true, false);
        song = new Song();
        Performance firstVoicePerformance = new Performance(song, 1500);
        Performance secondVoicePerformance = new Performance(song, 1500);
        Performance guitarPerformance = new Performance(lyrics3, 1500);
        
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
        guitar = new Singer("Guitar", Voice.BACKGROUND, guitarPerformance, stopIt, synch);
    }
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
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.setBounds(19, 44, 91, 23);
		}
		return btnStop;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					initializeSingingInThreads();
					pattiSmith.start();
					bruceSpringsteen.start();
					guitar.start();
					
				}
			});
			btnStart.setBounds(19, 11, 91, 23);
		}
		return btnStart;
	}
	private JButton getBtnStartPatty() {
		if (btnStartPatty == null) {
			btnStartPatty = new JButton("Start Patty");
			btnStartPatty.setBounds(19, 78, 91, 23);
		}
		return btnStartPatty;
	}
	private JButton getBtnStartBruce() {
		if (btnStartBruce == null) {
			btnStartBruce = new JButton("Start Bruce ");
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
			btnStopPatty.setBounds(19, 112, 91, 23);
		}
		return btnStopPatty;
	}
	private JButton getBtnStopBruce() {
		if (btnStopBruce == null) {
			btnStopBruce = new JButton("Stop Bruce");
			btnStopBruce.setBounds(19, 183, 91, 23);
		}
		return btnStopBruce;
	}
	private JButton getBtnStartInstrumental() {
		if (btnStartInstrumental == null) {
			btnStartInstrumental = new JButton("Start instrumental");
			btnStartInstrumental.setBounds(0, 218, 120, 23);
		}
		return btnStartInstrumental;
	}
	private JButton getBtnStopInstrumental() {
		if (btnStopInstrumental == null) {
			btnStopInstrumental = new JButton("Stop instrumental");
			btnStopInstrumental.setBounds(0, 252, 120, 23);
		}
		return btnStopInstrumental;
	}	
}
