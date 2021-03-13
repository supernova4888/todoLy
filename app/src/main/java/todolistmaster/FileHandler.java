package todolistmaster;

import java.io.*;
import java.time.LocalDate;
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

    private String path = "app/src/main/resources/";


//TODO not tested yet, just pseudocode

    public void writeAsObject(ArrayList<Task> list)
    {
        try {
            // FileOutputStream writes stream of raw bytes. And requires the construction of the OutputStreamWriter
            FileOutputStream fileStream = new FileOutputStream(new File(path +"objectFile.txt"));
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
    public ArrayList<Task> readAsObject()
    {
        ArrayList<Task> list = new ArrayList<>();
        try {
            // FileOutputStream writes stream of raw bytes. And requires the construction of the OutputStreamWriter
            FileInputStream fileStream = new FileInputStream(new File(path +"objectFile.txt"));
            ObjectInputStream reader = new ObjectInputStream(fileStream);

            // writes objects to writer stream
            list = (ArrayList<Task>) reader.readObject();
            reader.close();
            fileStream.close();

        }
        catch(IOException e)
        {
            System.out.println("File not found" + e);
        }
        catch ( ClassNotFoundException e)
        {
            System.out.println("problem with reading the content of the file");
        }
        return list;

    }







    // when i read i open and close, so i might not need this one
    public void writeAsData(ArrayList<Task> list)
    {
        try
        {
            File file = new File(path+"dataFile.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fileWriter);

            for (Task task : list) {
                br.write(task.toString() + "\n");
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File is not found " + e.toString());
        }
    }

// read file as Data
    public ArrayList<Task> readAsData()
    {
        ArrayList<Task> list = new ArrayList<>();

        try
        {
            FileReader fileReader = new FileReader(new File(path+"dataFile.txt"));
            BufferedReader br = new BufferedReader(fileReader);

            //Title: t1, Project: brother, Due date: 2021-03-13, Status: false
            String line = "";
            String[] data;
            while ((line = br.readLine()) != null)
            {
                data = line.split(",");
                String title = data[0].substring("Title: ".length()); // Title: t1
                String project = data[1].substring(" Project: ".length());
                LocalDate localDate = LocalDate.now(); //date[2] // " Due date: "
                boolean status = Boolean.parseBoolean(data[3].substring(" Status: ".length()));

                Task a = new Task(title, localDate, project);
                a.setStatus(status);
                list.add(a);
            }

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File is not found " + e);
        }
        return list;
    }


}
