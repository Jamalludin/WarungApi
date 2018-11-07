package com.warung.makmi.warungapi.repository;

import com.warung.makmi.warungapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MasterUserRepository implements BaseRepository<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findPerPage(String search, Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<User> find() {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM m_user";

        try {
            userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findById(Object parameter) {
        return null;
    }

    public User findByEmail(String email) {
        User user = new User();

        String sql = "SELECT * FROM m_user WHERE email = ?";

        try {
            user = (User) jdbcTemplate.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper(User.class));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO m_user \n" +
                "(email, nama_lengkap, password, role)" +
                "VALUES(?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{user.getEmail(), user.getNamaLengkap(), user.getPassword(), user.getRole()});
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Object parameter) {

    }
}
