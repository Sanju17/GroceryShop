import java.util.Scanner;

public class GroceryShopTest {

	final int N = 4;

	Scanner scanner = new Scanner(System.in);
	String[] itemNameArr = new String[N];
	int[] itemIdArr = new int[N];
	int[] qtyInStockArr = new int[N];
	double[] factoryPriceArr = new double[N];
	double[] shopPriceArr = new double[N];

	public static void main(String[] args) {
		GroceryShopTest groceryShopTest = new GroceryShopTest();
		groceryShopTest.main();
	}

	private void main() {
		displayMenu();
		while (true) {
			System.out.println("Enter the choice from menu: (1 - 7)");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addItems();
				break;
			case 2:
				addItemsDiscountedPrice();
				break;
			case 3:
				displayAllItems();
				break;
			case 4:
				sellItems();
				break;
			case 5:
				showPriceWithLowestItem();
				break;
			case 6:
				displaySortedItem();
				break;
			case 7:
				exit();
				break;
			default:
				System.out.println("Invalid choice. Please choose option from 1 to 7.\n");
				break;
			}
		}
	}

	// 1. Read, Validate and Store all Items
	private void addItems() {
		System.out.println("--------ADD ITEMS---------");
		for (int i = 0; i < N; i++) {

			// Enter Item Name
			System.out.print("Enter Item Name: ");
			itemNameArr[i] = scanner.next();

			// Enter Item ID
			int id;
			do {
				System.out.print("Enter Item ID: ");
				id = scanner.nextInt();
				if (id < 1 || id > 334) {
					System.out.println("Item ID should be in range of 1 - 333");
				}
			} while (id < 1 || id > 333);
			itemIdArr[i] = id;

			// Enter Item Quantity in Stock
			System.out.print("Enter the item quantity (In Stock): ");
			qtyInStockArr[i] = scanner.nextInt();

			// Enter Item Factory Price
			double factoryPrice;
			do {
				System.out.print("Enter Factory Price: ");
				factoryPrice = scanner.nextInt();
				if (factoryPrice < 1 || factoryPrice > 1000) {
					System.out.println("Item price should be in range of 1 - 1000");
				}
			} while (factoryPrice < 1 || factoryPrice > 1000);
			factoryPriceArr[i] = factoryPrice;

			System.out.println("\n");
		}
	}

	// 2. Calculate and store shop price for all items
	private void addItemsDiscountedPrice() {
		System.out.println("--------ENTER ITEMS DISCOUNTED PERCENTAGE---------");
		if (itemIdArr.length > 0) {
			System.out.println("Enter the discount percentage for following item: ");
			for (int i = 0; i < itemIdArr.length; i++) {
				System.out.print(itemIdArr[i] + " - " + itemNameArr[i] + ": ");
				double discountPercent = scanner.nextDouble();
				double discountPrice = factoryPriceArr[i]
						- Math.round((factoryPriceArr[i] * discountPercent / 100) * 100 / 100);
				shopPriceArr[i] = discountPrice;
			}
		} else {
			System.out.println("Please add the Items first. To Add the item, Select 1 from menu.");
		}
	}

	// 3. Display all items
	private void displayAllItems() {
		System.out.println("--------STOCK DETAILS---------");
		if (itemNameArr[0] != null) {
			for (int i = 0; i < N; i++) {
				System.out.println("#" + (i + 1));
				System.out.println("Item ID:\t\t" + itemIdArr[i]);
				System.out.println("Item Name:\t\t" + itemNameArr[i]);
				System.out.println("Quantity(In Stock):\t" + qtyInStockArr[i]);
				System.out.println("Factory Price:\t\t" + "$" + factoryPriceArr[i]);
				System.out.println("Shop Price:\t\t" + "$" + shopPriceArr[i] + "\n");
			}
		} else {
			System.out.println("No items added in stock.\n");
		}
	}

	// 4. Sell an item
	private void sellItems() {
		System.out.println("-----SELL AN ITEM-----");
		System.out.println("Enter the Item Id to be sell");
		int sellingItemId = scanner.nextInt();
		int selectedItemIndex = -1;
		for (int i = 0; i < itemIdArr.length; i++) {
			if (itemIdArr[i] == sellingItemId) {
				selectedItemIndex = i;
				break;
			}
		}
		if (selectedItemIndex == -1) {
			System.out.println("Item not in stock!!!");
		} else {
			if (qtyInStockArr[selectedItemIndex] > 0) {
				System.out.println("Item \"" + itemNameArr[selectedItemIndex] + "\" Sold!!!");
				System.out.println("PRICE: $" + shopPriceArr[selectedItemIndex]);
				qtyInStockArr[selectedItemIndex] -= 1;
			} else {
				System.out.println("Item not in stock!!!");
			}
		}
	}

	// 5. Display all items with the lowest factory price
	private void showPriceWithLowestItem() {
		double lowestPrice = Integer.MAX_VALUE;
		for (int i = 0; i < factoryPriceArr.length; i++) {
			if (factoryPriceArr[i] < lowestPrice) {
				lowestPrice = factoryPriceArr[i];
			}
		}
		int count = 0;
		for (int i = 0; i < itemIdArr.length; i++) {
			if (factoryPriceArr[i] == lowestPrice) {
				System.out.println("#" + (count + 1));
				System.out.println("Item ID:\t\t" + itemIdArr[i]);
				System.out.println("Item Name:\t\t" + itemNameArr[i]);
				System.out.println("Quantity(In Stock):\t" + qtyInStockArr[i]);
				System.out.println("Factory Price:\t\t" + "$" + factoryPriceArr[i]);
				System.out.println("Shop Price:\t\t" + "$" + shopPriceArr[i] + "\n");
				count++;
			}
		}
	}

	// 6. Sort and display sorted items
	private void displaySortedItem() {
		int[] array = sort();
		for(int i = 0; i < array.length; i++) {
			System.out.println("#" + (i + 1));
			System.out.println("Item ID:\t\t" + itemIdArr[array[i]]);
			System.out.println("Item Name:\t\t" + itemNameArr[array[i]]);
			System.out.println("Quantity(In Stock):\t" + qtyInStockArr[array[i]]);
			System.out.println("Factory Price:\t\t" + "$" + factoryPriceArr[array[i]]);
			System.out.println("Shop Price:\t\t" + "$" + shopPriceArr[array[i]] + "\n");
		}
	}

	private int[] sort() {
		String[] array = new String[N];
		int[] sortedArrayIndex = new int[N];
		if(itemNameArr.length > 0) {
			for(int i = 0; i < itemNameArr.length; i++) {
				array[i] = itemNameArr[i];
				sortedArrayIndex[i] = i;
			}
		}else {
			return null;
		}
		
		// implementation of sorting algothim
		return sortedArrayIndex;
	}

	// 7. Exit from the application
	private static void exit() {
		System.out.println("BYE BYE!!! SEE YOU AGAIN!!!");
		System.exit(0);
	}

	private void displayMenu() {
		System.out.println("+------------------------------------+");
		System.out.println("|      WELCOME TO MY GROCERY TEST    |");
		System.out.println("+------------------------------------+\n");
		System.out.println("--------------------MENU OPTIONS--------------------");
		System.out.println("1. Read, Validate and Store all Items");
		System.out.println("2. Calculate and store shop price for all items");
		System.out.println("3. Display all items");
		System.out.println("4. Sell an item");
		System.out.println("5. Display all items with the lowest factory price");
		System.out.println("6. Sort and display sorted items");
		System.out.println("7. Exit from the application");
		System.out.println("----------------------------------------------------");
	}

}
