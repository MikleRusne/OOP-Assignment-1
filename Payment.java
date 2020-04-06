class Payment {
    protected double value;

    public Payment() {
    };

    public Payment(double value) {
        this.value = value;
    }

    public abstract 0acknowledge(){
        //the way a payment is acknowledged depends on the medium, so all children of payments shall have different method of acknowledgement.
    }

    // Since all payment has one thing in common, money being transferred.
    // Obsolete now that there's a function to make payment
    // public double get_value() {
    // return value;
    // }
    // A function to combine the above functions into one
    public double make_payment() {
        acknowledge();
        return value;
    }
}