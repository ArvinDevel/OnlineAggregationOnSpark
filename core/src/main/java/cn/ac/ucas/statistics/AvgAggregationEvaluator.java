package cn.ac.ucas.statistics;

import cn.ac.ucas.beans.TableData;
import cn.ac.ucas.beans.RunningResult;

/**
 * Created by caihengyi on 29/05/2017.
 */
public class AvgAggregationEvaluator {

    public static RunningResult getRunningResult(TableData records){
        // When records retrieved, calculate the running result here
        // TODO: do some calculation here

        double mockAvgRes = 3.0;
        double mockAvgConfidence = 0.95;
        double mockAvgInteval = 4.5;
        RunningResult res = new RunningResult(mockAvgRes,
                mockAvgConfidence,mockAvgInteval);
        return res;
    }
}
