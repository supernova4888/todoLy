package todolistmaster;

import java.io.*;
import java.util.ArrayList;
import java.io.File;

/***
This is where all the transactions with the file will occur: open, read, write, save and close.
 There should also be a counter of 'open' and 'closed' tasks which should return a status to display (not sure if this should
 be here or somewhere else)
 The aim is to save as Object in a txt file*/

public class FileHandler {


    // fields
    // Using txt file and absolute path

    private String path = "/Users/dbao/Documents/todoLy/app/src/main/java/todolistmaster/";


//TODO not tested yet, just pseudocode

    public void writeAsObject(ArrayList<Task> list)
    {
        try {
            // FileOutputStream writes stream of raw bytes. And requires the construction of the OutputStreamWriter
            FileOutputStream fileStream = new FileOutputStream(path +"todofile.txt");
            ObjectOutputStream writer = new ObjectOutputStream(fileStream);

            // writes objects to writer stream
            writer.writeObject(list); //list

            writer.close();
            fileStream.close();

        }
        catch(IOException e)
        {
            System.out.println("File not found" + e);
        }
    }

    // might not need this one
    public void openFile() {

    }

    // when i read i open and close, so i might not need this one
    public void saveFile(){

    }

// read file as Data
    /*public void readAsObject()
    {

        ArrayList<Task> list = new ArrayList<>();

        try
        {
            FileReader fileReader = new FileReader(new File(path+"todofile.txt"));
            BufferedReader br = new BufferedReader(fileReader);

            String line = "";
            String[] data;
            while ((line = br.readLine()) != null);
            {
                data = line.split("XX");
                Task a = new Task(data[0],data[1], Integer.parseInt(data[2], data[3]);
                list.add(a);
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File is not found " + e);
        }
        return list;
    }*/


}
