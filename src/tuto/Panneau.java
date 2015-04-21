package tuto;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tuto.Fenetre;

public class Panneau extends JPanel{
	Fenetre f;
	Panneau1 p1;
	//CardLayout c = new CardLayout();
	Panneau(Fenetre f){
		super();
		this.f = f;
		
		
		Bouton b = new Bouton();
		JLabel label = new JLabel("Contenu 1");
		add(label, new BorderLayout().NORTH);
		
		setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(0, 100)));

		JButton bouton1 = new JButton("bouton 1");
		add(bouton1);
		bouton1.setAlignmentX(this.CENTER_ALIGNMENT);
		bouton1.addActionListener(b);
		add(Box.createRigidArea(new Dimension(0, 50)));

		JButton bouton2 = new JButton("bouton 2");
		add(bouton2);
		bouton2.setAlignmentX(CENTER_ALIGNMENT);
		bouton2.addActionListener(b);
		add(Box.createRigidArea(new Dimension(0, 50)));

		JButton bouton3 = new JButton("bouton 3");
		add(bouton3);
		bouton2.setAlignmentX(CENTER_ALIGNMENT);
		bouton2.addActionListener(b);
	}
	
	public class Bouton implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "bouton 1") {
			
			f.changerMenu(1);

				
			}
			if (e.getActionCommand() == "bouton 2") {

				f.changerMenu(2);
			}

		}
	}

}
