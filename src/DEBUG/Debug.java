package DEBUG;

/**
 * Created by Ben on 31/01/2017.
 */
public class Debug {

    public static void printErr(String err){

        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String className = Thread.currentThread().getStackTrace()[2].getClassName();

        System.err.println("ERROR in " + className + " line:" + lineNumber +"\n"+
                err);


    }

}
