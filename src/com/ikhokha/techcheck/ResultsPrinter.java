package com.ikhokha.techcheck;

import java.util.Map;

public class ResultsPrinter {

    private Report report;

    public ResultsPrinter(Report report) {

        this.report = report;
    }

    public void printResults() {
        System.out.println("RESULTS\n=======");

        if (this.report.countMap != null) {
            this.report.countMap.forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }
}
