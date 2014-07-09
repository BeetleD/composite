package com.epam.composite.entities;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class Listing extends AbstractLeaf {
    private String lexem;
    public Listing() {

    }
    public Listing( String s ){
        this.lexem = s;
    }

    @Override
    public String getLexem() {
        return lexem;
    }

    public void setLexem(String lexem) {
        this.lexem = lexem;
    }
}
