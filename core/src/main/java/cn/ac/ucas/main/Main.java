package cn.ac.ucas.main;

import cn.ac.ucas.basics.ArgPair;
import cn.ac.ucas.utils.CliUtil;
import jline.console.ConsoleReader;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

import static cn.ac.ucas.utils.CliUtil.parseArgs;
import static cn.ac.ucas.utils.CliUtil.printHelp;

/**
 * Main driver of online aggregation.
 * Created by caihengyi on 02/06/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String linePrompt = "ucas-online-aggregation>";
        ConsoleReader reader = new ConsoleReader();
        String line;
        reader.setCommentBegin("#");

        do {
            line = reader.readLine(linePrompt);
            if (line != null) {
                exec(line);
            }
        }
        while (line != null);
    }

    private static void exec(String cmd) {
        ArgPair argPair = parseArgs(cmd);
        switch (argPair.getArgType()){
            case HELP:
                printHelp();
                break;
            case SQL:
                // TODO:

                break;
            case IMPORT:
                Matcher matcher = CliUtil.importCommandPattern.matcher(argPair.getArgContent());
                String filePath = "";
                String tableName = "";
                while (matcher.find()) {
                    filePath = matcher.group(1);
                    tableName = matcher.group(2);
                }
                File f = new File(filePath);
                if(f.exists() && !f.isDirectory()) {
                    // TODO:

                    System.out.println(filePath + " is loading into the system...");
                }else{
                    System.out.println(filePath + " is not a valid file!");
                }
                break;
            case EXIST:
                System.exit(0);
                break;
        }
    }

}
