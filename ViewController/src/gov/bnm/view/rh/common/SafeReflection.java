package gov.bnm.view.rh.common;

import java.lang.reflect.Method;

public class SafeReflection {
    public static boolean hasMethod(Object o, String name,
                                    Class[] parameterTypes) {
        try {
            o.getClass().getMethod(name, parameterTypes);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Method getMethod(Object o, String methodName,
                                   Class[] parameterTypes) {
        try {
            return o.getClass().getMethod(methodName, parameterTypes);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invoke(Object o, String methodName,
                                Class[] parameterTypes, Object[] parameters) {
        try {
            return o.getClass().getMethod(methodName, parameterTypes).invoke(o,
                                                                             parameters);
        } catch (Exception e) {
            return null;
        }
    }
}
