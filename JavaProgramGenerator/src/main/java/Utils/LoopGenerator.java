package Utils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static Utils.Generator.getSplittedArray;

public class LoopGenerator {

    public static String loopEvaluator(String loopExpression, Map<String,String> regexMap){
        StringBuffer result =new StringBuffer();
        Queue<String> loopQueue = new LinkedList<>();
        String splittedExp[] = getSplittedArray(loopExpression);
        for (String splitted : splittedExp){
            loopQueue.add(splitted);
        }

        evaluateLoopExpression(loopQueue, result, regexMap);
        return result.toString();
    }

    private static void evaluateLoopExpression(Queue<String> loopQueue, StringBuffer result, Map<String,String> regexMap) {
        String var = "";
        String prev = "";
        for (String loopq : loopQueue) {
            if (loopq.contains("'")) {
                if(loopq.length() > 1)
                    result.append(" " + loopq.substring(1, loopq.length()-1));
            }
            else if (loopq.contains("<") && loopq.contains(">") && regexMap.containsKey(loopq)) {
                var = (" " + Utilities.getRandomString(regexMap.get(loopq), 0, 1));
                if(loopq.contains("var")){
                    prev = var;
                }
                result.append(var);
            }
            else if (loopq.contains("var_prev")){
                result.append(prev);
            }
        }
    }

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
