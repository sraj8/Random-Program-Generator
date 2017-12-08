package Utils;

import org.junit.Test;

import static Utils.Generator.generateTopLevelQueue;
import static org.junit.Assert.*;

import java.util.*;

public class Generator_Test {

    @Test
    public void testgenerateTopLevelQueue(){
        List<String>  topList;
        topList = addStaticGrammar();
        Queue<String> testQueue = new LinkedList<>();
        generateTopLevelQueue(topList,testQueue);
        assertNotNull(testQueue);
        for(String val : testQueue)
            System.out.println(val);
    }

    private List<String> addStaticGrammar(){
        List<String>  grammarList = new ArrayList<>();
        grammarList.add("<access_modifier> 'class' <class_name> '{' <expression> '}'");
        grammarList.add("<access_modifier> 'class' <class_name> '{' <expression> '}'");
        return grammarList;
    }
}
