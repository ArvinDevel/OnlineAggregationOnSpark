package cn.ac.ucas.basics;

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
    //todo list's element number limition, can change index's type int to long
    private int index;

    //init index to -1，
    public TableData(){
     index = -1;
    }

    public void setschema(Schema schema){
        this.schema = schema;
    }

    public Schema getSchema(){
        return schema;
    }

    public void setSize(long size){
        this.size = size;
    }
    public long getSize(){
        return size;
    }

    public void setData(List<Row> data){
        this.data = data;
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
