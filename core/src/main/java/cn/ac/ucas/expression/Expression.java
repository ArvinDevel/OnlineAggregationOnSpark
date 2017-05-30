package cn.ac.ucas.expression;

import cn.ac.ucas.TreeNode;
import cn.ac.ucas.basics.DataType;
import cn.ac.ucas.basics.Row;

/**
 *
 * Expression returns a value to a expression
 * Created by yaoguangzhong on 2017/5/29.
 */
public abstract class Expression extends TreeNode{
    /**
     * Returns the [[DataType]] of the result of evaluating this expression.  It is
     * invalid to query the dataType of an unresolved expression (i.e., when `resolved` == false).
     */
    DataType dataType;

    Boolean resolved;
    /**
     * Returns `true` if this expression and all its children have been resolved to a specific schema
     * and input data types checking passed, and `false` if it still contains any unresolved
     * placeholders or has data types mismatch.
     * Implementations of expressions should override this if the resolution of this type of
     * expression involves more than just the resolution of its children and type checking.
     */
    public Boolean isResolved(){
        Boolean childrenResolved = true;
        for(int i = 0; i < children.size(); i++){
            childrenResolved &= ((Expression)children.get(i)).isResolved();
        }
        return childrenResolved;
    }

    /** Returns the result of evaluating this expression on a given input Row */
    public abstract Object eval(Row input);

    @Override
    public String toString(){
        return nodeName;
    }


}
