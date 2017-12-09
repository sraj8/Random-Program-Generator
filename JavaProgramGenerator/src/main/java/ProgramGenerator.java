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

    static Stack<String> rightStack ;

    static StringBuffer result ;

    static Queue<String> leftQueue;

    static Map<String,String> regexMap;

    static Utilities utilities;

    static List<String> topList;
    static  List<String> lowList;
    static Map<String,Integer> lowListElement;
    static  Map<String,String> grammarMap;
    static  Queue<String> topQueue;


   public static void initializeAllDataHolders() {
       //stack for processing right hand of expression
       rightStack = new Stack<>();
       //result after processing topqueue
       result = new StringBuffer();
       //queue for processing left hand of expression
       leftQueue =  new LinkedList<>();
       //regex for the variable, class and other names
       regexMap = new HashMap<>();
       utilities = new Utilities();
       //class and intergace
       topList = new ArrayList<>();
       //currently expression
       lowList = new ArrayList<>();
       //all other grammar which are not part of top and low list
       grammarMap = new HashMap<>();
       //grammar selected from top list
       topQueue = new LinkedList<>();
       //count of lowlist elements in lowlist -e.g <expression>,3
       lowListElement = new HashMap<>();
    //   lowListElement.put("<expression>",3);

    }



    public static void main(String[] args) {
        utilities = new Utilities();

        initializeAllDataHolders();





        //make list top-level mid-level and low-level
        ReadFiles.readGrammarFile(topList,lowList,grammarMap,lowListElement);

        //no changes required here
        ReadFiles.readRegexFile(regexMap);





        queueProcessing();

        //start by class name
      //  topGrammarSetUp();


        //no changes required here
     //   readTerminalNonTerminal();

        //low-level contruct
     //   generateExpression();

        System.out.println(result.toString());
    }



    public static void queueProcessing() {
        /*
            1. read top queue one element at a time
                a. if not in lowlist then remove
                b. else peek and iterate over it
            2. check corresponding element in map
                a. check if it has pipe - if yes split on pipe and generate random number
                b. if not then has regex for it then generate random string name
                c. if has '' then just append name directly
            3. if lowlevel
                a. check count
                    if count less than set count then iterate - solve using left queue and right stack
                    if count equals set count then remove and iterate using left queue and right stack

            4. for left queue - check for element in map and solve
            5. same for right queue
         */
        int topLevelCount = 3;





        while(topLevelCount!=0) {
            Generator.generateTopLevelQueue(topList,topQueue);

            while (!topQueue.isEmpty()) {
                String element = topQueue.peek();
                if (lowListElement.containsKey(element)) {
                    // check count and iterate
                    int lowElementCount = lowListElement.get(element);
                    while (lowElementCount != 0) {
                        String lowContent = topQueue.peek();

                        if (lowContent.equals("<expression>")) {
                          //  String resultFromExpression = Generator.evaluateExpression(lowList.get(0),grammarMap,regexMap);
                           // result.append(" " + resultFromExpression);
                          //  System.out.println("Result from expression-"+resultFromExpression);
                            result.append(" <expression>");
                        }


                        lowElementCount--;
                    }
                    topQueue.remove();


                } else {
                    // need to append to result
                    element = topQueue.remove();
                    if (grammarMap.containsKey(element)) {
                        String grammar = grammarMap.get(element);
                        if (grammar.contains("<") && grammar.contains(">")) {

                        } else {
                            if (grammar.contains("|")) {
                                String[] splittedGrammar = grammar.split("\\|");
                                String appender = Utilities.getRandomFromList(splittedGrammar);
                                result.append(appender);

                            }else if(element.equals("<abstract_methid>")){
                                result.append(" abstract method");
                            }
                        }

                    } else {
                        if (element.contains("<") && element.contains(">") && regexMap.containsKey(element)) {
                            result.append(" " + Utilities.getRandomString(regexMap.get(element), 0, 5));

                        } else if (element.contains("'")) {
                            result.append(" " + element.substring(1, element.length() - 1));
                        }
                    }
                }
            }

            System.out.println("String after queue processing-" + result);
            topLevelCount--;
            result.delete(0,result.length());
        }

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
