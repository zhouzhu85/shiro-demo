package com.shiro.dao;

import com.shiro.pojo.Permission;
import com.shiro.utils.JdbcTemplateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PermissionDaoImpl implements PermissionDao{

    private JdbcTemplate jdbcTemplate= JdbcTemplateUtils.createJdbcTemplate();

    @Override
    public Permission createPermission(final Permission permission) {
        final String sql="INSERT INTO sys_permissions (permission,description,available) VALUES (?,?,?)";

        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst=connection.prepareStatement(sql,new String[]{"id"});
                psst.setString(1,permission.getPermission());
                psst.setString(2,permission.getDescription());
                psst.setBoolean(3,permission.getAvailable());
                return psst;
            }
        },keyHolder);

        permission.setId(keyHolder.getKey().longValue());

        return permission;
    }

    @Override
    public void deletePermission(Long permissionId) {
        String sql="DELETE FROM sys_roles_permissions WHERE permission_id=?";
        jdbcTemplate.update(sql,permissionId);

        sql="DELETE  FROM  sys_permissions WHERE id=?";

        jdbcTemplate.update(sql,permissionId);

    }
}
