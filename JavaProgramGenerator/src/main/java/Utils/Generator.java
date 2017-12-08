package Utils;

import java.util.List;
import java.util.Queue;

public class Generator {


    public static void generateTopLevelQueue(List<String> topList, Queue<String> topQueue){
        //populate top queue from top list
        String splittedArray[]= {};
        for (String grammar : topList) {
            splittedArray = getSplittedArray(grammar);
            for (String splitted : splittedArray) {
                topQueue.add(splitted);
            }
        }
    }

    private static String[] getSplittedArray(String grammar) {
        String[] splitted = grammar.split("\\s+");
        return splitted;
    }


    public static String evaluateExpression(String expression){
        StringBuffer result = new StringBuffer();
        //evaluate left hand and right hand side of expression

        return result.toString();

    }
}
