package cn.ac.ucas.aggregate;

import cn.ac.ucas.basics.Row;
import cn.ac.ucas.basics.RunningResult;

/**
*
 */
public class AvgAggregateFunction extends AggregateFunction{


    // declare necessary variable here



    @Override
    public  RunningResult getRunningResult(){
        // When records retrieved, calculate the running result here
        // TODO: do some calculation here

        double mockAvgRes = 3.0;
        double mockAvgConfidence = 0.95;
        double mockAvgInteval = 4.5;

        // use size by 'size' variable in Parent class
        long s = size;

        RunningResult res = new RunningResult(mockAvgRes,
                mockAvgConfidence,mockAvgInteval);
        return res;
    }



    @Override
    public void update( Row inputRow) {

    }


}
