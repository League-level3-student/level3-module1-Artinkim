package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	public static void main(String[] args) {
		new _02_TextUndoRedo().d();
	}

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> U = new Stack<Character>();

	void d() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 8) {
			U.push(label.getText().charAt(label.getText().length() - 1));
			label.setText(label.getText().substring(0, label.getText().length() - 1));
		} else if (e.getKeyCode() == 10) {
			label.setText(label.getText() + U.pop());
		} else if (e.getKeyCode() != 8 && e.getKeyCode() != 10){
			label.setText(label.getText() + e.getKeyChar());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
