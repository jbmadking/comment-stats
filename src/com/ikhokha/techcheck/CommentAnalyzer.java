package com.ikhokha.techcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommentAnalyzer extends Thread {

    private File file;
    public Report report;
    private FileAnalyzer[] analyzers;

    public CommentAnalyzer(
            File file,
            Report report,
            FileAnalyzer[] analyzers
    ) {
        this.file = file;
        this.report = report;
        this.analyzers = analyzers;
    }

    public Map<String, Integer> analyze() {

        Map<String, Integer> resultsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            try {

                while ((line = reader.readLine()) != null) {
                    for (FileAnalyzer analyzer : this.analyzers) {
                        analyzer.handle(this.report, line);
                    }
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Error processing file: " + file.getAbsolutePath());
            e.printStackTrace();
        }

        return resultsMap;
    }

    @Override
    public void run() {
        // System.out.println("Analyzer - #" + Thread.currentThread().getId());
        this.analyze();
//        System.out.println(this.report.countMap);
    }
}
