package de.softknk.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ReadGameData {
     /*
        data format:
            #0: nickname
            #1: score
            #2: pointOperation level
            #3: machineOperation level
            #4: excavatorOperation level
            #5: mineOperation level
            #6: factoryOperation level
     */

    public static Optional<List<String>> readData() {
        try {
            //if data.txt does not exist it will be created and filled with initial values
            if (!DataFile.dataFile().exists()) {
                Files.createFile(Paths.get(DataFile.dataFile().getPath()));
                initFile(DataFile.dataFile());
            }

            BufferedReader reader = new BufferedReader(new FileReader(DataFile.dataFile()));
            return Optional.of(reader.lines().collect(Collectors.toList()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static void initFile(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(DataFile.dataFile()));
        writer.write("softknk");
        writer.newLine();
        writer.write("0");
        writer.newLine();
        writer.write("1");

        for (int i = 0; i < 4; i++) {
            writer.newLine();
            writer.write("0");
        }

        file.setWritable(false);
        writer.close();
    }
}
