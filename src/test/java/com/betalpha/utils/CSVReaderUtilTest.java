package com.betalpha.utils;

import org.junit.Test;

/**
 * Created by Administrator on 2018/3/5.
 */
public class CSVReaderUtilTest {

    @Test
    public  void testCVSRead() {
        CSVReaderUtil.CVSRead(CSVReaderUtilTest.class.getClassLoader().getResource("2017-09-19.csv").getPath());

    }
}
