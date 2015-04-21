package tuto;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau2 extends JPanel{

	Panneau2(){
		super();
		JLabel l = new JLabel("contenu 3");
		add(l,BorderLayout.NORTH);
		setBackground(Color.BLUE);
	}
}
