package com.betalpha.core;

import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Administrator on 2018/3/5.
 */
public class CSV2MySqlTest {
    @Test
    public void testRun(){
        try {
            new CSV2MySql().run("2017-09-19.csv");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
