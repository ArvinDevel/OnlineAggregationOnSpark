package cn.ac.ucas.api;

import cn.ac.ucas.operator.Operator;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.log4j.Logger;

/**
 * Created by caihengyi on 28/05/2017.
 */
public class SqlPreexec {
    private final static Logger logger = Logger.getLogger(SqlPreexec.class);

    private String sql;

    public SqlPreexec(String sql) {
        this.sql = sql;
    }

    private boolean validation(){
        try {
            Statement stat = CCJSqlParserUtil.parse(this.sql);
            if(stat instanceof Select){
                return true;
            }else{
                logger.error("Only support SELECT!");
            }
        } catch (JSQLParserException e) {
            e.printStackTrace();
            logger.error("Sql invalid!");
            return false;
        }
        return false;
    }

    public Operator parse(){
        if(validation()) {

            return null;
        }
        return null;
    }

}
