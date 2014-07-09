package com.epam.composite;

import com.epam.composite.Exception.WrongTextFormatException;
import com.epam.composite.entities.TextContainer;
import com.epam.composite.textcollector.TextCollector;
import com.epam.composite.textoperation.TextOperation;
import com.epam.composite.textparser.TextParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);
    static{
        DOMConfigurator.configure("src\\log4j.xml");
    }
    public static void main(String[] args) {
        File textFile = new File( "texts\\text.txt");
        TextContainer textContainer;
        try {
            TextParser textParser = new TextParser();
            textParser.initialize();
            textContainer = (TextContainer) textParser.parse( textFile );
            TextCollector textCollector = new TextCollector();
            PrintWriter pw = new PrintWriter("texts\\collected1.txt");
            pw.write( textCollector.collect( textContainer ));
            pw.close();
            TextOperation.swapFirstLast( textContainer );
            pw = new PrintWriter("texts\\collected2.txt");
            pw.write(textCollector.collect( textContainer ) );
            pw.close();
        } catch( FileNotFoundException e){
            logger.error("file " + textFile + " not found", e );
        } catch (IOException e) {
            logger.error("parser initialization error ",e  );
        } catch (WrongTextFormatException e) {
            logger.error("text is corrupted of has a wrong format");
        }
    }
}
