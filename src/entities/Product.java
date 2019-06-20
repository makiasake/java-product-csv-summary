package entities;

public class Product {
	
	private String name;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return name + ", " + price + ", " + quantity;
	}
	
	private double total() {
		return price * quantity;
	}
	
	public String summarize() {
		return name + ", $: " + String.format("%.2f", total());
	}
}
