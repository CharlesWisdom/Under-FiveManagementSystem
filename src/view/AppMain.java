package view;

import javax.swing.JFrame;

public class AppMain {

	public static void main(String[] args) {

	      JFrame f=new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     // f.getContentPane().setLayout(new Absolute(Absolute.CENTER));
	      f.getContentPane().add(new UnderFiveMS_UI());
	      f.setSize(800, 380);
	      f.setVisible(true);
	}

}
