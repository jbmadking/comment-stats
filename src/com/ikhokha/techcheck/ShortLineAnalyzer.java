package com.ikhokha.techcheck;

public class ShortLineAnalyzer extends FileAnalyzer {

    public void handle(Report report, String line) {

        if (line.length() < 15) {

            report.addOccurrence( "SHORTER_THAN_15");
        }
    }
}
