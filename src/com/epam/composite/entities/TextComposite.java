package com.epam.composite.entities;

/**
 * Created by Dmitry on 25.06.2014.
 */
public interface TextComposite {
    public TextComposite set( int id, TextComposite comp );
    public void push( TextComposite comp );
    public TextComposite remove( int id );
    public int getChildrenCount();
    public TextComposite getChild( int id );
}
