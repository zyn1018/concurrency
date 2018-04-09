package com.yinan.concurrency.example.publish;

import com.yinan.concurrency.annotations.NotRecommend;
import com.yinan.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 在对象未完成构造前不能将其发布
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int escapable = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.escapable);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
