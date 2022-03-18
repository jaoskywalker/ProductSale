package entities;

public class Sale {
	String productName;
	int productQuantity;
	double productPrice;
	double productTotal;
	
	public Sale() {
	}

	public Sale(String productName, int productQuantity, double productPrice, double productTotal) {
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productTotal = productTotal;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String d) {
		this.productName = d;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(double productTotal) {
		this.productTotal = productTotal;
	}
	
	
	
}
