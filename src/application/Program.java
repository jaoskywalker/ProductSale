package application;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entities.Sale;

public class Program {

	public static void main(String[] args) {

		// Starting
		ArrayList<Sale> list = new ArrayList<>();
		boolean continueSale = true;

		// Handling File Date
		SimpleDateFormat formatoDt = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String formatoData = formatoDt.format(new Date());
		String path = "c:\\temp\\" + formatoData + ".csv";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please, follow the example:");
		System.out.println("[Product],[Value],[Quantity]");
		System.out.println();
		while (continueSale != false) {
			try {
				Sale sale = new Sale();
				System.out.println("Enter your sale: ");
				String saleLine = br.readLine();

				String[] splitedSale = saleLine.split(",");

				double aux_price = Double.parseDouble(splitedSale[1].trim());
				int quantity = Integer.parseInt(splitedSale[2].trim());

				sale.setProductName(splitedSale[0]);
				sale.setProductPrice(aux_price);
				sale.setProductQuantity(quantity);
				sale.setProductTotal(sale.getProductPrice() * sale.getProductQuantity());
				list.add(sale);
				System.out.print("Press any key to continue or 'n' to stop");
				char c = 0;
				c = br.readLine().charAt(0);
				if (c == 'n') {
					continueSale = false;
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: Please, insert three datas");
			} catch (IndexOutOfBoundsException e) {

			} catch (NumberFormatException e) {
				System.out.println("Please follow the example data: 'Product, value, quantity'");
			}
		}

		// Printing sales
		for (Sale s : list) {
			System.out.println("Product Name: " + s.getProductName() + ", R$" + s.getProductPrice() + ""
					+ ", quantity: " + s.getProductQuantity() + ", Total: R$" + s.getProductTotal());
		}

		// Writing sales
		try (FileWriter writer = new FileWriter(path)) {
			writer.write("Product;Price;Quantity;TotalPrice" + System.lineSeparator());
			for (Sale s : list) {
				writer.write(s.getProductName() + ";" + s.getProductPrice() + ";" + s.getProductQuantity() + ";"
						+ s.getProductTotal());
				writer.write(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
