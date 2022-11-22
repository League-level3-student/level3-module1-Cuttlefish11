package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton AN = new JButton();
	JButton VN = new JButton();    
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	ArrayList<String> names = new ArrayList<String>();
	_02_GuestBook(){
		frame.setVisible(true);
		panel.add(AN);
		panel.add(VN);
		frame.add(panel);
		frame.pack();
		label1.setText("Add Name");
		label2.setText("View Name");
		AN.add(label1);
		VN.add(label2);
		AN.addActionListener(this);
		VN.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==AN) {
			String name = JOptionPane.showInputDialog("Enter a name");
			names.add(name);
		}
		if(e.getSource() ==VN) {
			for (int i = 0; i < names.size(); i++) {
				JOptionPane.showMessageDialog(null, "Guest #"+(i+1)+" "+names.get(i));
			}
		}
	}
	
	
	/* 
     * 
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */

}
