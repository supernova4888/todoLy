package todolistmaster;
import java.io.*;
import java.util.ArrayList;

/***
This is where all the transactions with the file will occur: open, read, write, save and close.
 There should also be a counter of 'open' and 'closed' tasks which should return a status to display (not sure if this should
 be here or somewhere else)
 The aim is to save as Object in a txt file*/

public class FileHandler implements Serializable {


    // fields
    // Using txt file and absolute path

    private static final String path = "app/src/main/resources/";


//TODO to be tested - check the unchecked cast

    public void writeAsObject(ArrayList<Task> list)
    {
        try {
            // FileOutputStream writes stream of raw bytes. And requires the construction of the OutputStreamWriter
            FileOutputStream fileStreamOne = new FileOutputStream(path +"objectFile.txt");
            ObjectOutputStream writer = new ObjectOutputStream(fileStreamOne);

            // writes objects to writer stream
            writer.writeObject(list);

            writer.close();
            fileStreamOne.close();

        }
        catch(IOException e)
        {
            System.out.println("File not found" + e);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Task> readAsObject() {

        ArrayList<Task> list = new ArrayList<>();

        try {
            // FileOutputStream writes stream of raw bytes. And requires the construction of the OutputStreamWriter
            FileInputStream fileStreamTwo = new FileInputStream(path +"objectFile.txt");
            ObjectInputStream reader = new ObjectInputStream(fileStreamTwo);

            // reads objects to writer stream
            list = (ArrayList<Task>) reader.readObject();
            System.out.println("The file is opened and read");

            System.out.println(list);


            reader.close();
            fileStreamTwo.close();

            }
            catch(IOException e)
            {
                System.out.println("File not found" + e);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Problem with reading the content of the file");
            }
        return list;

    }
}
