package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	public static void main(String[] args) {
		new HangMan().Start();
	}

	int numW;
	String S;
	String numS;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	Utilities U = new Utilities();
	String SCurrent;
	int lives = 10;
	int response = 2;
	ArrayList<Character> Current_Word = new ArrayList<Character>();
	Stack<String> SS = new Stack<String>();
	Stack<Character> Word = new Stack<Character>();
	ArrayList<Integer> MoreOne = new ArrayList<Integer>();

	HangMan() {
		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setVisible(true);
	}

	void Start() {
		numS = JOptionPane.showInputDialog("How many words do you want to guess");
		numW = Integer.parseInt(numS);
		lives = 10;
		label2.setText(lives + "");
		for (int i = 0; i < numW; i++) {
			S = U.readRandomLineFromFile("dictionary.txt");
			while (SS.contains(S) == true) {
				S = U.readRandomLineFromFile("dictionary.txt");
			}
			SS.push(S);
		}
		SCurrent = SS.pop();
		for (int i = 0; i < SCurrent.length(); i++) {
			Current_Word.add('_');
			Current_Word.add(' ');
		}
		for (int i = 0; i < Current_Word.size(); i++) {
			label.setText(label.getText() + Current_Word.get(i));
		}
		frame.pack();

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (SCurrent.contains(arg0.getKeyChar() + "")) {
			for (int i = 0; i < SCurrent.length(); i++) {
				if (SCurrent.charAt(i) == arg0.getKeyChar()) {
					MoreOne.add(i * 2);
				}
			}
			for (int i = 0; i < MoreOne.size(); i++) {
				Current_Word.set(MoreOne.get(i), arg0.getKeyChar());
			}
			MoreOne.clear();
			label.setText("");
			for (int i = 0; i < Current_Word.size(); i++) {
				label.setText(label.getText() + Current_Word.get(i));
			}
		} else {
			lives--;
			System.out.println(arg0.getKeyChar());
			label2.setText(lives + "");
			if (lives <= 0) {
				JOptionPane.showMessageDialog(null, "the word was " + SCurrent);
				response = JOptionPane.showConfirmDialog(null, "Game Over Would you like to play again");
				System.out.println(response);
				if (response == 0) {
					MoreOne.clear();
					label.setText("");
					Current_Word.clear();
					Start();
				} else {
					System.exit(0);
				}

			}
		}
		if (!Current_Word.contains('_')) {
			MoreOne.clear();
			label.setText("");
			Current_Word.clear();
			SCurrent = SS.pop();
			lives = 10;
			label2.setText(lives + "");
			for (int i = 0; i < SCurrent.length(); i++) {
				Current_Word.add('_');
				Current_Word.add(' ');
			}
			for (int i = 0; i < Current_Word.size(); i++) {
				label.setText(label.getText() + Current_Word.get(i));
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
