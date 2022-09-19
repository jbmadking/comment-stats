package com.ikhokha.techcheck;

public abstract class FileAnalyzer {
    public Report report;
    public void handle(Report report, String line){};
}
