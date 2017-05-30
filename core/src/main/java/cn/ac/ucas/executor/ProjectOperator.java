package cn.ac.ucas.executor;

import cn.ac.ucas.Operator;
import cn.ac.ucas.beans.Row;
import cn.ac.ucas.beans.TableData;

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

    //todo record output Fields' type and name carefully in ProjectOperator
    public MockProjectOperator(String[] outFields){
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

        Iterator<Row> iterator = previous.iterator();
        while (iterator.hasNext()){
            Row e = iterator.next();
            //simulating projection

            rowList.add(e);
        }

        data.setData(rowList);
        //projection doesn't change table size
        data.setSize(previous.getSize());
        return data;
    }
}