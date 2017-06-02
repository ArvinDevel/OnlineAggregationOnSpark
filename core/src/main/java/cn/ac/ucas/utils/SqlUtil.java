package cn.ac.ucas.utils;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

/**
 *
 * Created by caihengyi on 02/06/2017.
 */
public class SqlUtil {

    public static boolean validSQL(String sql) {
        try {
            Statement stat = CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            return false;
        }
        return true;
    }

    public static boolean validSelectSQL(String sql) {
        try {
            Statement stat = CCJSqlParserUtil.parse(sql);
            if (stat instanceof Select) {
                return true;
            }
        } catch (JSQLParserException e) {
            return false;
        }
        return false;
    }
}
