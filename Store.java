import java.util.ArrayList;
import java.util.Scanner;
//limitations
//  Cannot add items.                                                                               Fixed
//  Have to use ArrayLists, Integer and Double objects.                                             Workaround made
//  Cannot modify price once set.                                                                   Not needed
//  A method to check if an item exists, since that has to be done a lot.                           Done

abstract class Store {
    protected ArrayList<String> items; // asssuming a store has unlimited stock, an arraylist of strings should be
                                       // sufficient
    protected ArrayList<Integer> stock; // a second arrlist to keep track of the stock
    protected ArrayList<Double> prices; // yet another arrList to keep track of the prices
    protected String address; // outlets must have address. But for online stores, the website URL is the
                              // address
    protected String name;

    public void sale(Integer n, String s, String c) {
        System.out.println(((int) n) + " amount of " + s + " has been sold to " + c + " by the store " + name + ".");
    }

    public void populate_store(Scanner in) {
        int loop_breaker;
        String item;
        Double price;
        int number;
        do {
            System.out.println("Enter the name of the item:");
            item = in.nextLine();
            System.out.println("Enter the price of the item:");
            price = Double.parseDouble(in.nextLine());
            System.out.println("Enter the amount of the item:");
            number = Integer.parseInt(in.nextLine());
            this.add_item(item, new Double(price), new Integer(number));
            System.out.println("Enter 1 to add another item, 0 to finish adding items.");
            loop_breaker = Integer.parseInt(in.nextLine());
        } while (loop_breaker == 1);
    }

    public Store(String name, String address) {
        items = new ArrayList<String>();
        stock = new ArrayList<Integer>();
        prices = new ArrayList<Double>();
        this.address = address;
        this.name = name;
    }

    public Store() {
        items = new ArrayList<String>();
        stock = new ArrayList<Integer>();
        prices = new ArrayList<Double>();
    }

    public int exists(String s) {
        int location = items.indexOf(s);
        if (location == -1) {
            System.out.println("That item is invalid.");
            return -1;
        } else if (stock.get(location) == 0) {
            System.out.println("That item is out of stock.");
            return 0;
        } else {
            System.out.println("Returning 1");
            return 1;
        }
    }

    public void add_item(String s, Double price, Integer number) {
        int location = items.indexOf(s);
        if (location != -1) {
            // Integer object is immutable, so this ugly thing
            stock.set(location, (stock.get(location)) + number);
        } else {
            items.add(s);
            stock.add(number);
            prices.add(price);
        }
    }

    public void get_item(String s, Integer number) {
        if (exists(s) == 1) {
            int location = items.indexOf(s);
            if (stock.get(location) < number) {
                System.out.println("Insufficient stock.");
            } else {
                // removing occurrences from stock
                stock.set(location, (stock.get(location)) - number);
                System.out.println(number + " of the item " + s + " was/were gotten.");
            }
        }
    }

    public String get_name() {
        return name;
    }

    public int get_stock(String s) {
        int location = items.indexOf(s);
        return (int) stock.get(location);
    }

    // Setter was obsolete, would never need it so stopped making it midway.
    // public void set_price(String s, Double d) {
    // // Contingencies if the name isn't found
    // if (exists(s) != 1) {
    // System.out.println("Invalid item.");
    // } else {
    //
    // }
    // }

    public double get_price(String s) {
        // never call this function before verifying that items exist
        int location = items.indexOf(s);
        return prices.get(location);
    }

    public void display_store() {
        System.out.println("The store " + name + " located at " + address + " has the following items:");
        this.display_stock();
    }

    public void display_stock() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + "   " + stock.get(i) + "  " + prices.get(i));
        }
    }

}