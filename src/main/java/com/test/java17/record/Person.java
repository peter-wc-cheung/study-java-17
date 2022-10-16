package com.test.java17.record;

import lombok.Data;

@Data
public sealed class Person permits Engineer, Performer {

    protected String name;
    protected int age;
    protected float height;

}
