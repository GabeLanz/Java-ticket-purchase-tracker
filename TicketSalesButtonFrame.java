//Gabe Lanz

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketSalesButtonFrame extends JFrame {
	private JLabel instructions = new JLabel(
			"Enter the amount of tickets, up to 6, you would like to purchase and press submit.");
	private JTextField ticketNumber = new JTextField(5);
	private JButton submit = new JButton("Submit");
	private JLabel ticketsAvail = new JLabel("Tickets left available:");
	private JTextField ticketsAvailText = new JTextField("45");
	private JLabel soldOut = new JLabel();
	final private int TICKETLIMIT = 45;
	
	

	SalesDrawing drawing = new SalesDrawing();
	TicketSalesCalculator user = new TicketSalesCalculator();

	public TicketSalesButtonFrame() {
		JPanel panel = new JPanel();
		panel.add(instructions);
		panel.add(ticketNumber);
		panel.add(submit);

		panel.add(ticketsAvail);
		panel.add(ticketsAvailText);
		panel.add(drawing);
		drawing.setPreferredSize(new Dimension(200, 60));
		panel.add(soldOut);

		SubmitButtonListener sbl = new SubmitButtonListener();
		submit.addActionListener(sbl);
		add(panel);

	}
	

	class SubmitButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (ticketNumber.getText().matches("[a-zA-Z]+")) {
				JOptionPane.showMessageDialog(null, "Please enter a number only with a maximum value of 6.");
				ticketNumber.setText("");
			}
			
			Integer ticketNum = Integer.parseInt(ticketNumber.getText());
			if (user.getTotalTicketsSold() == TICKETLIMIT) {
				JOptionPane.showMessageDialog(null, "The event has been sold out. Thank you for your Patronage!");
				System.exit(0);
			}
			
			if (ticketNum >= 1 && ticketNum <= 6) {
				if (ticketNum > user.getTicketsAvailable() && user.getTicketsAvailable() < 6) {
					JOptionPane.showMessageDialog(null, "There are only " + user.getTicketsAvailable() + " tickets left for purchase, enter a number at or below " + user.getTicketsAvailable());
					ticketNumber.setText("");


				} else {
					user.setNum1(ticketNum);
					user.setTotalTicketsSold(user.getTotalTicketsSold() + ticketNum);
					ticketsAvailText.setText(user.getTicketsAvailable() + "");
					ticketNumber.setText("");
					drawing.adjustFill(user.determinePercentage());

					if (user.getTotalTicketsSold() == TICKETLIMIT) {
						JOptionPane.showMessageDialog(null, "The event has been sold out. Thank you for your Patronage!");
						System.exit(0);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Only 6 tickets maximum are allowed per sale.");
				ticketNumber.setText("");
				

			}

		}

	}
}