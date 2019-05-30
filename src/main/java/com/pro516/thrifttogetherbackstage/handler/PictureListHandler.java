package com.pro516.thrifttogetherbackstage.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pro516.thrifttogetherbackstage.util.JsonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 18:26
 */
public class PictureListHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JsonUtil.convertObject2String(strings));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String json = resultSet.getString(s);
        System.out.println(json);
        List<String> pictureList = JsonUtil.convertString2Object(json, new TypeReference<List<String>>() {
        });

        return pictureList;
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String json = resultSet.getString(i);
        System.out.println(json);
        List<String> pictureList = JsonUtil.convertString2Object(json, new TypeReference<List<String>>() {
        });
        return pictureList;
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String json = callableStatement.getString(i);
        List<String> pictureList = JsonUtil.convertString2Object(json, new TypeReference<List<String>>() {
        });
        return pictureList;
    }
}
