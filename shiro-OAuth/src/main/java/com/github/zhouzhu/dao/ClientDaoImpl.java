package com.github.zhouzhu.dao;

import com.github.zhouzhu.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: ClientDaoImpl
 * @author:zhouzhu
 * @Date: 2018/8/2 11:18
 * @Version: V1.0
 */
@Repository
public class ClientDaoImpl implements ClientDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Client createClient(final Client client) {
        final String sql="INSERT INTO oauth2_client(client_name,client_id,client_secret) VALUES (?,?,?)";
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst=connection.prepareStatement(sql,new String[]{"id"});
                int count=1;
                psst.setString(count++,client.getClientName());
                psst.setString(count++,client.getClientId());
                psst.setString(count++,client.getClientSecret());
                return psst;
            }
        },keyHolder);
        client.setId(keyHolder.getKey().longValue());
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        String sql="UPDATE oauth2_client SET client_name=?,client_id=?,client_secret=? WHERE id=?";
        jdbcTemplate.update(sql,client.getClientName(),client.getClientId(),client.getClientSecret(),client.getId());
        return client;
    }

    @Override
    public void deleteClient(Long clientId) {
        String sql="DELETE FROM oauth2_client WHERE id=?";
        jdbcTemplate.update(sql,clientId);
    }

    @Override
    public Client findOne(Long clientId) {
        String sql = "select id, client_name, client_id, client_secret from oauth2_client where id=?";
        List<Client> clientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Client.class), clientId);
        if(clientList.size() == 0) {
            return null;
        }
        return clientList.get(0);
    }

    @Override
    public List<Client> findAll() {
        String sql = "select id, client_name, client_id, client_secret from oauth2_client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Client.class));
    }


    @Override
    public Client findByClientId(String clientId) {
        String sql = "select id, client_name, client_id, client_secret from oauth2_client where client_id=?";
        List<Client> clientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Client.class), clientId);
        if(clientList.size() == 0) {
            return null;
        }
        return clientList.get(0);
    }


    @Override
    public Client findByClientSecret(String clientSecret) {
        String sql = "select id, client_name, client_id, client_secret from oauth2_client where client_secret=?";
        List<Client> clientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Client.class), clientSecret);
        if(clientList.size() == 0) {
            return null;
        }
        return clientList.get(0);
    }
}
