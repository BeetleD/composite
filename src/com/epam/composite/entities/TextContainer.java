package com.epam.composite.entities;

import java.util.ArrayList;

/**
 * Created by Dmitry on 25.06.2014.
 */
public class TextContainer extends ArrayList<TextComposite> implements TextComposite  {

    @Override
    public void push( TextComposite textComp ){
        this.add( textComp );
    }
    @Override
    public int getChildrenCount() {
        return this.size();
    }
    @Override
    public TextComposite getChild(int id) {
        return this.get( id );
    }
}
