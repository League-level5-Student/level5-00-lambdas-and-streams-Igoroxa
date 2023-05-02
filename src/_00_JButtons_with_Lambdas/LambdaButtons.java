package _00_JButtons_with_Lambdas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LambdaButtons implements ActionListener {
	private JFrame window = new JFrame();
	private JButton addNumbers = new JButton("ADD 2 Numbers");
	private JButton randNumber = new JButton("RANDOM NUMBER");
	private JButton tellAJoke = new JButton("TELL A JOKE");

	public LambdaButtons() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.add(addNumbers);
		window.add(randNumber);
		window.add(tellAJoke);
		addNumbers.addActionListener(this);
		randNumber.addActionListener(this);
		tellAJoke.addActionListener(this);

		// 1. Call the addActionListener methods for each button. Use lambdas
		// to define to functionality of the buttons.

		window.setVisible(true);
		window.pack();
	}

	public static void main(String[] args) {
		new LambdaButtons();

	}

	public static void twoAdd(AddTwo AT, int first, int second) {
		AT.Add(first, second);
	}

	public static void getR(GetRandom r, int min, int max) {
		r.get(min, max);
	}
	
	public static void tell(joke j, String joke) {
		j.jk(joke);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addNumbers) {
			int first = Integer.parseInt(JOptionPane.showInputDialog("First number:"));
			int second = Integer.parseInt(JOptionPane.showInputDialog("Second number:"));
			twoAdd((A, B) -> {
				return A + B;
			}, first, second);
		}
		if (e.getSource() == randNumber) {
			int min = Integer.parseInt(JOptionPane.showInputDialog("Minimum Number: "));
			int max = Integer.parseInt(JOptionPane.showInputDialog("Maximum number: "));
			getR((A, Z) -> {
				Random ran = new Random();
				int returnable = ran.nextInt(max);
				return returnable;
			}, min, max);

		}
		if (e.getSource() == tellAJoke) {
			String input = JOptionPane.showInputDialog("Enter in the joke to tell:");
			tell(fun -> {
				return "funny joke";
			}, input);
		}

	}

}
