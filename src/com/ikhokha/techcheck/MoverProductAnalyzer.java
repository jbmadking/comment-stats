package com.ikhokha.techcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoverProductAnalyzer extends FileAnalyzer {

    public void handle(Report report, String line) {

        Pattern pattern = Pattern.compile("\\bmover\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            report.addOccurrence( "MOVER_MENTIONS");
        }
    }
}
