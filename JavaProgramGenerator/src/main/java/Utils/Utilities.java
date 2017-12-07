package Utils;

import com.mifmif.common.regex.Generex;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Utilities {
    /**
     *
     * @param regex
     * @param min
     * @param max
     * @return Randomly generated string for the type of regex having length between min and max
     */
    public String getRandomString(String regex, int min, int max){
        String randomString = "";
        Generex generex = new Generex(regex);
        if(min > 0 && max==0){
            randomString = generex.random(min);
        }else if(min==0 && max==0){
            randomString = generex.random();
        }else{
            randomString = generex.random(min,max);
        }
        return randomString;
    }

    public Configuration parseConfigFile(String path){
        Configuration configuration = Configuration.getInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                
            };
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return configuration;
    }



}
