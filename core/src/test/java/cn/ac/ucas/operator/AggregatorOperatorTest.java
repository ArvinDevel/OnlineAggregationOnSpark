package cn.ac.ucas.operator;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yaoguangzhong on 2017/6/1.
 */
public class AggregatorOperatorTest {



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
            String[] fields = {field1,field2};



            Operator root = new AggregatorOperator();
            Operator filter = new MockSourceOperator();
            Operator project = new MockProjectOperator(fields);
            Operator source = new MockSourceOperator();
            project.setChild(source);
            filter.setChild(project);
            root.setChild(filter);


        }
        @Test
        public void testResult() throws Exception {

        }


}
