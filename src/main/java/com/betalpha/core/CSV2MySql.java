package com.betalpha.core;

import com.betalpha.utils.CSVReaderUtil;
import com.betalpha.utils.JDBCUtils;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * 5000条数据一批次存储到数据库中
 *
 * Created by Administrator on 2018/3/5.
 */
public class CSV2MySql {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CSV2MySql.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int batchSize = 5000;
    private Connection con = JDBCUtils.getConnection();

    public void run(String cvsName) throws SQLException, ParseException {
        int count = 0;
        String tradeDate = cvsName.split("\\.")[0];
        java.util.Date date = sdf.parse(tradeDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        PreparedStatement stmt = con.prepareStatement("insert into time_series_data (item_id,trading_date,stock_code,item_value1,item_value2,item_value3) "
                + "values (?,?,?,?,?,?)");
        con.setAutoCommit(false);
        BufferedReader br = CSVReaderUtil.CVSRead(CSVReaderUtil.class.getClassLoader().getResource(cvsName).getPath());
        String line = "";
        String everyLine = "";
        try {
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                logger.info("获取到数据："+line);
                if (count == 0) {
                    count++;
                    continue;
                }
                count++;
                everyLine = line;
                String[] data = everyLine.split(",");
                if (data.length < 4 ){
                    logger.info("获取到残缺数据："+line);
                    continue;
                }
                stmt.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));
                stmt.setDate(2, sqlDate);
                stmt.setString(3, data[0]);
                stmt.setString(4, data[1]);
                stmt.setString(5, data[2]);
                stmt.setString(6, data[3]);
                stmt.addBatch();
                if (count % batchSize == 0) {
                    stmt.executeBatch();
                    con.commit();
                }
            }
            if (count % batchSize != 0) {
                stmt.executeBatch();
                con.commit();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        logger.info("cvs 文件：" + cvsName + " 存储完成");
    }
}
