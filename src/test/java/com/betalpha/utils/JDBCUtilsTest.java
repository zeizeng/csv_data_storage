package com.betalpha.utils;

import com.betalpha.core.CSV2MySql;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Administrator on 2018/3/5.
 */
public class JDBCUtilsTest {

    @Test
    public void testGetConnection() {
        try {
            int assertInt = new CSV2MySql().run("2017-09-19.csv");
            assert assertInt == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
