
//Okay So, the objectives of the main
//First, it should allow user to enter the thing they want. But who should be the user?
//If the clerk is the user, or the customer is the user, only one user is required. 
//Multiple Stores?                                                                              Yes 
//Multiple Orders?                                                                              Yes
//Multiple Customers?                                                                           No, Maybe in future
//Multiple Payment Options?                                                                     Yes
//ArrayList of Orders                                                                           Yes
//ArrayList of Stores                                                                           Yes, doing right now
//ArrayList of Payments to keep records                                                         Yes
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static int start_page(Scanner in) {
        System.out.println("Welcome to the application.");
        System.out.println("Please select a task by entering the number next to it.");
        System.out.printf(
                "1. Enter stores \t2. Display Stores \t3.Add items \n4.Customer Interaction \t5. Record of Payments\t6. Exit\n");
        int mode = Integer.parseInt(in.nextLine());
        // int mode = 1;
        return mode;
    }

    // Giving it the Meteorite approach. It's a messy way but infinitely flexible.
    public static int everything_except_start_page(int mode, Scanner in, ArrayList<Store> stores,
            ArrayList<Payment> payments, ArrayList<Order> orders) {
        switch (mode) {
            // The user has chosen to enter stores
            case 1: // adding a new store
                int loop_breaker;
                String name, address;
                int store_type;
                do {
                    System.out.println("Enter new Store's name:");
                    name = in.nextLine();
                    System.out.println("Enter new Store's address:");
                    address = in.nextLine();
                    System.out.println("Enter 0 for Online Store or enter 1 for Outlet Store.");
                    store_type = Integer.parseInt(in.nextLine());
                    Store temp;
                    if (store_type == 0) {
                        temp = new OnlineStore(name, address);
                    } else
                        temp = new OutletStore(name, address);
                    temp.populate_store(in);
                    stores.add(temp);
                    System.out.println("Press 1 to Enter a new store, 0 to return to start page.");
                    loop_breaker = Integer.parseInt(in.nextLine());
                } while (loop_breaker == 1);
                break;
            case 2: // Displaying the stores
                if (stores.size() != 0) {
                    for (Store store : stores) {
                        store.display_store();
                    }
                } else {
                    System.out.println("No stores have been entered yet");
                }
                break;
            case 3: // Adding items to an existing store
                System.out.println("Which Store would you like to add items to?");
                for (int i = 0; i < stores.size(); ++i) {
                    System.out.printf("%d.%s", i + 1, stores.get(i).get_name());
                    if ((i + 1) % 3 == 0) {
                        System.out.printf("\n");
                    } else {
                        System.out.printf("\t");
                    }
                }
                int choice = Integer.parseInt(in.nextLine());
                --choice;
                stores.get(choice).populate_store(in);
                break;
            case 4: // Customer interaction
                // Here's where the interface starts
                System.out.println("Welcome to KnockOffs's Franchise.");
                System.out.println("Please enter the customer's name.");
                String temp_cname = in.nextLine();
                System.out.println("How much money do they have?");
                double temp_balance = Double.parseDouble(in.nextLine());
                Customer customer = new Customer(temp_cname, temp_balance);
                System.out.println("You will now be able to make orders.");

                // block to fill out orders for a single customer
                // variables to temporarily store parameters for the order
                String iname;
                String istore;
                int inumber, ipayment;
                int order_breaker;
                do {
                    System.out.println("Please enter item name:");
                    iname = in.nextLine();
                    System.out.println("Which Store would you like to buy from?");
                    istore = in.nextLine();
                    System.out.println("How many of that item would you like?");
                    inumber = Integer.parseInt(in.nextLine());
                    // System.out.println;
                    System.out.printf("Select mode of payment:\n1. Cash\t2. Bank Card\t3.Online\n");
                    ipayment = Integer.parseInt(in.nextLine());
                    orders.add(new Order(iname, inumber, istore, ipayment));
                    System.out.println("Enter 1 to add another order. Enter 0 to move on to payment.");
                    order_breaker = Integer.parseInt(in.nextLine());
                } while (order_breaker == 1);

                // Block to go through the Orders and make payments according to payment_type
                // attribute. Weird naming so I can retain sanity.
                String store_name;
                int store_flag = 0;
                int payment_type;
                for (Order order : orders) {
                    store_name = order.get_store();
                    payment_type = order.get_payment_type();
                    order.details();
                    // Going through stores to find the one with matching name
                    for (Store store : stores) {
                        if (store.get_name() == store_name) {
                            // Making payments according to type
                            System.out.println("Found the store ");
                            switch (payment_type) {
                                case 1:
                                    payments.add(new CashPayment(customer, store, order));
                                    break;
                                case 2:
                                    payments.add(new CardPayment(customer, store, order));
                                    break;
                                case 3:
                                    payments.add(new OnlinePayment(customer, store, order));
                            }
                            store_flag = 1;
                            // Breaking the loop if store is found
                            break;
                        }
                        if (store_flag == 0) {
                            System.out.println("Invalid Store name.");
                        }
                    }
                }
                break;
            case 5: // Show Payment records
                for (Payment payment : payments) {
                    payment.details();
                }
                break;
            case 6:
                return 1;
            default:
                System.out.println("Invalid Input.");
        }
        return 0;
    }

    public static void main(String[] args) {

        // some declarations of global stuff
        // Scanner in = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Store> stores = new ArrayList<Store>();
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Scanner in = new Scanner(System.in);
        int response;
        int mode = start_page(in);
        do {
            response = everything_except_start_page(mode, in, stores, payments, orders);
        } while (response == 0);
    }
}
// handy block to print all orders
// for (Order a : orders) {
// a.details();
// }
// Hardcoded Stores
// Adding items into the stores
// OnlineStore Dresser = new OnlineStore("Dresser", "www.dresser.pk");
// OutletStore BoulderLand = new OutletStore("Boulder Land", "Street 4, Fantasy
// Land");
// Dresser.add_item("Doggo", 999.0, 4);
// BoulderLand.add_item("Doggo", 999.0, 3);
// Dresser.add_item("Cate", 9999.0, 2);
// BoulderLand.add_item("Cate", 9999.0, 1);
// Dresser.add_item("Floof", 9.0, 88);
// BoulderLand.add_item("Floof", 9.0, 88);
// Dresser.add_item("Birb", 999.0, 9999);
// BoulderLand.add_item("Birb", 999.0, 9999);
// System.out.println();
// stores.add(Dresser);
// stores.add(BoulderLand)
