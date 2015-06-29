package lambdaBasics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LambdasDemo {

	public static void main(String[] args){
		JButton someButton = new JButton("Click Me");
		
		//Pre-Java 8
		someButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("You performed event: " + event.getActionCommand());
			}
		});
		
		//Java 8 Lambdas:
		someButton.addActionListener(event -> System.out.println("You performed event: " + event.getActionCommand()));
	}
}
