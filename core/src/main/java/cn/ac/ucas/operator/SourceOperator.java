package cn.ac.ucas.operator;

import cn.ac.ucas.basics.DataType;
import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.Schema;
import cn.ac.ucas.basics.TableData;
import cn.ac.ucas.utils.CommonUtil;

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
        Schema schema = new Schema();
        String[] names = {"id","name"};
        DataType[] types = {DataType.Int,DataType.String};
        schema.setNames(names);
        schema.setValues(types);
        List<Row> rowList = new ArrayList<Row>();
        for(int i = 0; i < 1000; i++){
            Row e = new Row();
            ByteBuffer byteBuffer1 = CommonUtil.getByteBuffer(i);
            ByteBuffer byteBuffer2 = ByteBuffer.wrap(("test"+i).getBytes());
            ByteBuffer[] byteBuffers = {byteBuffer1,byteBuffer2};
            e.setData(byteBuffers);
            rowList.add(e);
        }
        tableData.setschema(schema);
        tableData.setData(rowList);
        tableData.setSize(1000);
        return tableData;
    }
}
