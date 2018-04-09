package com.yinan.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.yinan.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class ImmutableExample3 {

    private final static  ImmutableList list = ImmutableList.of(1, 2, 3);
    private final static  ImmutableSet set = ImmutableSet.copyOf(list);
    private final static  ImmutableMap<Integer, Integer> map = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).build();

    public static void main(String[] args) {

        map.put(1, 2);
    }
}
