package web.product.model;

public class Product {
	private int id;// prod_id
	private String name; // prod_name
	private int price; // price
	private String description; // description

	public Product() {
		super();
	}

	public Product(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Product(int id, String name, int price, String description) {
		super();
		this.id = id; // prod_id
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}

}
