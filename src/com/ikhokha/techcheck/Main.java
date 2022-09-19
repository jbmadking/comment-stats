package com.ikhokha.techcheck;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FileAnalyzer[] statsAnalyzers = {
                new ShortLineAnalyzer(),
                new MoverProductAnalyzer(),
                new ShakerProductAnalyzer(),
                new QuestionAnalyzer(),
                new SpamAnalyzer()
        };

        File docPath = new File("docs");
        File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(".txt"));

        ExecutorService analysisExecutor = Executors.newFixedThreadPool(4);
        ExecutorService reportExecutor = Executors.newFixedThreadPool(2);

        if (commentFiles != null) {

            Report report = new Report();

            for (File commentFile : commentFiles) {

                CommentAnalyzer commentAnalyzer = new CommentAnalyzer(commentFile, report, statsAnalyzers);

                // analysisExecutor.execute(commentAnalyzer);
                commentAnalyzer.start();
                commentAnalyzer.join();
            }

            ResultsPrinter resultsPrinter = new ResultsPrinter(report);
            resultsPrinter.printResults();
        }
    }
}
