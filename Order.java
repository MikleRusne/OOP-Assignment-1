
public class Order {
    private String item_name;
    private Integer number_of_items;

    public Order(String name, Integer number) {
        item_name = name;
        number_of_items = number;
    }

    public String get_name() {
        return item_name;
    }

    public Integer get_number() {
        return number_of_items;
    }
}