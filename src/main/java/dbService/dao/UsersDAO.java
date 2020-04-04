package dbService.dao;

import dbService.dataSets.UserDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserDataSet get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, res -> {
            res.next();
            return new UserDataSet(res.getLong(1), res.getString(2));
        });
    }

    public void createTable() throws SQLException{
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");

    }

    public void insertUser(String name) throws SQLException {
        executor.execUpdate("insert into users (user_name) values ('" + name + "')");
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", res -> {
           res.next();
           return res.getLong(1);
        });
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
