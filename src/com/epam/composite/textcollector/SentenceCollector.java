package com.epam.composite.textcollector;

import com.epam.composite.entities.AbstractLeaf;
import com.epam.composite.entities.Punctuation;
import com.epam.composite.entities.TextComposite;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class SentenceCollector extends AbstractCollector {
    public static String LAST_WORD_SYMBOLS = " ";
    @Override
    public String collect( TextComposite textComp ){
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < textComp.getChildrenCount(); i++ ){
            if ( textComp.getChild(i) instanceof AbstractLeaf){
                sb.append( ((AbstractLeaf) textComp.getChild(i)).getLexem());
            }
            if ( i < textComp.getChildrenCount()-1 ){
                if (!( textComp.getChild( i+1 ) instanceof Punctuation ))
                    sb.append( LAST_WORD_SYMBOLS );
            }
        }
        return sb.toString();
    }
}
