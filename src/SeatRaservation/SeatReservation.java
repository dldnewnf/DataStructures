package SeatRaservation;
import java.util.Scanner;
public class SeatReservation {
	public static void main(String[] args) {
		ReservationSystem RS = new ReservationSystem();
		RS.seatSet();
		RS.reserve();
		RS.reserve();
		RS.reserve();
		RS.print();

	}

}
class ReservationSystem {
	private static class Node{
		public String name;
		public String seatNum;
		public Node next;
		
		public Node(String name, String seatNum) {//생성자
			this.name = name;
			this.seatNum = seatNum;
			next = null;
		}
		public Node() {
			next = null;
		}
	}

	private Node head;
	private int ROW=5;  //행의수
	private int COLUMN=4;//열의수
	private String[][] Seat = new String[ROW][COLUMN];

	public String[][] seatSet() {
		String seatname;
		char ascii = 65; //아스키코드 'A'
		for(int i = 0; i<ROW; i++) {
			for(int j = 0; j<COLUMN; j++) {
				seatname = String.valueOf(ascii);
				Seat[i][j] = seatname;
				ascii++;
			}
			ascii = 65;
		}
		return Seat;
	}
	
	public void customerList(String name, String seatNum) { //고객정보
		Node newNode = new Node(name, seatNum);
		Node prev = null;
		Node curr = head;
	
		if(isEmpty()) {
			System.out.println(isEmpty());
			System.out.println(2);
			head = newNode;
		}
		else{
			while(curr != null) {
				System.out.println(isEmpty());
				if(curr.name.compareTo(newNode.name)>0) {
					prev.next = newNode;
					newNode.next = curr.next;
				}
				else {
					prev = curr;
					curr = curr.next;
				}
			}
			
		}
		
		
		
	}
	public void reserve() {
		char ascii = 65;
		int index=1;
		System.out.println("Seat Layout");
		System.out.println("------------");
		for(int i = 0; i<Seat.length; i++) {
			System.out.print(index+" ");
			for(int j = 0; j<Seat[i].length; j++) {
				System.out.print(Seat[i][j]+" ");
				ascii++;
			}
			index++;
			ascii = 65;
			System.out.println();
		}
		System.out.print("> Enter a customer name and desired seat number: ");
		Scanner reserve= new Scanner(System.in);
		String name = reserve.next();
		String seatNum = reserve.next();
		customerList(name , seatNum);
		
		
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void print() {
		char ascii = 65;
		int index=1;
		Node scan = head;
		System.out.println("Seat Layout");
		System.out.println("------------");
		for(int i = 0; i<Seat.length; i++) {
			System.out.print(index+" ");
			for(int j = 0; j<Seat[i].length; j++) {
				System.out.print(Seat[i][j]+" ");
				ascii++;
			}
			index++;
			ascii = 65;
			System.out.println();
		}
		System.out.println("\n\nReservation information");
		System.out.println("------------------------");
		while(scan != null) {
			System.out.println(scan.name + "	"+scan.seatNum);
			scan=scan.next;
		}
		
	}

}
