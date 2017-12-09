package Utils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {


    public static void generateTopLevelQueue(List<String> topList, Queue<String> topQueue){
        //populate top queue from top list
        //class and
        //random 0 -
        String grammar = "";
        if(topList.size() > 0)
            grammar = getRandomTopElement(topList);
        String splittedArray[]= {};
        splittedArray = getSplittedArray(grammar);
        for (String splitted : splittedArray) {
            topQueue.add(splitted);
        }
    }

    private static String getRandomTopElement(List<String> topList) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, topList.size());
        return topList.get(randomNum);
    }

    private static String[] getSplittedArray(String grammar) {
        String[] splitted = grammar.split("\\s+");
        return splitted;
    }


    public static String evaluateExpression(String expression, Map<String,String> grammarMap, Map<String,String> regexMap){
        StringBuffer result = new StringBuffer();
        //evaluate left hand and right hand side of expression
        Queue<String> leftQueue = new LinkedList<>();
        Stack<String> rightStack = new Stack<>();
        String[] splittedExpression= expression.split(" = ");
        String lhs[] = splittedExpression[0].split("\\s+");
        String rhs[] = splittedExpression[1].split("\\s+");

        for (String lhString : lhs) {
            leftQueue.add(lhString);
        }
        for (String rhString : lhs) {
            rightStack.push(rhString);
        }

        processLeftQueue(leftQueue, result, grammarMap, regexMap);
        processRightQueue(rightStack, result, grammarMap, regexMap);
        return result.toString();

    }

    private static void processRightQueue(Stack<String> rightStack, StringBuffer result, Map<String,String> grammarMap, Map<String,String> regexMap) {
        while (!rightStack.isEmpty()){
            String stackElement = rightStack.pop();
            if (grammarMap.containsKey(stackElement)) {
                String grammar = grammarMap.get(stackElement);
                if (grammar.contains("<") && grammar.contains(">")) {
                    String splittedArray[] = getSplittedArray(grammar);
                    for (String splitted : splittedArray){
                        rightStack.push(splitted);
                    }
                }
                else if (grammar.contains("|")) {
                    String[] splittedGrammar = grammar.split("\\|");
                    String appender = Utilities.getRandomFromList(splittedGrammar);
                    result.append(appender);
                }
            } /*else {
                if (stackElement.contains("<") && stackElement.contains(">") && regexMap.containsKey(element)) {
                    result.append(" " + Utilities.getRandomString(regexMap.get(element), 0, 5));

                } else if (element.contains("'")) {
                    result.append(" " + element.substring(1, element.length() - 1));
                }
            }*/
        }
    }

    private static void processLeftQueue(Queue<String> leftQueue, StringBuffer result, Map<String,String> grammarMap, Map<String,String> regexMap) {
    }
}
