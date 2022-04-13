package com.redi.j2.utils;

public class TestUtils {

    public static String toGetterName(String property) {
        StringBuilder buffer = new StringBuilder(property.length() + 3);

        buffer.append("get");
        buffer.append(Character.toUpperCase(property.charAt(0)));
        buffer.append(property.substring(1));

        return buffer.toString();
    }

    public static String toSetterName(String property) {
        StringBuilder buffer = new StringBuilder(property.length() + 3);

        buffer.append("set");
        buffer.append(Character.toUpperCase(property.charAt(0)));
        buffer.append(property.substring(1));

        return buffer.toString();
    }

    public static String formatClassName(Class<?> collectionType, Class<?>... parameterizedTypes) {
        StringBuilder builder = new StringBuilder();
        builder.append(collectionType.getSimpleName());
        if(parameterizedTypes != null) {
            builder.append("<");
            for(int i=0; i<parameterizedTypes.length; i++) {
                builder.append(parameterizedTypes[i].getSimpleName());
                if (i < parameterizedTypes.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append(">");
        }
        return builder.toString();
    }
}
