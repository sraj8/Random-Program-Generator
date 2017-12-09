package Utils;

import java.util.Map;

public class WhileGenerator {

    public static String generateWhileLoop(String grammar, Map<String,String> grammarMap, Map<String,String> regexMap){
        StringBuilder whileDeclaration = new StringBuilder();
        String split[] = grammar.split(" ");
        for(int i=0;i<split.length;i++){
            if(split[i].charAt(0)=='<'){
                if(split[i].contains("var")){
                    String regex = regexMap.get(split[i]);
                    String var = Utilities.getRandomString(regex,2,5);
                    whileDeclaration.append(var);
                }else if(split[i].contains("digit")){
                    String regex = regexMap.get(split[i]);
                    String digit = Utilities.getRandomString(regex,2,3);
                    whileDeclaration.append(digit);
                }
            }else if(split[i].charAt(0)=='\''){
                whileDeclaration.append(split[i].replaceAll("'",""));
            }
        }
        return whileDeclaration.toString();
    }

}
