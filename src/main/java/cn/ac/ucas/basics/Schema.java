package cn.ac.ucas.basics;



/**
 * Created by yaoguangzhong on 2017/5/25.
 * table schema,use bits indicate atomic type
 */
public class Schema {
    //
    DataType[] values;
    String[] names;




    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getNames() {

        return names;
    }


    public DataType[] getValues() {
        return values;
    }

    public void setValues(DataType[] values) {
        this.values = values;
    }
}

