package com.epam.composite.textcollector;

import com.epam.composite.entities.Listing;
import com.epam.composite.entities.TextComposite;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class TextCollector extends AbstractCollector {
    public static final String FIRST_PARAGRAPH_SYMBOLS = "\t";
    public static final String LAST_PARAGRAPH_SYMBOLS = "\n";
    public static final String FIRST_LISTING_SYMBOLS = "";
    public static final String LAST_LISTING_SYMBOLS = "\n";
    ParagraphCollector paragraphCollector = new ParagraphCollector();

    @Override
    public String collect( TextComposite textComp ){
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < textComp.getChildrenCount(); i++ ){
            if ( textComp.getChild( i ) instanceof Listing ){
                sb.append( FIRST_LISTING_SYMBOLS );
                sb.append( ((Listing) textComp.getChild( i )).getLexem());
                sb.append(( LAST_LISTING_SYMBOLS ));
            } else {
                sb.append( FIRST_PARAGRAPH_SYMBOLS );
                sb.append(( paragraphCollector.collect( textComp.getChild(i))));
                sb.append( LAST_PARAGRAPH_SYMBOLS );
            }
        }
        return sb.toString();
    }
}
