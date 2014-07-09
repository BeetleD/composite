package com.epam.composite.textparser;

import com.epam.composite.Exception.WrongTextFormatException;
import com.epam.composite.entities.*;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitry on 06.07.2014.
 */
public class SentenceParser extends ParagraphParser {
    private String wordRegExp = "[\\S]+";
    private String punctuationRegExp  = "[!\",.:;?]";
    private Pattern wordPattern;
    private Pattern punctuationPattern;
    public void initialize(){
        wordRegExp = regExpProperties.getProperty("word");
        punctuationRegExp = regExpProperties.getProperty("punctuation");
        wordPattern = Pattern.compile( wordRegExp );
        punctuationPattern = Pattern.compile( punctuationRegExp );
    }
    private void parseWord( TextContainer textCont, String s ) throws WrongTextFormatException {
        Matcher matcher = punctuationPattern.matcher(s);
        int wordStartIndex = 0;
        while ( matcher.find() ){
            if ( matcher.end() - matcher.start() > 1 ) throw new WrongTextFormatException();
            if ( wordStartIndex < matcher.start()){
                textCont.push( new Word( s.substring(wordStartIndex, matcher.start())));
            }
            textCont.push( new Punctuation( s.charAt(matcher.start())));
            wordStartIndex = matcher.end();
        }
        if (wordStartIndex < s.length()) {
            textCont.push(new Word(s.substring(wordStartIndex, s.length())));
        }
    }
    public SentenceParser(Properties properties) {
        super(properties);
    }
    @Override
    public TextComposite parse(String s) throws WrongTextFormatException {
        TextContainer textCont = new TextContainer();
        Matcher matcher = wordPattern.matcher( s );
        while ( matcher.find() ){
            parseWord( textCont, matcher.group());
        }
        return textCont;
    }

}
