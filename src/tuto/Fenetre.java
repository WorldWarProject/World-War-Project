package tuto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	JPanel panelBouton;
	JPanel panelF;
	Panneau p;
	Panneau1 p1;
	Panneau2 p2;
	
	Fenetre() {
		
		super("Menu");
		
		panelF = new JPanel();
		p = new Panneau(this);
		p1 = new Panneau1(this);
		p2 = new Panneau2();
		panelBouton = new JPanel();
		this.getContentPane().setLayout(new BorderLayout());

		this.getContentPane().add(p);
		pack();
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void changerMenu(int i) {
		this.getContentPane().removeAll();
		if(i == 1){

			panelF = p1;
		} else if (i == 0){
			panelF = p;
		} else {
			panelF = p2;
		}

		panelF.setVisible(true);
		this.getContentPane().add(panelF);
		this.repaint();
	}
	
	public void paint(Graphics g){
		
		this.paintComponents(g);
	}

	public static void main(String[] args) {
		new Fenetre();
	}

}
