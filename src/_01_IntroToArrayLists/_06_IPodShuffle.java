package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList<Song> LS = new ArrayList<Song>();
	Random rand = new Random();
	int s;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		JFrame frame = new JFrame();
		JButton b = new JButton("Shuffle");

		frame.add(b);
		frame.setVisible(true);
		b.addActionListener(this);
		LS.add(new Song("demo.mp3"));
		LS.add(new Song("demo.mp3"));
		frame.pack();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(Song s:LS) {
			s.stop();
		}
		s = rand.nextInt(LS.size());
		LS.get(s).setDuration(10);
		LS.get(s).play();
			
	}
}