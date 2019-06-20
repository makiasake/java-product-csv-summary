package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the file path: ");
		File path = new File(sc.nextLine());
		
		try(BufferedReader br = new BufferedReader(new FileReader(path.getPath()))) {
			String line = br.readLine();
			List<Product> products = new ArrayList<Product>();
			
			while (line != null) {
				String[] productLine = line.split(",");
				products.add((new Product(productLine[0], Double.parseDouble(productLine[1]), Integer.parseInt(productLine[2]))));
				line = br.readLine();
			}
			
			boolean newFolder = new File(path.getParent() + "\\out").mkdir();
			if (newFolder) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\out\\summary.csv"))) {
					for (Product product: products) {
						bw.write(product.summarize());
						bw.newLine();
					}
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
