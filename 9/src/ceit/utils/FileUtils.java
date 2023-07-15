package ceit.utils;

import ceit.model.Note;

import java.io.*;
import java.nio.file.Files;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    /**
     * reads the given file using buffered reader
     * @param file the file to be read
     * @return the content of the file
     */
    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        StringBuilder content=new StringBuilder();
        try (BufferedReader in=new BufferedReader(new FileReader(file)) ) {
            String line="";
            while((line=in.readLine())!=null){
                content.append(line);
            }
            System.out.println("successfully read the file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * writes the content to a file using Buffered writer
     * @param content the content which is going to be written to the file
     */
    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);
        File newFile=new File(NOTES_PATH+fileName+".txt");
        try(BufferedWriter out=new BufferedWriter(new FileWriter(newFile))){
            out.write(content);
            System.out.println("file written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read the given file using FileInputStream
     * @param file the file to be read
     * @return the content of the file
     */
    //TODO: Phase1: define method here for reading file with InputStream
    public static String inputStreamFileReader(File file){
        StringBuilder content=new StringBuilder();
        int i=0;
        try(FileInputStream in=new FileInputStream(file)) {
            while((i=in.read())!=-1){
                content.append((char)i);
            }
            System.out.println("successfully read the file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
        return content.toString();
    }

    /**
     * writes the given content to a file using FileOutputSteam
     * @param content the content which is going to be written to a file
     */
    //TODO: Phase1: define method here for writing file with OutputStream
    public static void outputStreamFileWriter(String content){
        String fileName=getProperFileName(content);
        File newFile=new File(NOTES_PATH + fileName);
        try(FileOutputStream out=new FileOutputStream(newFile)){
            byte[] contentInBytes=content.getBytes();
            out.write(contentInBytes);
            System.out.println("file written successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * saves the object of Note class to a file
     * @param noteToSave the note to be saved to a file
     */
    //TODO: Phase2: proper methods for handling serialization
    public static void serializeNote(Note noteToSave){
        String noteName=getProperNoteName(noteToSave);
        try(FileOutputStream outputStream=new FileOutputStream(NOTES_PATH+noteName)){
            ObjectOutputStream noteWriter=new ObjectOutputStream(outputStream);
            noteWriter.writeObject(noteToSave);
            noteWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads a object of Note class from a file
     * @param file the file to be read using ObjectInputStream
     * @return returns the note
     */
    public static Note deserializeNote(File file){
        Note loadedNote=null;
        try(FileInputStream inputStream=new FileInputStream(file)){
            ObjectInputStream noteReader=new ObjectInputStream(inputStream);
            loadedNote=(Note) noteReader.readObject();
            noteReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedNote;
    }

    /**
     * creates a proper name (the first line of content) based on the given content
     * @param content the content to be used to create proper name
     * @return the name of file
     */
    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }

    /**
     * creates a proper name for note based on the details of the note
     * @param note the note to be named
     * @return the proper name for the note
     */
    private static String getProperNoteName(Note note){
        String fileName="";
        fileName+=note.getTitle()+"_"+note.getDate()+".note";
        return fileName;
    }
}
