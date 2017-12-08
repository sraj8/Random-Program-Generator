package Utils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadFiles {

    public static void readGrammarFile(List<String> topList, List<String> lowList, Map<String,String> grammarMap){
        Scanner fileScan = Utilities.getScanner("src/main/resources/grammar.txt");
        while(fileScan.hasNextLine()){
            String line = fileScan.nextLine();
            if(line.contains("<class_name>:=")){
                topList.add(line.replace("<class_name>:=",""));
            }
            else if(line.contains("<expression>:=")){
                lowList.add(line.replace("<expression>:=",""));
            } else {
             String[] exps = line.split(":=");
                grammarMap.put(exps[0],exps[1]);
            }
        }
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
