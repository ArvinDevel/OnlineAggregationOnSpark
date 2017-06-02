package cn.ac.ucas.aggregate;

/**
 * Abstract aggregate, concrete aggregate function should implement these abstract methods
 * Created by yaoguangzhong on 2017/5/29.
 */

import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.RunningResult;

/**
 *  Concrete aggregate function implement two methods, use inputRowOffsets to get necessary fields
 *
 */
public abstract class AggregateFunction  {




    //used fields name and offset
    protected int[] inputRowOffsets;
    protected String[] fields;
    protected long size;

    public void setSize(long size){
        this.size = size;
    }


    /**
     * Updates its aggregation result, based on the given `inputRow`.
     *
     * Use `inputRowOffsets ` to access fields of `inputRow`.
     */
    public abstract void update( Row inputRow);



    public abstract RunningResult getRunningResult();
}
