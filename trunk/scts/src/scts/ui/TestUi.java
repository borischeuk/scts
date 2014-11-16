package scts.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestUi extends JPanel{

	private JLabel QCStatus;
	
	public TestUi() {
		QCStatus = new JLabel("Quay Crane Status: ");
		//QCStatus.setBounds(450, 100, QCStatus.getPreferredSize().width, QCStatus.getPreferredSize().height);
		
		JButton b1 = new JButton("Move");
		this.add(b1);
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25, 25,
                     size.width, size.height);
		b1.addActionListener(new timeListener());
		
		this.add(QCStatus);
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		QCStatus.setLocation(new Point(QCStatus.getLocation().x + 10, QCStatus.getLocation().y + 10));
		//QCStatus.setBounds(450 + 10, 100 + 10, QCStatus.getPreferredSize().width, QCStatus.getPreferredSize().height);
	}
	
	public class timeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();
		}
		
	}
	
}
