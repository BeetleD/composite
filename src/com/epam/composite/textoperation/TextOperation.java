package com.epam.composite.textoperation;

import com.epam.composite.entities.Listing;
import com.epam.composite.entities.TextComposite;
import com.epam.composite.entities.TextContainer;
import com.epam.composite.entities.Word;

import javax.xml.soap.Text;
import java.util.Collections;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class TextOperation {
    private static void swap( TextContainer textCont, int i, int j ){
        Collections.swap( textCont, i, j);
    }
    private static int getFirstWordIndex( TextContainer textCont ){
        for ( int i = 0; i < textCont.getChildrenCount(); i++ ){
            if ( textCont.getChild( i ) instanceof Word){
                return i;
            }
        }
        return -1;
    }
    private static int getLastWordIndex( TextContainer textCont ){
        for ( int i = textCont.getChildrenCount()-1; i >= 0; i-- ){
            if ( textCont.getChild( i ) instanceof Word){
                return i;
            }
        }
        return -1;
    }
    private static void swapFirstLastParagraph( TextContainer textCont ){
        for ( int i = 0; i < textCont.getChildrenCount(); i++ ){
            TextContainer sentence = (TextContainer)textCont.getChild(i);
            int firstId = getFirstWordIndex( sentence );
            int lastId = getLastWordIndex( sentence);
            if (( firstId >= 0)&&( lastId >= 0)){
                swap( sentence, firstId, lastId );
            }
        }
    }
    public static void swapFirstLast( TextContainer textCont ){
        for ( int i = 0; i < textCont.getChildrenCount(); i++ ){
            if ( !(textCont.getChild(i) instanceof Listing) ){
                TextContainer paragraph = (TextContainer)textCont.getChild(i);
                swapFirstLastParagraph( paragraph );

            }
        }
    }
}
