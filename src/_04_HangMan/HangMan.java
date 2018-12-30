package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	public static void main(String[] args) {
		new HangMan().Start();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel(); 
	JLabel label = new JLabel();
	Utilities U = new Utilities();
	String p;
	Stack<String> SS = new Stack<String>();
	Stack<Character> Word = new Stack<Character>();
	void Start() {
		String numS= JOptionPane.showInputDialog("How many words do you want to guess");
		int numW = Integer.parseInt(numS);
		String S;
		for(int i = 0;i<numW;i++) {
			S = U.readRandomLineFromFile("dictionary.txt");
			while (SS.contains(S) == true) {
			S = U.readRandomLineFromFile("dictionary.txt");
			}
			SS.push(S);
		}
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		p = SS.pop();
		for(int i = 0;i<p.length();i++) {
			label.setText(label.getText()+" _");
		}
		frame.pack();
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(p.contains(arg0.getKeyChar()+"")) {
			for(int i = 0;i<p.length();i++) {
			
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
