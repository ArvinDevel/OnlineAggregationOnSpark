package cn.ac.ucas.operator;

import cn.ac.ucas.basics.DataType;
import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.Schema;
import cn.ac.ucas.basics.TableData;
import cn.ac.ucas.utils.CommonUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.scalatest.prop.Tables;

import java.nio.ByteBuffer;
import java.util.Iterator;

import static org.junit.Assert.assertNotNull;

/**
 * Created by yaoguangzhong on 2017/6/1.
 */
public class AggregatorOperatorTest {


    Operator root, filter,project,source;

        @Before
        public void setUp() {

            /**
             * id   name
             * 1    'liming'
             * 2    'xiaoming'
             * 3    'xiaogang'
             *
             */

            String field1 = "id";
            String field2 = "name";
            String[] fields = {field1};



            root = new AggregatorOperator(fields);
            filter = new MockFilterOperator();
            project = new MockProjectOperator(fields);
            source = new MockSourceOperator();
            assertNotNull(source);
            project.setChild(source);
            filter.setChild(project);
            root.setChild(filter);



        }
        @Test
        public void testFilter() throws Exception {
            TableData result = null;
            try {
                result = filter.compute();
            }catch (Exception e){
                e.printStackTrace();
            }
            Iterator iterator = result.iterator();
            while (iterator.hasNext()){
                Row e = (Row)iterator.next();
                ByteBuffer[] data = e.getData();
                // not use operator's outputSchema, haven't set
                //Schema schema = filter.getOutputSchema();
                Schema schema = result.getSchema();

                assertNotNull(schema);
                String row = "";
                for(int i = 0; i < data.length; i++){
                    System.out.println(schema.getValues()[i]);
                    switch (schema.getValues()[i]){
                        case Int:
//                            row += CommonUtil.getString(data[i]);
                            row += data[i].getInt();
                            break;
                        case Double:
                            row += CommonUtil.getString(data[i]);
                            break;

                        case String:
                            row += CommonUtil.getString(data[i]);
                            break;



                    }
                }
                System.out.println(row);
            }
        }

    @Test
    public void testProject() throws Exception {
        TableData result = null;
        try {
            result = filter.compute();
        }catch (Exception e){
            e.printStackTrace();
        }
        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            Row e = (Row)iterator.next();
            ByteBuffer[] data = e.getData();
            // not use operator's outputSchema, haven't set
            //Schema schema = filter.getOutputSchema();
            Schema schema = result.getSchema();

            assertNotNull(schema);
            String row = "";
            for(int i = 0; i < data.length; i++){
                System.out.println(schema.getValues()[i]);
                switch (schema.getValues()[i]){
                    case Int:
                        row += data[i].getInt();
                        break;
                    case Double:
                        row += data[i].getDouble();
                        break;

                    case String:
                        row += CommonUtil.getString(data[i]);
                        break;



                }
            }
            System.out.println(row);
        }
    }


}
