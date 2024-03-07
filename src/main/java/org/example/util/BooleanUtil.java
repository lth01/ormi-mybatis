package org.example.util;

import java.util.List;

public class BooleanUtil {
    public static boolean isFalse(int result){
        if(result == 0) return true;
        return false;
    }

    public static boolean isFalse(boolean result){
        return !result;
    }
}
