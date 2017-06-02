package cn.ac.ucas.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Some util function for common use here.
 * Created by caihengyi on 29/05/2017.
 */
public class CommonUtil {


    /**
     * String transfer ByteBuffer
     * @param str
     * @return
     */
    public static ByteBuffer getByteBuffer(String str) {
        return ByteBuffer.wrap(str.getBytes());
    }
    /**
     * int transfer ByteBuffer
     * @param num
     * @return
     */
    public static ByteBuffer getByteBuffer(int num) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.asIntBuffer().put(num);
        return byteBuffer;
    }
    /**
     * double transfer ByteBuffer
     * @param num
     * @return
     */
    public static ByteBuffer getByteBuffer(double num) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.asDoubleBuffer().put(num);
        return byteBuffer;
    }
    /**
     * byte[] transfer ByteBuffer
     * @param bytes
     * @return
     */
    public static ByteBuffer getByteBuffer(byte[] bytes) {
        return ByteBuffer.wrap(bytes);
    }

    /**
     * ByteBuffer transfer String
     * @param buffer
     * @return String
     */
    public static String getString(ByteBuffer buffer)
    {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try
        {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }

}
