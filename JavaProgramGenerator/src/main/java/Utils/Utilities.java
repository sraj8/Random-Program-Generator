package Utils;

import com.mifmif.common.regex.Generex;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Utilities {
    /**
     * Randomly generates string for the type of regex having length between min and max
     * @param regex
     * @param min
     * @param max
     * @return String
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

    /**
     * Takes the path of config.xml file and parses it to create Configuration Object
     * @param path
     * @return Configuration object
     */
    public Configuration parseConfigFile(String path){
        Configuration configuration = Configuration.getInstance();

        List<String> allowedTypes = new ArrayList<>();
        List<String> accessModifiers = new ArrayList<>();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){

                boolean bmaxLinesOfCode = false, bmaxClasses = false, bmaxMethodCalls = false, bmaxMethodsInClass = false, bmaxInterfaces = false;
                boolean bmaxMethodsInInterface = false, bmaxInterfacesToImplement = false, bmaxIntValue = false, bmaxStringLength = false;
                boolean bmaxVariableNameLength = false, bTypes = false, bModifier = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if(qName.equalsIgnoreCase("maxLinesofCode")){bmaxLinesOfCode = true;}
                    if(qName.equalsIgnoreCase("maxClasses")){bmaxClasses = true;}
                    if(qName.equalsIgnoreCase("maxMethodCalls")){bmaxMethodCalls = true;}
                    if(qName.equalsIgnoreCase("maxMethodsInClass")){bmaxMethodsInClass = true;}
                    if(qName.equalsIgnoreCase("maxInterfaces")){bmaxInterfaces = true;}
                    if(qName.equalsIgnoreCase("maxMethodsInInterface")){bmaxMethodsInInterface = true;}
                    if(qName.equalsIgnoreCase("maxInterfacesToImplement")){bmaxInterfacesToImplement = true;}
                    if(qName.equalsIgnoreCase("maxIntValue")){bmaxIntValue = true;}
                    if(qName.equalsIgnoreCase("maxStringLength")){bmaxStringLength = true;}
                    if(qName.equalsIgnoreCase("maxVariableNameLength")){bmaxVariableNameLength = true;}
                    if(qName.equalsIgnoreCase("type")){bTypes = true;}
                    if(qName.equalsIgnoreCase("modifier")){bModifier = true;}
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if(bmaxLinesOfCode){ configuration.setMaxLinesOfCode(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxClasses){configuration.setMaxClasses(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxMethodCalls){configuration.setMaxMethodCalls(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxMethodsInClass){configuration.setMaxMethodsInClass(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxInterfaces){configuration.setMaxInterfaces(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxMethodsInInterface){configuration.setMaxMethodsInInterface(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxInterfacesToImplement){configuration.setMaxInterfacesToImplement(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxIntValue){configuration.setMaxIntValue(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxStringLength){configuration.setMaxStringLength(Integer.valueOf(new String(ch,start,length)));}
                    if(bmaxVariableNameLength){configuration.setMaxVariableNameLength(Integer.valueOf(new String(ch,start,length)));}
                    if(bTypes){allowedTypes.add(new String(ch,start,length));}
                    if(bModifier){accessModifiers.add(new String(ch,start,length));}
                }
            };

            saxParser.parse("src/main/resources/config.xml",handler);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setAllowedTypes(allowedTypes);
        configuration.setAccessModifiers(accessModifiers);

        return configuration;
    }


    public static String getRandomFromList(String anyType[]) {
        int randomNum = 0;
        if (anyType.length > 0)
            randomNum = ThreadLocalRandom.current().nextInt(0, anyType.length);
        return anyType[randomNum].split(":=")[1].split("\\|")[1];
    }


    public static Scanner getScanner(String pathName) {
        File file = new File(pathName);
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return fileScan;
    }

    public static int random_number(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }



}
