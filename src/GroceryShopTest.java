import java.util.Scanner;

public class GroceryShopTest {

	final int N = 2;

	Scanner scanner = new Scanner(System.in);
	// GroceryShop[] groceryShopList = new GroceryShop[N];
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
				break;
			case 3:
				displayAllItems();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
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

	// 1. Read, Validate and Store all Items
	private void addItems() {
		System.out.println("--------ADD ITEMS---------");
		for (int i = 0; i < N; i++) {
			// GroceryShop groceryShop = new GroceryShop();

			// Enter Item Name
			System.out.print("Enter Item Name: ");
			// groceryShop.setItemName(scanner.next());
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
			// groceryShop.setItemId(id);
			itemIdArr[i] = id;

			// Enter Item Quantity in Stock
			System.out.print("Enter the item quantity (In Stock): ");
			// groceryShop.setQuantityInStock(scanner.nextInt());
			qtyInStockArr[i] = scanner.nextInt();

			// Enter Item Factory Price
			double factoryPrice;
			do {
				System.out.print("Enter Factory Price: ");
				factoryPrice = scanner.nextInt();
				if(factoryPrice < 1 || factoryPrice > 1000) {
					System.out.println("Item price should be in range of 1 - 1000");
				}	
			} while (factoryPrice < 1 || factoryPrice > 1000);
			// groceryShop.setFactoryPrice(factoryPrice);
			factoryPriceArr[i] = factoryPrice;
			// Add item to the Grocery list
			// groceryShopList[i] = groceryShop;
			System.out.println("\n");
		}
	}

	// 7. Exit from the application
	private static void exit() {
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
