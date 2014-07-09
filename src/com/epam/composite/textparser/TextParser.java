package com.epam.composite.textparser;

import com.epam.composite.Exception.WrongTextFormatException;
import com.epam.composite.entities.TextComposite;
import com.epam.composite.entities.TextContainer;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitry on 25.06.2014.
 */
public class TextParser {

    final static Logger logger = Logger.getLogger(TextParser.class);
    private String paragraphRegExp = "(?s)(//:.*?///:~)|([\\S[ ]]+)";
    private Pattern paragraphPattern;
    protected Properties regExpProperties;
    private ParagraphParser paragraphParser;
    private static String FILE_NAME = "src\\regexp.properties";
    public void initialize( String fileName ) throws IOException {
        regExpProperties = new Properties();
        try ( FileInputStream in = new FileInputStream( fileName ) ){
            regExpProperties.load(in);
        }
        paragraphRegExp = regExpProperties.getProperty("paragraph");
        paragraphPattern = Pattern.compile(paragraphRegExp);
        paragraphParser = new ParagraphParser( regExpProperties );
        paragraphParser.initialize();
    }
    public void initialize() throws IOException {
        initialize( FILE_NAME );
    }
    public TextComposite parse(String s ) throws IOException, WrongTextFormatException {
        Matcher matcher = paragraphPattern.matcher( s );
        TextContainer textCont = new TextContainer();
        paragraphParser.initialize();
        while ( matcher.find() ) {
            textCont.push( paragraphParser.parse(matcher.group()));
            //logger.info( matcher.start() + " " + matcher.end() );
        }
        return textCont;
    }
    public TextComposite parse(File file ) throws IOException, WrongTextFormatException {
        Scanner sc = new Scanner( file );
        String s = sc.useDelimiter("\\A").next();
        return parse( s );
    }
}
