package services.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final Gson GSON;

    public FileHandler() {
        this.GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveToFile(String filePath, List<?> data) {
        try {
            Writer writer = new FileWriter(filePath);
            GSON.toJson(data, writer);
            writer.flush();
            writer.close();

        } catch (IOException ioException) {
            System.out.println("Can't write to file");
            System.out.println(ioException.getMessage());
        }
    }
    public ArrayList<?> readFromFile(String filepath, Type type) {
        try {
            Reader reader = new FileReader(filepath);
            return GSON.fromJson(reader, type);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Can't read file");
            System.out.println(fileNotFoundException.getMessage());
            return null;
        }
    }
}
