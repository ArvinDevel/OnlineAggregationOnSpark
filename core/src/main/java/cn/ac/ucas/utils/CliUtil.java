package cn.ac.ucas.utils;

import cn.ac.ucas.basics.ArgPair;

import java.util.regex.Pattern;

/**
 * Util function for command line arguments.
 * Created by caihengyi on 02/06/2017.
 */
public class CliUtil {
    public static Pattern importCommandPattern = Pattern.compile("import\\s+(\\S+)\\s+as\\s+(\\S+)");

    private final static String HELP_COMMAND = "help:";
    private final static String HELP_MSG = "Show this message.";
    private final static String EXIST_COMMAND = "exist:";
    private final static String EXIST_MSG = "Exist.";
    private final static String IMPORT_COMMAND = "import <data_file> as <table>:";
    private final static String IMPORT_MSG = "Import your data(csv or json) to system.";

    private final static String SQL_COMMAND = "<AGGREGATION SQL COMMAND>:";
    private final static String SQL_MSG = "A SQL command to execute aggregation, e.g.\"select avg(field1) from table_name group by field2\"";

    public enum ArgsError {
        INVALID_COMMAND("Invalid Command!"),
        OK("OK!"),
        UNKNOWN("Unknown Error!");

        private String s;

        ArgsError(String s) {
            this.s = s;
        }

        public String s() {
            return s;
        }
    }

    public enum ArgsType{
        HELP("help"),
        IMPORT("import data as table"),
        SQL("sql statement"),
        EXIST("exist");
        private String s;

        ArgsType(String s) {
            this.s = s;
        }

        public String s() {
            return s;
        }
    }

    public static void printHelp() {
        System.out.println("Accept commands: ");
        String format = "\t%-30s\t%s%n";
        System.out.printf(format, HELP_COMMAND, HELP_MSG);
        System.out.printf(format, IMPORT_COMMAND, IMPORT_MSG);
        System.out.printf(format, SQL_COMMAND, SQL_MSG);
        System.out.printf(format, EXIST_COMMAND, EXIST_MSG);
    }

    private static ArgsError checkArgs(String line) {
        if (!line.trim().toLowerCase().equals("help")
                && !importCommandPattern.matcher(line).matches()
                && !SqlUtil.validSQL(line)
                && !line.trim().toLowerCase().equals("exist")) {
            return ArgsError.INVALID_COMMAND;
        }
        return ArgsError.OK;
    }

    public static ArgPair parseArgs(String line) {
        ArgPair argPair = new ArgPair(ArgsType.HELP,"help");
        if (checkArgs(line) != CliUtil.ArgsError.OK) {
            return argPair;
        } else {
            if(importCommandPattern.matcher(line).matches()){
                return new ArgPair(ArgsType.IMPORT, line);
            }else if(SqlUtil.validSQL(line)){
                return new ArgPair(ArgsType.SQL,line);
            }else if(line.trim().toLowerCase().equals("exist")){
                return new ArgPair(ArgsType.EXIST,"exist");
            }else{
                return argPair;
            }
        }
    }
}
