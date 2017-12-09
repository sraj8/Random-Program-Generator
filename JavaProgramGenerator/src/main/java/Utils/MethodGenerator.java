package Utils;

import java.util.Map;

public class MethodGenerator {

    public static String generateMethodsforInterface(String code, Map<String,String> grammerMap, Map<String,String> regexMap){
        StringBuilder methodDefinition = new StringBuilder();
        String[] split = code.split(" ");
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
}
