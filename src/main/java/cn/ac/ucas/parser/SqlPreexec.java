package cn.ac.ucas.parser;

import cn.ac.ucas.operator.Operator;
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

    public Operator parse(){
        return null;
    }

}
