//Gabe Lanz
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SalesDrawing extends JComponent {
	private int x = 10;
	private int y = 10;
	private int totalLength = 170;
	private int height = 30;
	private int fillForFirstSection = 170;
	
	
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, totalLength, height);
		
		g.setColor(Color.blue);
		g.fillRect(x, y, fillForFirstSection, height);
		
	}



	public void adjustFill(double fillPercentage) {
		// TODO Auto-generated method stub
		double fill = totalLength  * fillPercentage;
		fillForFirstSection = (int)fill;
		repaint();
		
		
	}
	

}
