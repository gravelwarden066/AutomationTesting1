package pages;

public class PageFactory {

    public HomePage getHomePage() {
        return new HomePage();
    }
    public AuthPage getAuthPage() { return new AuthPage();}
    public CartPage getCartPage(){return new CartPage();}

}

