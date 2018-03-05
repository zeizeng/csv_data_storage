package com.betalpha.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 读取CVS 文件方法类
 * Created by Administrator on 2018/3/5.
 */
public class CSVReaderUtil {
    private static Logger logger = LoggerFactory.getLogger(CSVReaderUtil.class);
    public static BufferedReader CVSRead(String filepath) {
        logger.info("开始读取文件: " + filepath);
        File csv = new File(filepath);  // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return br;
    }




}
