package application;

public class LinkedList<E extends Comparable<E>> {
	private Node<E> head;

	// ________________________________________________________________________________________________//

	public void insertSorted(E data) {
		Node<E> newNode = new Node<>(data);
		if (head == null)
			head = newNode;

		else {
			Node<E> previous = null;
			Node<E> current = head;

			while (current != null && current.getData().compareTo(data) == 1) {
				previous = current;
				current = current.getNext();
			}
			if (previous == null) {
				head = newNode;
				newNode.setNext(current);
			} else {
				previous.setNext(newNode);
				newNode.setNext(current);
			}
		}
	}
	// ________________________________________________________________________________________________//

	public boolean search(int seatNumber) {
		if (head == null) { // if empty list
			System.out.println("Empty List");
			return false;
		} else { // if not empty list
			Node<E> current = head;

			while (current != null) {
				if (((Tawjihi) current.getData()).getSeatNumber() == seatNumber) {// if it's founded
					return true;
				}
				current = current.getNext();
			}

			return false; // if it isn't founded
		}
	}
	// ________________________________________________________________________________________________//

	public void deleteSeatNumber(int seatNumber) {
		if (search(seatNumber) == false) { // if it isn't existed
//			System.out.println("seatNumber " + seatNumber + " is not found");
			return;
		}

		else { // if it's existed
			if (((Tawjihi) head.getData()).getSeatNumber() == seatNumber) { // if it's in the first Node
				head = head.getNext();
				return;
			}
			// if it's not in the first Node
			Node<E> previous = null;
			Node<E> current = head;

			while (current != null) {
				if (((Tawjihi) current.getData()).getSeatNumber() == seatNumber) {
					previous.setNext(current.getNext()); // delete it
					break;
				} else {
					previous = current;
					current = current.getNext();
				}
			}
		}
	}
	// ________________________________________________________________________________________________//

	public void traverse() { // print all the nodes
		Node<E> current = head;
		System.out.print("head");

		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
		System.out.println("-->Null");
	}
	// ________________________________________________________________________________________________//

	public int size() { // To find the number of nodes
		int count = 0;
		Node<E> current = head;

		while (current != null) {
			current = current.getNext();
			count++;
		}
		return count;
	}
	// ________________________________________________________________________________________________//

	@Override
	public String toString() {
		String s = "Head";

		Node<E> current = head;
		while (current != null) {
			s += current.toString();
			current = current.getNext();
		}
		return s + "-->Null";
	}
	// ________________________________________________________________________________________________//

	public double Mean() {
		Node<E> current = head;
		double sum = 0;
		int count = 0;
		double mean = 0;

		if (head == null) {
			System.out.println("The Mean is " + sum);
		}

		else {
			while (current != null) {
				sum += (((Tawjihi) current.getData()).getavg());
				count++;
				current = current.getNext();
			}
			mean = sum / count;
		}
		return mean;
	}
	// ________________________________________________________________________________________________//

	public String Percentage(double avg) {
		if (head == null) { // if Empty list
			System.out.println("Empty List");
			return "";
		}

		else { // if not empty list
			int count = 0; // number of students whom grade above or equal
			int total = 0; // number of all students
			Node<E> current = head;

			while (current != null) {
				if ((((Tawjihi) current.getData()).getavg()) >= avg) // if they have larger or equal avg
					count++; // increment the number of students whom grade above or equal

				total++; // increment the number of all students
				current = current.getNext();
			}

			double percentage = (((double) count / total) * 100);
			return count + "," + percentage + "%";
		}
	}

	// ________________________________________________________________________________________________//
	public double Mode(LinkedList<E> list) {
		if (head == null)
			return 0;

		if (head.getNext() == null)
			return (((Tawjihi) head.getData()).getavg());

		int count = 1; // number of repetitions
		double mode = 0; // the most repeated avg
		int max = 0; // the maximum number of count reached

		Node<E> previous = head;
		Node<E> current = previous.getNext();

		while (current != null) {
			if ((((Tawjihi) previous.getData()).getavg()) == (((Tawjihi) current.getData()).getavg())) {
				count++;
			} else {
				if (count > max) {
					mode = ((Tawjihi) previous.getData()).getavg();
					max = count;
				}
				count = 1;
			}

			previous = current;
			current = current.getNext();
		}

		return mode;
	}
	// ________________________________________________________________________________________________//

	public String topTen(LinkedList<E> list) {
		String r = "";
		Node<E> previous = null;
		Node<E> current = head;
		double[] s = new double[list.size()];

		for (int k = 0; k < 10; k++) { // to store top 10 averages in an array
			s[k] = (((Tawjihi) current.getData()).getavg());
			r += current;
			previous = current;
			current = current.getNext();
		}

		while (((Tawjihi) previous.getData()).getavg() == ((Tawjihi) current.getData()).getavg()) {
			r += current;
			current = current.getNext();
			continue;
		}
		return "head" + r + "-->null";
	}
}