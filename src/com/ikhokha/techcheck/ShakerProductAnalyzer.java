package com.ikhokha.techcheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ShakerProductAnalyzer extends FileAnalyzer {

    public void handle(Report report, String line) {

        Pattern pattern = Pattern.compile("\\bshaker\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            report.addOccurrence("SHAKER_MENTIONS");
        }
    }
}
