package com.bonify.bankdemo.parser;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Class which is used to parse CSV files.
 */
public class CsvParser {

    /**
     * Parse a csv file named banks under the resource folder.
     * @return List containing details of all banks specified in the csv file.
     */

    public List<String> parseCsvFile() {

        String line;
        List<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new ClassPathResource("banks.csv").getFile()))) {

            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}
