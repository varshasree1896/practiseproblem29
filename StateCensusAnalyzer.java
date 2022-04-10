package com.blz.indiancensusanalyzer;

import com.openCSV.CSVReader;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Indian State Census Analyzer Problem
 */
public class StateCensusAnalyzer {
    public static int readCensusFile(String filePath) throws StateCensusException {
        int count = 0;
        try {
            if (!filePath.contains(".csv")) {
                throw new StateCensusException("Invalid File Format");
            } else {
                Reader read = Files.newBufferedReader(Paths.get(filePath));
                CSVReader obj = new CSVReader(read);
                String line = ((BufferedReader) read).readLine();
                String[] header = line.split(",");
                System.out.println(Arrays.toString(header));

                List<String[]> readcsv = obj.readAll();

                for (String[] nextRecord : readcsv) {
                    // System.out.println(Arrays.toString(nextRecord));
                }
                return readcsv.size();
            }

        } catch (IOException | StateCensusException e) {
            throw new StateCensusException(e.getMessage());
        }

    }

    public boolean readHeader(String filePath, String[] headerCheck) throws StateCensusException {
        try {
            if (!filePath.contains(".csv")) {
                throw new StateCensusException("Invalid File Format");
            } else {
                Reader read = Files.newBufferedReader(Paths.get(filePath));
                CSVReader obj = new CSVReader(read);
                String line = ((BufferedReader) read).readLine();
                String[] header = line.split(",");

                if (Arrays.equals(headerCheck, header) == true) {
                    System.out.println("hurrrayyy");
                    return true;
                } else return false;

            }
        } catch (IOException | StateCensusException e) {
            throw new StateCensusException(e.getMessage());
        }
    }
}