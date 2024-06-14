

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextAreaToFile {
    private List<String> lines = new ArrayList<>();

    public void addLine(String line) {

        lines.add(line);
        saveToFile("output.txt");
    }

    public void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(lines.getLast());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}