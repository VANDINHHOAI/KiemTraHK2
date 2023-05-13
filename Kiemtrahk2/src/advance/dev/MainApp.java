package advance.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MainApp {
	static final String FILE = "input.txt";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Person> p = new ArrayList<>();
		readFromFile(FILE, p);
		print(p);
		sort(p);
		print(p);
		maxSalary(p);	
	}

	private static void maxSalary(ArrayList<Person> p) {
		// TODO Auto-generated method stub
		System.out.println("Nguoi co luong cao nhat: " + p.get(p.size() - 1).getName());
	}

	private static void sort(ArrayList<Person> p) {
		// TODO Auto-generated method stub
		System.out.println("Sap xep luong tang dan:");
		Collections.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				if (o1.getSalary() > o2.getSalary()) {
					return 1;
				}else if (o1.getSalary() < o2.getSalary()) {
					return -1;
				}else {
					return 0;
				}				
			}
			
		});
	}

	private static void readFromFile(String file, ArrayList<Person> p) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fstream = new FileInputStream(FILE);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String line;

			while ((line = br.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ":");
				String name = tokenizer.nextToken();
				int age = Integer.parseInt(tokenizer.nextToken());
				String address = tokenizer.nextToken();
				double salary = Double.parseDouble(tokenizer.nextToken());
				Person person = new Person(name, age, address, salary);
				p.add(person);
			}
		} catch (Exception e) {
			
		}
	}

	private static void print(ArrayList<Person> p) {
		// TODO Auto-generated method stub
		System.out.println("========================");
		for (Person person : p) {
			System.out.println(person.toString());
		}	
	}

}
