package com.ikhokha.techcheck;

public class QuestionAnalyzer extends FileAnalyzer {
    public void handle(Report report, String line) {

        if (line.contains("?")) {

            report.addOccurrence("QUESTIONS");
        }
    }
}
