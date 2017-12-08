import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class ProgramGeneratorTest {

    ProgramGenerator programGenerator;


    @Before
    public void setUp() throws Exception {
        //topQueue grammarMap and lowList
        programGenerator = new ProgramGenerator();
        ProgramGenerator.topQueue.add("<access_modifier>");
        ProgramGenerator.topQueue.add("'class'");
        ProgramGenerator.topQueue.add("<class_name>");
        ProgramGenerator.topQueue.add("'{'");
        ProgramGenerator.topQueue.add("<expression>");
        ProgramGenerator.topQueue.add("'}'");
        ProgramGenerator.grammarMap.put("<access_modifier>","public|private");
        ProgramGenerator.lowList.add("<access_type> <var> = <exp> <op> <exp>");
        ProgramGenerator.lowListElement.put("<expression>",3);
        ProgramGenerator.regexMap.put("<class_name>","[A-Z]+[a-zA-Z]+");
    }


    @Test
    public void queueProcessingTest() throws Exception {

        ProgramGenerator.queueProcessing();
    }
}