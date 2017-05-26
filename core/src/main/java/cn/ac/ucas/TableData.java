package cn.ac.ucas;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/25.
 * Output results, iteratable
 */
public class TableData implements Iterable<Row>{
    //schema
    private Schema schema;
    private long size;
    private List<Row> data;
    //todo init index to -1，list's element number limition, can change index's type int to long
    private int index;

    public Schema getSchema(){
        return schema;
    }

    public boolean setschema(Schema schema){
        this.schema = schema;
        return true;
    }


    @Override
    public Iterator<Row> iterator() {
        return new Iterator<Row>() {
            @Override
            public boolean hasNext() {
                index += 1;
                return index < size ;
            }

            @Override
            public Row next() {
                return data.get(index);
            }
        };
    }
}
