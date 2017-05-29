package cn.ac.ucas.beans;



/**
 * Created by yaoguangzhong on 2017/5/25.
 * table schema,use bits indicate atomic type
 */
public class Schema {
    //
    DataType[] values;
    String[] names;

}
enum DataType { Int, Long, Float, Double, String, Binary}

