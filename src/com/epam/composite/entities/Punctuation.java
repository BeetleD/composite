package com.epam.composite.entities;

/**
 * Created by Dmitry on 04.07.2014.
 */
public class Punctuation extends AbstractLeaf {
    private char lexem;

    public Punctuation(){

    }
    public Punctuation( char lexem ){
        this.lexem = lexem;
    }
    @Override
    public String getLexem() {
        return Character.toString(lexem);
    }
    public void setLexem(char lexem) {
        this.lexem = lexem;
    }
}
