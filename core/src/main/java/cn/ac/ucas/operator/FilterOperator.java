package cn.ac.ucas.operator;

import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.TableData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/28.
 */
public class FilterOperator extends Operator{

    @Override
    public TableData compute() throws Exception{
        return null;
    }
//todo record filter condition

}

class MockFilterOperator extends Operator {

    //todo need a condition class
    public MockFilterOperator(String[] outFields){
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
        int size = 0;

        Iterator<Row> iterator = previous.iterator();
        while (iterator.hasNext()){
            Row e = iterator.next();
            //simulating filter
            if(e != null){
                rowList.add(e);
                size++;
            }

        }
        data.setData(rowList);
        data.setSize(size);
        return data;
    }
}