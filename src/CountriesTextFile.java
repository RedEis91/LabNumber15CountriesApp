import java.io.*;

/**
 * Created by Jared on 7/26/17.
 */
public class CountriesTextFile {
    File myFile = new File("countries.txt");
    public static void writeToFile(Object input, File myFile) {
        //tank to hold file;
        //any error the program can't handle at runtime is known as an Exception
        //PrintWriter class has method built in to say: "Hey, I know you're going to be looking for a file"
        //In case you don't have access to that file, for whatever reason...
        //surround your print-writer with a try/catch to catch the exception
        try {
            //pipe  to stream file into tank             //pump, which by default deletes data from file
            PrintWriter p = new PrintWriter(new FileOutputStream(myFile, true));
            //            p.println("First line!!! Wohooo!");
            p.println(input);//save user input to the file
            p.close();
            //need to handle the FileNotFoundException
        } catch (IOException e) {
            System.out.println("File not found!!!!");
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static void readFromFile(File myFile) {
        //FileReader always needs to be wrapped in Try/Catch.
        try {
            // to use buffered reader, you have to instantiate a reader first
            FileReader reader = new FileReader(myFile);
            //BufferedReader (more specific file reader) has method called readLine() to read data stream line by line
            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();
            //ensure the line being fed into bufReader isn't null
            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine(); // read the next line
            }
            bufReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
    }
}
