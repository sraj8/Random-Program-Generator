import Utils.Generator;
import Utils.ReadFiles;
import Utils.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProgramGenerator {

   // static List<String> expressionList = new ArrayList<>();

  //  static  List<String> operatorList = new ArrayList<>();

  //  static List<String> terminalList = new ArrayList<>();

   // static List<String> nonTerminalList = new ArrayList<>();

    static Stack<String> expressionGeneratorStack = new Stack<>() ;

    static StringBuffer result = new StringBuffer();

    static Map<String,String> regexMap;

    static Utilities utilities;

    static List<String> topList;
    static  List<String> lowList;
    static  Map<String,String> grammarMap;
    static  Queue<String> topQueue;



    public static void main(String[] args) {
        utilities = new Utilities();

        initializeAllDataHolders();


        //make list top-level mid-level and low-level
        ReadFiles.readGrammarFile(topList,lowList,grammarMap);

        //no changes required here
        ReadFiles.readRegexFile(regexMap);


        Generator.generateTopLevelQueue(topList,topQueue);


        queueProcessing();

        //start by class name
      //  topGrammarSetUp();


        //no changes required here
     //   readTerminalNonTerminal();

        //low-level contruct
     //   generateExpression();

        System.out.println(result.toString());
    }

    private static void initializeAllDataHolders() {
    }

    private static void queueProcessing() {
    }



   /* private static void topGrammarSetUp() {
        String initialExpression = expressionList.get(0);

        String initialExpressionBreak[] = (initialExpression.split(":="));

        if(initialExpressionBreak[0].equals("<var>")){
            result.append(utilities.getRandomString(regexMap.get(initialExpressionBreak[0]),2,5));
        }
        result.append("=");


        initialExpressionBreak = initialExpressionBreak[1].split("\\|");
        expressionGeneratorStack.push(initialExpressionBreak[0].trim());
        expressionGeneratorStack.push(initialExpressionBreak[1].trim());
        expressionGeneratorStack.push(initialExpressionBreak[2].trim());
    }*/

   /* private static void insertCompleteExpression() {
        String initialExpression = expressionList.get(0);

        String initialExpressionBreak[] = (initialExpression.split(":="));
        initialExpressionBreak = initialExpressionBreak[1].split("\\|");
        expressionGeneratorStack.push(initialExpressionBreak[0].trim());
        expressionGeneratorStack.push(initialExpressionBreak[1].trim());
        expressionGeneratorStack.push(initialExpressionBreak[2].trim());
    }*/




   /* public static  void generateExpression(){

        while(!expressionGeneratorStack.isEmpty()) {

            String currentTopExpression = expressionGeneratorStack.pop();


            if(terminalList.contains(currentTopExpression)){
                if (currentTopExpression.trim().equals("<op>")) {
                    String operator = utilities.getOperator(operatorList);

                    //this number should also be generated randomly
                    result.append(operator);

                }

            }else{
                //recursive call will happen here - need to fix this
                if (currentTopExpression.trim().equals("<expression>")) {

                    int randomExpressionNumber = utilities.random_number(0,expressionList.size()-1);

                    if(randomExpressionNumber == 0){
                        //inserts expression <var> := <expression> <op> <expression> recursively
                        insertCompleteExpression();

                    }else if (randomExpressionNumber == 1){
                        //terminal - adds digits
                        String digits[] = expressionList.get(1).split(":=")[1].split("\\|");

                        //this number should be generated randomly
                        result.append(digits[2]);

                    }



                }

            }




        }

    }*/




  /*  public static void readGrammarFile(){

        Scanner fileScan = utilities.getScanner("src/main/resources/grammar.txt");

        while(fileScan.hasNext()){
            String grammar = fileScan.nextLine().toString();

            if(grammar.contains("<expression>")){
                expressionList.add(grammar);
            }else if(grammar.contains("<op>")){
                operatorList.add(grammar);
            }


        }
    }*/



   /* public static void readTerminalNonTerminal(){

        Scanner fileScan = utilities.getScanner("src/main/resources/TerminalNonTerminal.txt");

        while(fileScan.hasNext()){
            String terminalNonTerminal = fileScan.nextLine().toString();

            if(terminalNonTerminal.contains("terminal")){
                String terminals[] = terminalNonTerminal.split(":=")[1].split("\\|");
                for(String terminal : terminals){
                    terminalList.add(terminal);
                }
            }else if(terminalNonTerminal.contains("non-ter")){
                String nonTerminals[] = terminalNonTerminal.split(":=")[1].split("\\|");
                for(String nonTerminal : nonTerminals){
                    nonTerminalList.add(nonTerminal);
                }
            }


        }


    }*/
}
