public class Main {
    public static void main(String[] args) {
        OnlineStore Dresser = new OnlineStore("www.dresser.pk");
        OutletStore BoulderLand = new OutletStore("Street 4, Fantasy Land");
        Customer customer1 = new Customer("Speedwagon", 9999.0); // Speedwagon is his name
        Customer customer2 = new Customer("Joseph Joestar", 3.0);
        // Adding items into the stores
        Dresser.add_item("Doggo", 999.0, 4);
        BoulderLand.add_item("Doggo", 999.0, 3);
        Dresser.add_item("Cate", 9999.0, 2);
        BoulderLand.add_item("Cate", 9999.0, 1);
        Dresser.add_item("Floof", 9.0, 88);
        BoulderLand.add_item("Floof", 9.0, 88);
        Dresser.add_item("Birb", 999.0, 9999);
        BoulderLand.add_item("Birb", 999.0, 9999);
        Order an_order = new Order("Doggo", 1);
        Order an_order2 = new Order("Grass Doggo", 1);
        OnlinePayment bread = new OnlinePayment(customer1, Dresser, an_order);
        OnlinePayment bread2 = new OnlinePayment(customer1, Dresser, an_order2);
        Dresser.display_store();
        BoulderLand.display_store();
    }
}
