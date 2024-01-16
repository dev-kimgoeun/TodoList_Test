package org.zerok.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;
    private HikariDataSource ds;

    ConnectionUtil() {


        ds = new HikariDataSource(config);
    }
    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
