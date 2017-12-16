import Utils.Utilities;
import org.junit.Before;
import org.junit.Test;

public class ProgramGeneratorTest {

    ProgramGenerator programGenerator;


    @Before
    public void setUp() throws Exception {
        //topQueue grammarMap and lowList
        programGenerator = new ProgramGenerator();
        ProgramGenerator.initializeAllDataHolders();
        ProgramGenerator.topList.add("<access_modifier> 'class' <class_name> '{' <expression> '}'");
        ProgramGenerator.topList.add("<access_modifier> 'interface' <interface> '{' <abstract_method> '}'");
        ProgramGenerator.grammarMap.put("<access_modifier>","public|private");
        ProgramGenerator.lowList.add("<access_type> <var> = <exp> <op> <exp>");
        ProgramGenerator.lowListElement.put("<expression>",3);
        ProgramGenerator.regexMap.put("<class_name>","[A-Z]+[a-zA-Z]+");
    }


    @Test
    public void queueProcessingTest() throws Exception {

        ProgramGenerator.queueProcessing(Utilities.parseConfigFile("resources\\config.xml"));
    }
}