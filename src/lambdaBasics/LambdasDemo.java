package lambdaBasics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LambdasDemo {

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 80, 80);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton someButton = new JButton("Click Me");
		panel.add(someButton);
		
		//Pre-Java 8
		someButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("You performed event: " + event.getActionCommand());
			}
		});
		
		//Java 8 Lambdas:
//		someButton.addActionListener(event -> System.out.println("You performed event: " + event.getActionCommand()));
		
		frame.setVisible(true);
	}
}
