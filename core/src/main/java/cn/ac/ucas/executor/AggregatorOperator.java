package cn.ac.ucas.executor;

import cn.ac.ucas.Operator;
import cn.ac.ucas.Row;
import cn.ac.ucas.TableData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/28.
 */
public class AggregatorOperator extends Operator {
    @Override
    public TableData compute() {
        return null;
    }
    //todo record aggregation's relations to fields

}

class MockAggregatorOperator extends Operator {

    //todo
    public MockAggregatorOperator(String[] outFields){
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
        Row row = new Row();

        Iterator<Row> iterator = previous.iterator();
        while (iterator.hasNext()){
            Row e = iterator.next();
            //updating aggregation row according to group

        }
        //assumpting there exists 10 groups
        for(int i = 0; i < 10; i++){
            rowList.add(row);
            size ++;
        }


        data.setData(rowList);
        data.setSize(size);
        return data;
    }
}
