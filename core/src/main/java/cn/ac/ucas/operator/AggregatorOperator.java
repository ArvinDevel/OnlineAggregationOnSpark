package cn.ac.ucas.operator;

import cn.ac.ucas.expression.Expression;
import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.TableData;
import cn.ac.ucas.aggregate.AggregateFunction;

import java.util.*;

/**
 * Aggregator operator
 * Created by yaoguangzhong on 2017/5/28.
 */
public class AggregatorOperator extends Operator {

    //record groupby info
    Map<String, Row> hashMap = new HashMap<String, Row>();
    List<Expression> groupingExpressions;
    List<AggregateFunction> functions;

    //todo record aggregation's relations to fields

    //todo groupby dealing,hash and so on

    public AggregatorOperator(){

    }



    @Override
    public TableData compute() throws Exception{

        Operator child = getChildren().get(0);
        if(child == null){
            throw(new Exception("Child doesn't exist"));
        }

        TableData previous = child.compute();
        Iterator<Row> iterator = previous.iterator();

        //todo maybe need transfer size to AggregateFunction


        processInputs(iterator);

        //todo get results from aggregateFuncs
        for (AggregateFunction fun: functions) {

            System.out.println(fun.getRunningResult());

        }

        return null;
    }

    // The function used to read and process input rows. When processing input rows,
    // it  uses hash-based aggregation by putting groups and their buffers in
    // hashMap.
    private void processInputs(Iterator<Row> inputIter) {
        if (groupingExpressions.isEmpty()) {
            // If there is no grouping expressions, we can just reuse the same buffer over and over again.
            // Note that it would be better to eliminate the hash map entirely in the future.
            //todo use groupingExpression's unique feature
            String groupingKey = groupingExpressions.toString();
            // todo clear Row based buffer, not used any more.
            Row buffer = hashMap.get(groupingKey);
            while (inputIter.hasNext()) {
                Row newInput = inputIter.next();
                for (AggregateFunction fun: functions) {
                    fun.update(newInput);

                }
            }
        } else {
            // if the data is too large, should reuse the memory, and move old data to disk and finally merge.
            while (inputIter.hasNext()) {
                Row newInput = inputIter.next();
                //todo use groupingExpression's unique feature
                String groupingKey = groupingExpressions.toString();
                Row buffer = hashMap.get(groupingKey);

                for (AggregateFunction fun: functions) {
                    fun.update(newInput);

                }
            }


        }
    }





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
