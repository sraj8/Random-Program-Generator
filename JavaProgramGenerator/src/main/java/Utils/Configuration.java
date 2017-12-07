package Utils;

import java.util.List;

public class Configuration {
    private static int maxLinesOfCode, maxClasses, maxMethodCalls, maxMethodsInClass, maxInterfaces;
    private static int maxMethodsInInterface, maxInterfacesToImplement, maxIntValue, maxStringLength;
    private static int maxVariableNameLength;
    private static List<String> allowedTypes, accessModifiers;

    private Configuration(){};

    private static Configuration configuration = null;

    public static Configuration getInstance(){
        if(configuration==null){
            configuration = new Configuration();
        }
        return configuration;
    }

    public static int getMaxLinesOfCode() {
        return maxLinesOfCode;
    }

    public static void setMaxLinesOfCode(int maxLinesOfCode) {
        Configuration.maxLinesOfCode = maxLinesOfCode;
    }

    public static int getMaxClasses() {
        return maxClasses;
    }

    public static void setMaxClasses(int maxClasses) {
        Configuration.maxClasses = maxClasses;
    }

    public static int getMaxMethodCalls() {
        return maxMethodCalls;
    }

    public static void setMaxMethodCalls(int maxMethodCalls) {
        Configuration.maxMethodCalls = maxMethodCalls;
    }

    public static int getMaxMethodsInClass() {
        return maxMethodsInClass;
    }

    public static void setMaxMethodsInClass(int maxMethodsInClass) {
        Configuration.maxMethodsInClass = maxMethodsInClass;
    }

    public static int getMaxInterfaces() {
        return maxInterfaces;
    }

    public static void setMaxInterfaces(int maxInterfaces) {
        Configuration.maxInterfaces = maxInterfaces;
    }

    public static int getMaxMethodsInInterface() {
        return maxMethodsInInterface;
    }

    public static void setMaxMethodsInInterface(int maxMethodsInInterface) {
        Configuration.maxMethodsInInterface = maxMethodsInInterface;
    }

    public static int getMaxInterfacesToImplement() {
        return maxInterfacesToImplement;
    }

    public static void setMaxInterfacesToImplement(int maxInterfacesToImplement) {
        Configuration.maxInterfacesToImplement = maxInterfacesToImplement;
    }

    public static int getMaxIntValue() {
        return maxIntValue;
    }

    public static void setMaxIntValue(int maxIntValue) {
        Configuration.maxIntValue = maxIntValue;
    }

    public static int getMaxStringLength() {
        return maxStringLength;
    }

    public static void setMaxStringLength(int maxStringLength) {
        Configuration.maxStringLength = maxStringLength;
    }

    public static int getMaxVariableNameLength() {
        return maxVariableNameLength;
    }

    public static void setMaxVariableNameLength(int maxVariableNameLength) {
        Configuration.maxVariableNameLength = maxVariableNameLength;
    }

    public static List<String> getAllowedTypes() {
        return allowedTypes;
    }

    public static void setAllowedTypes(List<String> allowedTypes) {
        Configuration.allowedTypes = allowedTypes;
    }

    public static List<String> getAccessModifiers() {
        return accessModifiers;
    }

    public static void setAccessModifiers(List<String> accessModifiers) {
        Configuration.accessModifiers = accessModifiers;
    }
}
