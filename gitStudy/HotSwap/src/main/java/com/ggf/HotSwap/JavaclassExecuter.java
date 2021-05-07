package com.ggf.HotSwap;

import java.lang.reflect.Method;

public class JavaclassExecuter {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "com/ggf/HotSwap/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method mth = clazz.getMethod("main", new Class[] {String[].class});
            mth.invoke(null, new String[] {null});
        } catch (Throwable e){
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
