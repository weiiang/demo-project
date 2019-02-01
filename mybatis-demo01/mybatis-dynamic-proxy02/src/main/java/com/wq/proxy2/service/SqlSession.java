package com.wq.proxy2.service;

        import java.sql.SQLException;

public interface SqlSession {

    int save(String sql) throws SQLException;
}
