package com.twomonth.generic;

import java.util.ArrayList;

public class ChildGeneric<T> extends Generic<T> {

    public ChildGeneric(T parameter) {
        super(parameter);
    }

    /**
     * 泛型方法是独立于泛型类的两者之间的T 互不影响。
     * @param list
     * @param index
     * @param <T>
     * @return
     */
    public <T> T get(ArrayList<T> list,int index){
        T t = list.get(index);
        return t;
    }
}
