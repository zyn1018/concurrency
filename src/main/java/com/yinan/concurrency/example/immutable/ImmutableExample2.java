package com.yinan.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.yinan.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Slf4j
@NotThreadSafe
public class ImmutableExample2 {


    private static Map<Integer, Integer> map = Maps.newHashMap();
    private static Set<Integer> set = Sets.newHashSet();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {


//      map.put(1, 3);
    }
}
