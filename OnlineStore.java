class OnlineStore extends Store {
    // online stores can only be accessed by their website
    public void provide_site() {
        System.out.println("A website has been provided to the user.");
    }
}