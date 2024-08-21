package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments(){}

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeywordValidator.class
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Every search can include a location"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "The API returns 50 items, use a page number"
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"},
            description = "Added if we want full time jobs"
    )
    private  boolean isFullTime = false;

    @Parameter(
            names = {"--markdown"},
            description = "Get results in Markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = {"--help"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show help"
    )
    private  boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public  static  CLIArguments newInstance(){
        return new CLIArguments();
    }
}
