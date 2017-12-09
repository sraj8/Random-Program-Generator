package Utils;

import org.junit.Test;

import java.util.*;

import static Utils.LoopGenerator.loopEvaluator;
import static org.junit.Assert.assertNotNull;

public class LoopGeneratorTest
{
    @Test
    public void testloopgenerator(){
        String loopExpression = setStaticContent();
        Map regexMap = new HashMap<>();
        regexMap.put("<var>","[a-z]+");
        regexMap.put("<digit>","[0-9]");
        String result = loopEvaluator(loopExpression, regexMap);
        assertNotNull(result);
        System.out.println(result);
    }

    private String setStaticContent(){
        return "'for' '(' 'int' <var> ' '=' '0' ;' <var_prev> '<=' <digit> ';' <var_prev> '++' ')' '{' <expression> '}'";
    }


}
