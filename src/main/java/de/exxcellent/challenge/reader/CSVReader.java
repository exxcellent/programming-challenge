package de.exxcellent.challenge.reader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.exxcellent.challenge.App;

public class CSVReader implements FileReader {
    @Override
    public String[][] readFile(String filePath) {
        String[][] data = null;

        try {
            // Get the resource file using ClassLoader
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            if (inputStream != null) {
                // Read the file
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                ArrayList<String[]> lines = new ArrayList<>();
                String line;

                line = bufferedReader.readLine(); // Ignore the first line

                while ((line = bufferedReader.readLine()) != null) {
                    // Process each line of the CSV file
                    String[] rowData = line.split(",");
                    lines.add(rowData);

                    if (data == null) {
                        data = new String[rowData.length][];
                    }
                    
                    data = lines.toArray(new String[0][0]);
                }

                // Close the resources
                bufferedReader.close();

                } else {
                    System.out.println("File not found!");
                }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
