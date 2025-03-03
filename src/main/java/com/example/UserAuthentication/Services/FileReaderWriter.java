package com.example.UserAuthentication.Services;

import com.example.UserAuthentication.Entity.User;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReaderWriter {

    public static void writeToCSVFile(List<User> users)  {

        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("users.csv"));

            String[] parametersOfCSVFile = new String[]{"id", "userName", "password", "balance"};
            csvWriter.writeNext(parametersOfCSVFile);

            users.forEach(user -> csvWriter.writeNext(user.toArray()));
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> readCSVFile() {
        final String csvFile = "C:\\Users\\admin\\IdeaProjects\\UserAuthentication\\users.csv";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(csvFile))) {

            return reader.lines()
                    .skip(1)
                    .map(FileReaderWriter::fromCSV)
                    .collect(Collectors.toList()); // not same .toList - cause immutable collection;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User fromCSV(String line) {

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        try {
            String[] fields = csvParser.parseLine(line);

            return new User(
                    fields[0].trim(),
                    fields[1].trim(),
                    fields[2].trim(),
                    Double.parseDouble(fields[3].trim())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
