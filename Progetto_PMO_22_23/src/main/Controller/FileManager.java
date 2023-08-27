package main.Controller;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import com.opencsv.*;

public class FileManager {
    
    public static final String delimiter = ",";
    public FileReader fr;
    public BufferedReader br;
    public static FileWriter fw; 
    public static BufferedWriter bw;
    
    /**
     ** Descrizione: Legge tutto il file e lo mette in una lista di stringhe
     * @param path percorso del file
     */
    public static List<String[]> readFromFile(String path) throws IOException { 
        
        removeEmptyLines(path);

        CSVReader reader = new CSVReader(new FileReader(path), ',');

        List<String[]> myEntries = reader.readAll();

        reader.close();

        return myEntries;
    }

    /** 
    ** Descrizione: Cerca una riga nel file csv in base all'id 
    * @param path percorso del file
    * @param pos posizione della colonna in cui è contenuto l'id
    * @param id dell'oggetto da cercare
    */
    public static String[] searchById(String path, int pos, String id) throws IOException {
        

        List<String[]> myEntries = readFromFile(path);

        // filtra le righe che hanno l'id dell'oggetto da rimuovere
        Stream<String[]> filtered = myEntries.stream()
                        .filter(entry -> entry[pos].equals(id));

        String[] line = filtered.findFirst().get();

        return line;
    }

    /**
     ** Descrizione: scrive una riga nel file csv in base al
     * @param vehicle 
     * @param path percorso del file
     */
    public static boolean writeInFile(String path, String[] data) throws IOException{
    
        try {        
            // create a writer
            fw = new FileWriter(path, true);
            bw = new BufferedWriter(fw);
        
            // write all records
            if(!readFromFile(path).isEmpty())
                bw.newLine();
            bw.write(String.join(delimiter, data));

            //close the writer
            bw.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     ** Descrizione: Modifica una riga nel file csv in base all'id
     *
     * @param path -> percorso del file
     * @param row -> posizione della riga in cui è contenuto l'id
     * @param replace -> stringa da sostituire
     * @param col -> posizione della colonna in cui è contenuto l'id
     * 
     * @throws IOException
     */

    public static void modifyRow(String path, int row, String replace, int col) throws IOException
    {

        if(row == -1)
            throw new IllegalArgumentException();

        List<String[]> myEntries = readFromFile(path);

        myEntries.get(row)[col] = replace;
        
        CSVWriter writer = new CSVWriter(new FileWriter(path), ',');

        writer.writeAll(myEntries);
        writer.flush();
        writer.close();
    }

    /**
     ** Descrizione: Rimuove una riga dal file csv in base all'id
     * @param id dell'oggetto da rimuovere
     * @param path percorso del file
     * @param pos posizione della colonna in cui è contenuto l'id
     */
    public static void removeFromFile(String path, int pos, String id) throws IOException{

        List<String[]> myEntries = readFromFile(path);

        // filtra le righe che hanno l' id dell'oggetto da rimuovere
        Stream<String[]> filtered = myEntries.stream()
                        .filter(entry -> !entry[pos].equals(id));

        FileWriter fw = new FileWriter(path);
        CSVWriter w = new CSVWriter(fw);

        // sovrascrive le righe filtrate
        filtered.forEach(line -> w.writeNext(line));

        w.close();
    }

    public static void removeEmptyLines(String path) throws IOException{

        CSVReader reader = new CSVReader(new FileReader(path));

        List<String[]> myEntries = reader.readAll();
        List<String[]> emptyRemoved = new ArrayList<String[]>();

        if(!myEntries.isEmpty()){
            for(String[] line : myEntries){
                if(isNonEmptyLine(line)){
                    emptyRemoved.add(line);
                } 
            }

            CSVWriter write = new CSVWriter(new FileWriter(path));
            write.writeAll(emptyRemoved);

            write.flush();
            write.close();
        }

        
        reader.close();

    }

    public static void modifyByWord(String path, int idColumn, String id, int column, String targetWord, String replacement) throws IOException {

        List<String[]> modifiedLines = new ArrayList<>();
        Map<String, List<String[]>> idToLines = new HashMap<>();

        CSVReader reader = new CSVReader(new FileReader(path));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine.length > idColumn) {
                String currentId = nextLine[idColumn];

                // Check if the current line's ID matches the requested ID
                if (currentId.equals(id)) {
                    nextLine[column] = nextLine[column].replace(targetWord, replacement);
                }

                // Store all lines with the same ID in a map
                idToLines.computeIfAbsent(currentId, k -> new ArrayList<>()).add(nextLine);
            }
        }

        reader.close();

        // Modify all lines with the same ID in the list
        for (List<String[]> lines : idToLines.values()) {
            modifiedLines.addAll(lines);
        }

        CSVWriter writer = new CSVWriter(new FileWriter(path));
        writer.writeAll(modifiedLines);

        writer.flush();
        writer.close();

    }

    public static void modifyAll(String path, int idColumn, String id, int column, String replacement) throws IOException{

        List<String[]> modifiedLines = new ArrayList<>();
        Map<String, List<String[]>> idToLines = new HashMap<>();

        CSVReader reader = new CSVReader(new FileReader(path));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine.length > idColumn) {
                String currentId = nextLine[idColumn];

                // Check if the current line's ID matches the requested ID
                if (currentId.equals(id)) {
                    // Replace the entire content of the specified column
                    nextLine[column] = replacement;
                }

                // Store all lines with the same ID in a map
                idToLines.computeIfAbsent(currentId, k -> new ArrayList<>()).add(nextLine);
            }
        }

        reader.close();

        // Modify all lines with the same ID in the list
        for (List<String[]> lines : idToLines.values()) {
            modifiedLines.addAll(lines);
        }

        CSVWriter writer = new CSVWriter(new FileWriter(path));
        writer.writeAll(modifiedLines);

        writer.flush();
        writer.close();
    }

    /**
     ** Descrizione: Controlla se una riga è vuota
     * @param line riga da controllare
     */
    private static boolean isNonEmptyLine(String[] line) {
        for (String cell : line) {
            if (!cell.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
