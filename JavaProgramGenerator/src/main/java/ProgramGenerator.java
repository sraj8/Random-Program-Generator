import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProgramGenerator {

    static List<String> expressionList = new ArrayList<>();

    static  List<String> operatorList = new ArrayList<>();

    static List<String> terminalList = new ArrayList<>();

    static List<String> nonTerminalList = new ArrayList<>();

    static Queue<String> expressionGeneratorQueue = new LinkedList<String>() ;

    static StringBuffer result = new StringBuffer();


    public static void main(String[] args) {
        readGrammarFile();
        readTerminalNonTerminal();

        String initialExpression = expressionList.get(0);

        String initialExpressionBreak[] = (initialExpression.split(":="));

        //System.out.println("Initial Expression - "+initialExpressionBreak[0] +" "+initialExpressionBreak[1]+" "+initialExpressionBreak[2]);

        expressionGeneratorQueue.add(initialExpressionBreak[0].trim());
        expressionGeneratorQueue.add("=");
        initialExpressionBreak = initialExpressionBreak[1].split("\\|");
        expressionGeneratorQueue.add(initialExpressionBreak[0].trim());
        expressionGeneratorQueue.add(initialExpressionBreak[1].trim());
        expressionGeneratorQueue.add(initialExpressionBreak[2].trim());

        generateExpression();

        System.out.println(result.toString());
    }


    public static  void generateExpression(){

        while(!expressionGeneratorQueue.isEmpty()) {

            String currentTopExpression = expressionGeneratorQueue.remove().trim();


            if(terminalList.contains(currentTopExpression)){
                if (currentTopExpression.trim().equals("<op>")) {
                    String operators[] = operatorList.get(0).split(":=")[1].split("\\|");

                    //this number should also be generated randomly
                    result.append(operators[1]);

                }else if(currentTopExpression.trim().equals("<var>")){
                    //need to fix this- should be randomized
                    result.append("a");

                }else if(currentTopExpression.trim().equals("=")){
                    result.append("=");

                }

            }else{
                //recursive call will happen here - need to fix this
                if (currentTopExpression.trim().equals("<expression>")) {

                    String digits[] = expressionList.get(1).split(":=")[1].split("\\|");

                    //this number should be generated randomly
                    result.append(digits[2]);

                }

            }




        }

    }


    public static void readGrammarFile(){

        Scanner fileScan = getScanner("src/main/grammar.txt");

        while(fileScan.hasNext()){
            String grammar = fileScan.nextLine().toString();

            if(grammar.contains("<expression>")){
                expressionList.add(grammar);
            }else if(grammar.contains("<op>")){
                operatorList.add(grammar);
            }


        }
    }

    private static Scanner getScanner(String pathName) {
        File file = new File(pathName);
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return fileScan;
    }

    public static void readTerminalNonTerminal(){

        Scanner fileScan = getScanner("src/main/TerminalNonTerminal.txt");

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


    }
}
