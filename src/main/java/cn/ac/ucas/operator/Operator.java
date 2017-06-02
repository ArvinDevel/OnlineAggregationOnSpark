package cn.ac.ucas.operator;

import cn.ac.ucas.basics.Schema;
import cn.ac.ucas.basics.TableData;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract operator, representing a sql computation.
 * Note: don't forget to set TableData schema
 */
public abstract class Operator {
    //input attribute num
    private int inputSize;
    private int outputSize;
    private Schema inputSchema;
    private Schema outputSchema;




    private List<Operator> children;

    //first get children's data, then use their data as input
    public abstract TableData compute() throws Exception;

    //initialize
    public Operator(){
        children = new ArrayList<Operator>();
    }


//    /**
//     * Runs compute recursively on [[children]] then on this node. transform function to node
//     */
//    public void foreachUp(){
//        children.forEach(n -> n.foreachUp());
//        compute();
//    }

    public List<Operator> getChildren(){
        return children;
    }
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

    public void setChild(Operator child) {
        children.add(child);
    }
}
