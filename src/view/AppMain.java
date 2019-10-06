package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class AppMain {

	public static void main(String[] args) {

	      JFrame f=new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
	      f.getContentPane().add(new UnderFiveMS_UI());
	      f.setSize(600, 280);
	      f.setVisible(true);
	}

}
