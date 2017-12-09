package Utils;

import java.util.List;
import java.util.Map;

public class MethodGenerator {

    public static String generateMethodsforInterface(String grammer, Map<String,String> grammerMap, Map<String,String> regexMap){
        StringBuilder methodDefinition = new StringBuilder();
        String[] split = grammer.split(" ");
        for(int i=0;i<split.length;i++){
            if(split[i].charAt(0) == '<'){
                if(grammerMap.containsKey(split[i])){
                    String value = grammerMap.get(split[i]);
                    String[] valueArray = value.split("[|]");
                    String modifier = Utilities.getRandomFromList(valueArray);
                    methodDefinition.append(modifier+" ");
                }else if(regexMap.containsKey(split[i])){
                    String regex = regexMap.get(split[i]);
                    String name = Utilities.getRandomString(regex,3,8);
                    methodDefinition.append(name);
                }
            }else if(split[i].charAt(0)=='\''){
                methodDefinition.append(split[i].replaceAll("'",""));
            }
        }

        return methodDefinition.toString();
    }

    public static String generateMethodsforClass(String grammer, Map<String,String> grammerMap, Map<String,String> regexMap, List<String> lowList){
        StringBuilder methodDeclaration = new StringBuilder();
        String[] split = grammer.split(" ");
        for(int i=0;i<split.length;i++){
            if(split[i].contains("access_modifier")){
                String value = grammerMap.get(split[i]);
                String[] valueArray = value.split("[|]");
                String modifier = Utilities.getRandomFromList(valueArray);
                methodDeclaration.append(modifier+" ");
            }else if(split[i].contains("method_name")){
                String regex = regexMap.get(split[i]);
                String name = Utilities.getRandomString(regex,3,8);
                methodDeclaration.append(name+" ");
            }else if(split[i].contains("<expression>")){

                methodDeclaration.append(" "+Generator.evaluateExpression(lowList.get(0),grammerMap,regexMap));

            }else if(split[i].charAt(0)=='\''){
                methodDeclaration.append(split[i].replaceAll("'","")+" ");
            }

        }
        methodDeclaration.append("\n");

        return methodDeclaration.toString();

    }
}
