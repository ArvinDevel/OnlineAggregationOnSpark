package cn.ac.ucas.aggregate;

import cn.ac.ucas.beans.Row;
import cn.ac.ucas.beans.RunningResult;

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
