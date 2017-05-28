package cn.ac.ucas;

import java.nio.ByteBuffer;

/**
 * Created by yaoguangzhong on 2017/5/25.
 * one case of table
 */
public class Row {
    private ByteBuffer[] containers;
    private int size;
    //todo does it need deep copy
    public void setData(ByteBuffer[] data){
        this.containers = data;
    }


}
