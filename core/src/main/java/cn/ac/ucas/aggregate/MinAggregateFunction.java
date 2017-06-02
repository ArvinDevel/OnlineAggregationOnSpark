package cn.ac.ucas.aggregate;

import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.RunningResult;

/**
*
 */
public class MinAggregateFunction extends AggregateFunction{

    @Override
    public void update(Row inputRow) {

    }

    @Override
    public RunningResult getRunningResult() {
        return null;
    }
}
