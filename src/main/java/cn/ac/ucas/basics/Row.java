package cn.ac.ucas.basics;

import java.nio.ByteBuffer;

/**
 * Created by yaoguangzhong on 2017/5/25.
 * one case of table
 */
public class Row {
    private ByteBuffer[] containers;
    private int size;

    public Row(){

    }
    public Row(ByteBuffer[] recordNew) {
        containers = recordNew;
    }

    //todo does it need deep copy
    public void setData(ByteBuffer[] data){
        this.containers = data;
    }
    public ByteBuffer[] getData(){
        return containers;
    }


}
