package application;

public class Tawjihi implements Comparable<Tawjihi> {
	private int seatNumber;
	private String branch;
	private double avg;

	// ___________________________________________________________________________________________//
	// No argument constructor
	public Tawjihi() {
		super();
	}

	// ___________________________________________________________________________________________//
	// Constructor with all parameters
	public Tawjihi(int seatNumber, String branch, double avg) {
		super();
		this.seatNumber = seatNumber;
		this.branch = branch;
		this.avg = avg;
	}

	// ___________________________________________________________________________________________//
	// Setters and getters
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getavg() {
		return avg;
	}

	public void setavg(double avg) {
		this.avg = avg;
	}
	// ___________________________________________________________________________________________//

	@Override
	public String toString() {
		return "" + seatNumber + " , " + branch + " , " + avg + "";
	}
	// ___________________________________________________________________________________________//

	@Override
	public int compareTo(Tawjihi o) {
		if (this.avg > o.getavg())
			return 1;
		return 0;
	}
	// ___________________________________________________________________________________________//

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		else if ((o instanceof Tawjihi))
			return this.seatNumber == ((Tawjihi) o).seatNumber;

		else
			return super.equals(o);
	}

}