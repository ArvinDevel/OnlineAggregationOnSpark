package cn.ac.ucas.executor;

import cn.ac.ucas.physicalplan.Operator;
import cn.ac.ucas.beans.Row;
import cn.ac.ucas.beans.TableData;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/25.
 * sourceOperator, used to read data from spark's dataframe using spark's sample
 */
public class SourceOperator extends Operator {

    //todo use UCASDataFrame to get data


    @Override
    public TableData compute() {
        return null;
    }
}
// to test SouceOperator
class MockSourceOperator extends Operator {


    @Override
    public TableData compute() {
        TableData tableData = new TableData();
        List<Row> rowList = new ArrayList<Row>();
        for(int i = 0; i < 1000; i++){
            Row e = new Row();
            ByteBuffer byteBuffer1 = ByteBuffer.wrap("example".getBytes());
            ByteBuffer byteBuffer2 = ByteBuffer.wrap("test".getBytes());
            ByteBuffer[] byteBuffers = {byteBuffer1,byteBuffer2};
            e.setData(byteBuffers);
            rowList.add(e);
        }
        tableData.setData(rowList);
        tableData.setSize(1000);
        return tableData;
    }
}
