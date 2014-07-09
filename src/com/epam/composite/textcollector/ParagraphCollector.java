package com.epam.composite.textcollector;

import com.epam.composite.entities.TextComposite;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class ParagraphCollector extends AbstractCollector {
    public static final String LAST_SENTENCE_SYMBOLS = " ";
    SentenceCollector sentenceCollector = new SentenceCollector();
    @Override
    public String collect( TextComposite textComp ){
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < textComp.getChildrenCount(); i++ ){
            sb.append( sentenceCollector.collect(textComp.getChild( i )) );
            sb.append( LAST_SENTENCE_SYMBOLS );
        }
        return sb.toString();
    }
}
