
public class Order {
    private String item_name;
    private int number_of_items;
    private String store;
    private int payment_type; // 1 for Cash, 2 for Card, 3 for Online
    String ayyy;

    public Order(String name, int number, String s, int pay) {
        item_name = name;
        number_of_items = number;
        store = s;
        payment_type = pay;
    }

    // Some getters
    public String get_name() {
        return item_name;
    }

    public void details() {
        switch (payment_type) {
            case 1:
                ayyy = "Cash";
                break;
            case 2:
                ayyy = "Bank Card";
                break;
            case 3:
                ayyy = "Online API";
        }
        System.out.printf("\nProcessing the order of %d %s from %s through %s\n", number_of_items, item_name, store,
                ayyy);
    }

    public Integer get_number() {
        return number_of_items;
    }

    public int get_payment_type() {
        return payment_type;
    }

    // Apparently, functions can return references to objects
    // Yeah, but I can't pass reference to objects
    public String get_store() {
        return store;
    }
}