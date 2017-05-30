package cn.ac.ucas;

import java.util.List;

/**
 * Node in tree
 * Created by yaoguangzhong on 2017/5/29.
 */
public class TreeNode {
    /**
     * Returns a Seq of the children of this node.
     * Children should not change. Immutability required for containsChild optimization
     */
    protected List<TreeNode> children;

    /**
     * Returns the name of this type of TreeNode.  Defaults to the class name.
     * Note that we remove the "Exec" suffix for physical operators here.
     */
    public String nodeName;

    public String getNodeName(){
       return this.getClass().getSimpleName().replaceAll("Exec$", "");
    }
//
//    /**
//     * Runs the given function on this node and then recursively on [[children]].
//     * @param f the function to be applied to each node in the tree.
//     */
//    public void foreach(f: BaseType => Unit) {
//        f(this)
//        children.foreach(_.foreach(f))
//    }
//
//    /**
//     * Runs the given function recursively on [[children]] then on this node.
//     * @param f the function to be applied to each node in the tree.
//     */
//    def foreachUp(f: BaseType => Unit): Unit = {
//        children.foreach(_.foreachUp(f))
//        f(this)
//    }
//
//    /**
//     * Returns a Seq containing the result of applying the given function to each
//     * node in this tree in a preorder traversal.
//     * @param f the function to be applied.
//     */
//    def map[A](f: BaseType => A): Seq[A] = {
//        val ret = new collection.mutable.ArrayBuffer[A]()
//        foreach(ret += f(_))
//        ret
//    }
//
//    /**
//     * Returns a Seq by applying a function to all nodes in this tree and using the elements of the
//     * resulting collections.
//     */
//    def flatMap[A](f: BaseType => TraversableOnce[A]): Seq[A] = {
//        val ret = new collection.mutable.ArrayBuffer[A]()
//        foreach(ret ++= f(_))
//        ret
//    }
}
