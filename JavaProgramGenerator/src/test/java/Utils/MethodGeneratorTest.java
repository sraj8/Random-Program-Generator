package Utils;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MethodGeneratorTest {

    String grammer = "<access_return_type> <method_name> '(' ')' ';'";
    Map<String,String> grammarMap;
    Map<String,String> regexMap;

    @Before
    public void setUp(){
        grammarMap = new HashMap<>();
        grammarMap.put("<access_return_type>","void|int|float");
        regexMap = new HashMap<>();
        regexMap.put("<method_name>","[a-zA-Z]+");
    }

    @Test
    public void testGenerateMethodsForInterface(){
        String output = MethodGenerator.generateMethodsforInterface(grammer,grammarMap,regexMap);
        System.out.println(output);
    }
}
