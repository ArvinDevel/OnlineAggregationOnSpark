package cn.ac.ucas.basics;

/**
 * Created by caihengyi on 29/05/2017.
 */
public class RunningResult {
    private Object result;
    private Double confidence;
    private Double interval;

    public RunningResult(Object result, Double confidence, Double interval) {
        this.result = result;
        this.confidence = confidence;
        this.interval = interval;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getInterval() {
        return interval;
    }

    public void setInterval(Double interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "RunningResult{" +
                "result=" + result +
                ", confidence=" + confidence +
                ", interval=" + interval +
                '}';
    }
}
