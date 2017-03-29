import java.util.Scanner;

public class MultiItemSale {
	private Sale[] saleArray;
	private DiscountSale[] discountSaleArray;
	private int saleArrayCount;
	private int discountSaleArrayCount;

	public Sale getSaleArray(int e) {
		return saleArray[e]; // getter for sale array
	}

	public DiscountSale getDiscountSaleArray(int i) {
		return discountSaleArray[i]; // getter for discount sale array
	}

	public void addSale(Sale o) {
		saleArray[saleArrayCount] = o; // adds a sale to the array
		saleArrayCount++;
	}

	public void addDiscountSale(DiscountSale u) {
		discountSaleArray[discountSaleArrayCount] = u; // adds a discounted sale
														// to the array
		discountSaleArrayCount++;
	}

	public MultiItemSale() {
		saleArrayCount = 0;
		discountSaleArrayCount = 0;
		saleArray = new Sale[99];
		discountSaleArray = new DiscountSale[99]; // set to 99 to hold up to
													// that many values (could
													// not get array count to
													// work properly)
	}

	/*
	 * private static Sale newSale() { Sale newSale = new Sale(); return
	 * newSale; }
	 */

	/*
	 * private static DiscountSale newDiscountSale() { DiscountSale
	 * newDiscountSale = new DiscountSale(); return newDiscountSale; }
	 */

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		MultiItemSale mis = new MultiItemSale();

		/*
		 * Sale newSale = new Sale(); double price1 = newSale.getPrice();
		 * DiscountSale newDiscountSale = new DiscountSale(); double discount1 =
		 * newDiscountSale.getDiscount();
		 */

		System.out.println("Enter the name:");
		String name = kb.next();
		int saleLoopCount = 0;
		int discountSaleLoopCount = 0;
		while (!name.equals("end")) {
			System.out.println("Enter the price:");
			double price = kb.nextDouble();
			System.out.println("Enter the discount:");
			double discount = kb.nextDouble();
			if (discount == 0) {
				Sale sale1 = new Sale();
				sale1.setPrice(price);
				sale1.setName(name);
				mis.addSale(sale1);
				saleLoopCount++;
				// System.out.println("SLC = " + saleLoopCount);
			} else {
				DiscountSale sale2 = new DiscountSale();
				sale2.setPrice(price);
				sale2.setDiscount(discount);
				sale2.setName(name);
				mis.addDiscountSale(sale2);
				discountSaleLoopCount++;
				// System.out.println("DSLC = " + discountSaleLoopCount);
			}
			System.out.println("Enter the name:");
			name = kb.next();
		}
		// System.out.println("FSLC = " + saleLoopCount);
		// System.out.println("FDSLC = " + discountSaleLoopCount);

		double saleTotal = 0;
		for (int a = 0; a < saleLoopCount; a++) {
			double salePrice = 0;
			salePrice += mis.getSaleArray(a).getPrice(); // gets price for the
															// sale array
			saleTotal += salePrice;
			System.out.println("Name: " + mis.getSaleArray(a).getName());
			System.out.printf("Price for " + mis.getSaleArray(a).getName() + ": $%.2f", mis.getSaleArray(a).getPrice());
			System.out.println(" ");//new line
		}
		// System.out.println("SaleTotal: " + saleTotal);

		double discountSaleTotal = 0;
		for (int a = 0; a < discountSaleLoopCount; a++) {
			// System.out.println("line 90: " + a);
			double discountSalePrice = 0;
			double discountSaleDiscount = 0;
			discountSalePrice += mis.getDiscountSaleArray(a).getPrice(); // gets
																			// price
																			// for
																			// the
																			// discount
																			// sale
																			// array
			discountSaleDiscount += (100 - mis.getDiscountSaleArray(a).getDiscount()); // calculates
																						// the
																						// discount
																						// based
																						// on
																						// the
																						// array's
																						// position
			System.out.println("Name: " + mis.getDiscountSaleArray(a).getName());
			System.out.printf("Price for " + mis.getDiscountSaleArray(a).getName() + ": $%.2f", mis.getDiscountSaleArray(a).getPrice());//new line
			System.out.println(" ");
			System.out.println("Discount: " + mis.getDiscountSaleArray(a).getDiscount() + "%");
			double discountSale = discountSalePrice * (discountSaleDiscount * .01);
			discountSaleTotal += discountSale;
		}
		// System.out.println("DiscountSaleTotal: " + discountSaleTotal);

		double finalTotal = saleTotal + discountSaleTotal;

		System.out.printf("Total:  $%.2f", finalTotal); // prints total in
														// format: $*.XX

		kb.close();
	}

}
