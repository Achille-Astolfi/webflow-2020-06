package com.example.corso.flow.viewmodel;

/**
 * Il JavaBean View Model della pagina hello-world.
 */
public class HelloWorldViewModel {
    // I dati presenti nella pagina hello-world sono due:
    // il titolo - lo rappresentiamo con la property title
    // il saluto - lo rappresentiamo con la property greet
    private String title;
    private String greet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }
}
