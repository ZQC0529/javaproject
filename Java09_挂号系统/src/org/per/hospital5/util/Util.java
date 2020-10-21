package org.per.hospital5.util;

import org.per.hospital5.model.ResponseM;

/**
 * Version：1.0.0
 * Package:org.per.hospital5.util
 * Author:Riel
 */
public class Util {
    public static ResponseM ok() {
        ResponseM result = new ResponseM();
        result.setCode(1);;
        result.setMsg("操作成功.");
        return result;
    }


    public static ResponseM fail(Object data) {
        ResponseM result = new ResponseM();
        result.setCode(0);
        result.setMsg("操作失败.");
        return result;
    }


    public static ResponseM badArg() {
        ResponseM result = new ResponseM();
        result.setCode(0);
        result.setMsg("参数有误.");
        return result;
    }
}
