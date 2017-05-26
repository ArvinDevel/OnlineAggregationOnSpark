package cn.ac.ucas;

import java.util.List;

/**
 * Abstract operator, representing a sql computation.
 */
public abstract class Operator {
    //input attribute num
    private int inputSize;
    private int outputSize;
    private Schema inputSchema;
    private Schema outputSchema;


    private List<Operator> children;

    //first get children's data, then use their data as input
    public abstract TableData compute();




//    /**
//     * Runs compute recursively on [[children]] then on this node. transform function to node
//     */
//    public void foreachUp(){
//        children.forEach(n -> n.foreachUp());
//        compute();
//    }

    public int getInputSize(){
        return inputSize;
    }

    public boolean setInputSize(int inputSize){
        this.inputSize = inputSize;
        return true;
    }
    public int getOutputSize() {
        return outputSize;
    }
    public boolean setOutputSize(int outputSize){
        this.outputSize = outputSize;
        return true;
    }

    public Schema getInputSchema(){
        return inputSchema;
    }
    public  Schema getOutputSchema(){
        return outputSchema;
    }

}
