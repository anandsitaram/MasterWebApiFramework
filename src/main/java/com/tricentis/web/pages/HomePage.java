package com.tricentis.web.pages;

public class HomePage extends BasePage{

    public HomePage(){
        super();
        menuPage=new MenuPage();
    }

    private MenuPage menuPage;

    public MenuPage goToMenu() {
        return menuPage;
    }
}

