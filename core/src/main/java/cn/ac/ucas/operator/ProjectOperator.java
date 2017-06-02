package cn.ac.ucas.operator;

import cn.ac.ucas.basics.DataType;
import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.Schema;
import cn.ac.ucas.basics.TableData;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/28.
 */
public class ProjectOperator extends Operator {

    @Override
    public TableData compute() {
        return null;
    }
}
class MockProjectOperator extends Operator {

    private String outFields[];
    private int indexs[];

    //todo record output Fields' type and name carefully in ProjectOperator
    public MockProjectOperator(String[] outFields){
        this.outFields = outFields;
        indexs = new int[outFields.length];
        this.setOutputSize(outFields.length);




    }

    @Override
    public TableData compute() throws Exception{
        Operator child = getChildren().get(0);
        if(child == null){
            throw(new Exception("Child doesn't exist"));
        }

        TableData previous = child.compute();
        TableData data = new TableData();
        List<Row> rowList = new ArrayList<Row>();

        String[] inFields = previous.getSchema().getNames();


        for(int i = 0; i < outFields.length; i++){
            for(int j = 0; j < inFields.length; j++)
                if(inFields[j] == outFields[i])
                    indexs[i] = j;

        }
        Schema schema = new Schema();
        String[] names = outFields;
        DataType[] types = new DataType[outFields.length];
        for(int i = 0; i < outFields.length; i++){
            types[i] = previous.getSchema().getValues()[indexs[i]];
        }


        Iterator<Row> iterator = previous.iterator();
        while (iterator.hasNext()){
            Row e = iterator.next();
            //simulating projection
            ByteBuffer[] record = e.getData();
            ByteBuffer[] recordNew = new ByteBuffer[outFields.length];
            for(int i = 0; i < outFields.length; i++){
                recordNew[i] = record[indexs[i]];
            }

            rowList.add(new Row(recordNew));
        }

        schema.setNames(names);
        schema.setValues(types);
        data.setschema(schema);
        data.setData(rowList);
        //projection doesn't change table size
        data.setSize(previous.getSize());
        return data;
    }
}