package com.epam.composite.entities;

import java.util.Collections;

/**
 * Created by Dmitry on 25.06.2014.
 */
public abstract class AbstractLeaf implements TextComposite {
    public abstract String getLexem();
    @Override
    public void push(TextComposite comp) {
    }

    @Override
    public TextComposite remove(int id) {
        return null;
    }

    @Override
    public int getChildrenCount() {
        return 0;
    }

    @Override    public TextComposite getChild(int id) {
        return null;
    }
    @Override
    public TextComposite set( int id, TextComposite comp ){
        return null;
    }
}
