package com.basicType.generic;

public class GenTest<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T t) {
        value = t;
    }
}
