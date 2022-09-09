package pages;

import pages.testpages.TestPage;

public class PageFactory {

    public HomePage getHomePage() {
        return new HomePage();
    }
    public AuthPage getAuthPage() { return new AuthPage();}
    public CartPage getCartPage(){return new CartPage();}
    public TestPage getTestPage(){return new TestPage();}

}

