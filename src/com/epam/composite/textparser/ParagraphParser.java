package com.epam.composite.textparser;

import com.epam.composite.exception.WrongTextFormatException;
import com.epam.composite.entities.Listing;
import com.epam.composite.entities.TextComposite;
import com.epam.composite.entities.TextContainer;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitry on 25.06.2014.
 */
public class ParagraphParser extends TextParser {

    private SentenceParser sentenceParser;
    private String sentenceRegExp = "([\\S[ ]]+?(([?!.]+([\\s]|\\Z))|\\Z))";
    private String listingRegExp = "(?s)(//:.*?///:~)";

    private Pattern sentencePattern;
    private Pattern listingPattern;


    public ParagraphParser( Properties properties ){
        this.regExpProperties = properties;
    }
    @Override
    public void initialize() throws IOException {
        sentenceRegExp = regExpProperties.getProperty( "sentence" );
        listingRegExp = regExpProperties.getProperty( "listing" );
        sentencePattern = Pattern.compile( sentenceRegExp );
        listingPattern = Pattern.compile( listingRegExp );
        sentenceParser = new SentenceParser( regExpProperties );
        sentenceParser.initialize();
    }
    @Override
    public TextComposite parse(String s) throws WrongTextFormatException {
        TextComposite textComp;
        Matcher matcher = listingPattern.matcher( s );
        if ( matcher.find()){
            textComp = new Listing(matcher.group());
        } else {
            matcher = sentencePattern.matcher( s );
            textComp = new TextContainer();
            while ( matcher.find() ){
                textComp.push(sentenceParser.parse(matcher.group()));
            }
        }
        return textComp;
    }
}
