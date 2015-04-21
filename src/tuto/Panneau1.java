package tuto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau1 extends JPanel {

	Fenetre f;
	
	Panneau1(Fenetre fenetre) {
		super();
		
		f = fenetre;
		
		JLabel l = new JLabel("contenu 2");
		Bouton bouton = new Bouton();
		setBackground(Color.red);
		super.setLayout(new BorderLayout());
		super.add(l, BorderLayout.NORTH);
		JButton retour = new JButton("Retour");
		retour.addActionListener(bouton);
		super.add(retour, BorderLayout.SOUTH);
	}

	public class Bouton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand() == "Retour") {

				f.changerMenu(0);

			}

		}
	}

}
