import java.util.Arrays;
import java.io.Console;

public class MyCli {
    public static void main(String[] args) {
        Console console = System.console();

        String username = console.readLine("Enter Username ");
        char[] password = console.readPassword("Enter Password ");
        Arrays.fill(password, ' ');

        console.printf("Welcome, %1$s.", username);
        console.printf(NEW_LINE);

        String className = console.readLine("Please enter a package class name:");
        Class<?> theClass = null;
        try {
            theClass = Class.forName(className);
            console.printf("class tree: %1$s", getInheritanceTree(theClass));
        }
        catch(ClassNotFoundException ex){
            console.printf("Cannot find that class.");
        }

        console.printf("Bye.");
    }

    private static final String NEW_LINE = System.getProperty("line.separator");

    private static String getInheritanceTree(Class<?> aClass) {
        StringBuilder superclasses = new StringBuilder();
        superclasses.append(NEW_LINE);
        Class<?> theClass = aClass;
        while (theClass != null) {
            superclasses.append(theClass);
            superclasses.append(NEW_LINE);
            theClass = theClass.getSuperclass();
        }
        superclasses.append(NEW_LINE);
        return superclasses.toString();
    }
}
