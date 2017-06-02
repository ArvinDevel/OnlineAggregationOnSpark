package cn.ac.ucas.basics;

import cn.ac.ucas.utils.CliUtil;

/**
 * Argument pair.
 * Created by caihengyi on 02/06/2017.
 */
public class ArgPair {
    private CliUtil.ArgsType argType;
    private String argContent;

    public ArgPair(CliUtil.ArgsType argType, String argContent) {
        this.argType = argType;
        this.argContent = argContent;
    }

    public CliUtil.ArgsType getArgType() {
        return argType;
    }


    public String getArgContent() {
        return argContent;
    }
}
