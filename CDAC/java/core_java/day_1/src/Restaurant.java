import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Restaurant {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<Food, Integer> priceChart = new HashMap<>(); 
		priceChart.put(Food.Dosa, 60);
		priceChart.put(Food.Samosa, 15);
		priceChart.put(Food.Idli, 30);

		HashMap<Food, Integer> orderList = new HashMap<>();

		boolean toExit = false;

		while(toExit == false) {
			printMenu(priceChart);

			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter the Quantity of '" + Food.Dosa + "' : ");
				orderList.put(Food.Dosa, scan.nextInt());
				break;
			case 2:
				System.out.println("Enter the Quantity of '" + Food.Samosa + "' : ");
				orderList.put(Food.Samosa, scan.nextInt());
				break;
			case 3:
				System.out.println("Enter the Quantity of '" + Food.Idli + "' : ");
				orderList.put(Food.Idli, scan.nextInt());
				break;
			case 0:
				displayBill(priceChart, orderList);
				orderList.clear();
				break;
			case 9:
				toExit = true;
				break;
			default:
				System.out.println("\nInvalid Choice !!!");
				System.out.println("Please select the correct choice....");
			}
		}

		scan.close();
	}

	static void printMenu(HashMap<Food, Integer> priceChart) {
		System.out.println("\nSelect option from the following menu : ");
		System.out.println("Press '1' : for Dosa\t\t Rs. " + priceChart.get(Food.Dosa) + "/-");
		System.out.println("Press '2' : for Samosa\t\t Rs. " + priceChart.get(Food.Samosa) + "/-");
		System.out.println("Press '3' : for Idli\t\t Rs. " + priceChart.get(Food.Idli) + "/-");
		System.out.println();
		System.out.println("Press '0' : To Generate Bill");
		System.out.println("Press '9' : Exit/Cancel Order");
	}

	static void displayBill(HashMap<Food, Integer> priceChart, HashMap<Food, Integer> orderList) {
		int billAmt = 0;
		System.out.println("\nSNo.\tFood\t\tQty\tPrice\t\tAmount");
		System.out.println("======================================================");

		int i=1;
		for(Map.Entry<Food, Integer> entry : orderList.entrySet()) {
			Food food = entry.getKey();
			int qty = entry.getValue();
			int price = priceChart.get(food);
			int amount = qty * price;

			billAmt += amount;
			System.out.println((i++) + "\t" + food + "\t\t" + qty + "\t" + price + "\t\t" + amount);
		}

		System.out.println("------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t" + billAmt);
	}
}

enum Food {
	Dosa, 
	Samosa, 
	Idli,
}