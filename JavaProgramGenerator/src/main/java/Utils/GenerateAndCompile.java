package Utils;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GenerateAndCompile {

    public static void generateAndCompileJavaFile(List<String> javaCode){
        for(String source : javaCode) {
            File sourceFile = null;
            String classSearch = "public class";
            String interfaceSearch = "public interface";
            String str = "";
            try {
                if(source.contains(classSearch)) {
                    str= source.substring(source.indexOf(classSearch)+classSearch.length(),source.indexOf("{"));
                }else if(source.contains(interfaceSearch)) {
                    str= source.substring(source.indexOf(interfaceSearch)+interfaceSearch.length(),source.indexOf("{"));
                }
                File sourceDir = new File("./generatedCode/");
                if(!sourceDir.exists()){
                    sourceDir.mkdir();
                }
                sourceFile = new File(sourceDir+"/"+str.trim()+".java");
                String[] sourceCode = source.split("\n");
                // write the source code into the source file
                FileWriter writer = null;
                writer = new FileWriter(sourceFile);
                for(String sc:sourceCode){
                    writer.append(sc);
                }
                writer.close();
                // compile the source file
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
                File parentDirectory = sourceFile.getParentFile();
                fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(parentDirectory));
                Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile));
                compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
                fileManager.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
