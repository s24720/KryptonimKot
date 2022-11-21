package org.example.reflekcje;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodFilter {
    private final Method method;

    public MethodFilter(Method method) {
        this.method = method;
    }


    public boolean isPublic() {
        return method.getModifiers() == Modifier.PUBLIC;
    }

    public boolean paramsCountEquals(int i) {
        return method.getParameterCount() == i;
    }


    public boolean startsWith(String s) {
        return method.getName().startsWith(s);
    }


    public boolean isVoid() {
        return method.getReturnType() == Void.TYPE;
    }


    public boolean isSetter() {
        return isPublic()
                && isVoid()
                && startsWith("set")
                && paramsCountEquals(1);
    }


    public boolean isGetter() {
        return isPublic()
                && !isVoid()
                && (startsWith("get") || startsWith("is"))
                && paramsCountEquals(0);
    }


    public String getFieldName() {
        return Arrays.stream(method.getDeclaringClass().getDeclaredFields())
                .filter(field1 -> method.getName().toLowerCase().endsWith(field1.getName().toLowerCase().replaceAll("^(is)", "")))
                .toList().get(0).getName();
    }
}
