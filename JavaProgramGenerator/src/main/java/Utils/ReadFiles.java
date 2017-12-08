package Utils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadFiles {

    public static void readGrammarFile(List<String> topList, List<String> lowList, Map<String,String> grammarMap){

    }

    public static void readRegexFile(Map<String,String> regexMap){
        Scanner fileScan = Utilities.getScanner("src/main/resources/regex.txt");

        while(fileScan.hasNext()){
            String regex = fileScan.nextLine().toString();
            String[] regexParts = regex.split("=");
            regexMap.put(regexParts[0],regexParts[1]);
        }
    }


}
