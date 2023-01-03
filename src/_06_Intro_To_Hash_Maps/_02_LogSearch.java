package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */
	HashMap<Integer, String> intring = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b3 = new JButton();
	JButton b2 = new JButton();
	JButton b4 = new JButton();

	_02_LogSearch() {
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		frame.add(panel);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b1.setText("add element");
		b2.setText("search list");
		b3.setText("present list");
		b4.setText("delete element");
		frame.setVisible(true);
		frame.pack();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String IDK = JOptionPane.showInputDialog("Enter an ID number.");
			int ID = Integer.parseInt(IDK);
			String name = JOptionPane.showInputDialog("Enter the name of the person who has said ID number.");
			intring.put(ID, name);
		}
		if (e.getSource() == b2) {
			String search = JOptionPane.showInputDialog("Enter an ID number. This will tell you who has that number.");
			int search2 = Integer.parseInt(search);
			if (intring.get(search2) != null) {
				JOptionPane.showMessageDialog(null, "Their name is " + intring.get(search2));
				//JOptionPane.showMessageDialog(null, "That ID number is not in the list");
			} else {
				JOptionPane.showMessageDialog(null, "That ID number is not in the list");
				//JOptionPane.showMessageDialog(null, "Their name is " + intring.get(search));
			}
		}
		if (e.getSource() == b3) {

			for (int s : intring.keySet()) {
				JOptionPane.showInternalMessageDialog(null, "\nID: " + s + " Name: " + intring.get(s));
				System.out.println("\nID: " + s + "   Name: " + intring.get(s));
			}

		}
		if(e.getSource()==b4) {
			String IDK = JOptionPane.showInputDialog("Enter an ID number.");
			int ID = Integer.parseInt(IDK);
			intring.remove(ID);
		}
	}

}
