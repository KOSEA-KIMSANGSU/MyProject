package chapter19;

// update : 2017-08-31

// update : 2017-09-01
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicExample2 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("혈액형 분포 그래프 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(500, 350));
		Container contentPane = frame.getContentPane();
		
		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		JTextField text1 = new JTextField(3);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(3);
		JTextField text4 = new JTextField(3);
		
		JButton button = new JButton("그래프 그리기");
		
		controlPanel.add(new JLabel("O형"));
		controlPanel.add(text1);
		controlPanel.add(new JLabel("A형"));
		controlPanel.add(text2);		
		controlPanel.add(new JLabel("B형"));
		controlPanel.add(text3);
		controlPanel.add(new JLabel("AB형"));
		controlPanel.add(text4);		
		
		controlPanel.add(button);
		
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.addActionListener(new DrawActionListener(text1, text2, text3, text4, drawingPanel));
		frame.pack();
		frame.setVisible(true);
	}
}


class DrawingPanel extends JPanel {
	
	int num1, num2, num3, num4;
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());

		if( (num1 < 0 ) || (num2 < 0 ) || (num3 < 0 ) || (num4 < 0) )
			return;
		
		int total = num1 + num2 + num3 + num4;
		
		if(total == 0)
			return;
	
		int arc1 = (int) 360.0 * num1 / total;
		int arc2 = (int) 360.0 * num2 / total;
		int arc3 = (int) 360.0 * num3 / total;
		
		g.setColor(Color.YELLOW);
		g.fillArc(50, 20, 200, 200, 0, arc1);
		
		g.setColor(Color.RED);
		g.fillArc(50, 20, 200, 200, arc1, arc2);
		
		g.setColor(Color.BLUE);
		g.fillArc(50, 20, 200, 200, arc1 + arc2, arc3);
		
		g.setColor(Color.GREEN);
		g.fillArc(50, 20, 200, 200, arc1 + arc2 + arc3, 360-(arc1 + arc2 + arc3));
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(" ", Font.PLAIN, 12));
		g.drawString(" O형:노랑 ", 300, 150);
		g.drawString(" A형:빨강 ", 300, 170);
		g.drawString(" B형:파랑 ", 300, 190);
		g.drawString(" AB형:초록 ", 300, 210);
		}
	
	void setNumbers(int num1, int num2, int num3, int num4) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
	}
}

class DrawActionListener implements ActionListener {
	JTextField text1, text2, text3, text4;
	DrawingPanel drawingPanel;
	
	public DrawActionListener(JTextField text1, JTextField text2, JTextField text3, JTextField text4,DrawingPanel drawingPanel) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.drawingPanel = drawingPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			int num1 = Integer.parseInt(text1.getText());
			int num2 = Integer.parseInt(text2.getText());
			int num3 = Integer.parseInt(text3.getText());
			int num4 = Integer.parseInt(text4.getText());
			drawingPanel.setNumbers(num1, num2, num3, num4);
			drawingPanel.repaint();
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(drawingPanel, "잘못된 숫자 포맷입니다.", 
					"에러메시지", JOptionPane.ERROR_MESSAGE);
		}	
	}
}



