//Gabe Lanz
public class TicketSalesCalculator {
	private int num1;
	final private int TICKETLIMIT = 45;
	public int ticketsAvailable = 45;
	public int totalTicketsSold= 0;
	
	
	public TicketSalesCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	public TicketSalesCalculator(int num1) {
		super();
		this.num1 = num1;
	}

	public int getNum1() {
		
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getTicketsAvailable() {
		return ticketsAvailable - totalTicketsSold;
	}
	public void setTicketsAvailable(int ticketsAvailable) {
		this.ticketsAvailable =  num1;
	}
	public int getTotalTicketsSold() {
		return totalTicketsSold;
	}
	public void setTotalTicketsSold(int totalTicketsSold) {
		this.totalTicketsSold = totalTicketsSold;
	}
	public int getTICKETLIMIT() {
		return TICKETLIMIT;
	}
	
	public double determinePercentage() {
		return (double)this.totalTicketsSold/(double)TICKETLIMIT;
	}
}
