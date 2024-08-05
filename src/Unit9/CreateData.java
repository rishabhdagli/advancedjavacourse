package Unit9;

import java.io.*;
/*
 * 		productId = 0;
		productName = "";
		productQuantity = 0;
 * */
public class CreateData {
	public static void main(String[] args) {
		createAndWriteProducts();
		createAndWriteEmployees();
		createAndWriteClients();
	}
	
	public static void createAndWriteProducts() {
		Product[] data = new Product[10];
		data[0] = new Product(1, "hiking boots", 10);
		data[1] = new Product(2, "water bottles", 50);
		data[2] = new Product(3, "backpacks", 30);
		data[3] = new Product(4, "walking stick", 40);
		data[4] = new Product(5, "trail mix", 100);
		data[5] = new Product(6, "tent", 100);
		data[6] = new Product(7, "thermos", 60);
		data[7] = new Product(8, "shoe laces", 100);
		data[8] = new Product(9, "hat", 60);
		data[9] = new Product(10, "wind breaker", 90);
		
		ObjectOutputStream out =  null;
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("productFile.txt")));
			for (int i = 0; i<data.length; i++) {
				out.writeObject(data[i]);
			}
			out.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void createAndWriteEmployees() {
		Employee[] data = new Employee[10];
		data[0] = new Employee("Software Engineer", "Mary Smith", new Date(5, 17, 2017));
		data[1] = new Employee("Senior Software Engineer", "Kamenko Roches", new Date(1, 2, 2000));
		data[2] = new Employee("Software Engineer", "Angele Weldrick", new Date(7, 8, 2013));
		data[3] = new Employee("Software Engineer", "Kirby Martello", new Date(8, 1, 2014));
		data[4] = new Employee("Engineering Manager", "Ezechiel Iacovacci", new Date(3, 4, 2005));
		data[5] = new Employee("QA Developer", "Barri Pargent", new Date(4, 4, 2010));
		data[6] = new Employee("QA Developer", "Alameda Gabites", new Date(10, 8, 2012));
		data[7] = new Employee("QA Manager", "Dorrie Golde", new Date(11, 12, 2014));
		data[8] = new Employee("Product Manager", "Loree Klempke", new Date(12, 01, 2016));
		data[9] = new Employee("Staff Software Engineer", "Genovera Spargo", new Date(02, 01, 2015));
		
		ObjectOutputStream out =  null;
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("employeeFile.txt")));
			for (int i = 0; i<data.length; i++) {
				out.writeObject(data[i]);
			}
			out.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void createAndWriteClients() {
		Client[] data = new Client[9];
		data[0] = new Client(1, "Superior Consulting", new Address("8 Gerald Avenue", "New York", "NY", "10001"));
		data[1] = new Client(2, "Advanced Software Solutions", new Address("40 Scofield Circle", "Trenton", "NJ", "08534"));
		data[2] = new Client(3, "Custom Software Solutions", new Address("02807 Commercial Junction", "Allentown", "PA", "18101"));
		data[3] = new Client(4, "GHI Corporation", new Address("679 Tennyson Junction", "Boston", "MA", "02101"));
		data[4] = new Client(5, "Hike It! Hiking Supplies", new Address("9 Division Street", "Houston", "TX", "77001"));
		data[5] = new Client(6, "Awesome Importers", new Address("50859 Hazelcrest Drive", "San Francisco", "CA", "94016"));
		data[6] = new Client(7, "XYZ Realty", new Address("57567 Merchant Terrace", "Madison", "WI", "53558"));
		data[7] = new Client(8, "AB Co", new Address("2686 Hanover Park", "Hanover", "MD", "210767"));
		data[8] = new Client(9, "Forever Furniture", new Address("30 Lyons Crossing", "Tulsa", "OK", "74008	"));

		ObjectOutputStream out =  null;
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("clientFile.txt")));
			for (int i = 0; i<data.length; i++) {
				out.writeObject(data[i]);
			}
			out.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
