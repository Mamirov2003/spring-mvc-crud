package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Groups;
import uz.pdp.entity.Groups;

import java.util.List;

public class GroupsResponsitoryImpl implements GroupsResponsitory{
    JdbcTemplate jdbcTemplate;

    public GroupsResponsitoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public int create(Groups groups) {
        try {
            return jdbcTemplate.update("insert into groups(name,classe_id) values (?,?)", groups.getName());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Groups> read() {
        return jdbcTemplate.query("select * from groups", BeanPropertyRowMapper.newInstance(Groups.class));
    }

    @Override
    public Groups findGroupsById(int groupsId) {
        return jdbcTemplate.queryForObject("SELECT * FROM groups WHERE id=?", BeanPropertyRowMapper.newInstance(Groups.class), groupsId);
    }

    @Override
    public int update(Groups groups) {
        return jdbcTemplate.update("UPDATE groups SET name=?, classe_id WHERE id=?", groups.getName(), groups.getClasse_id(), groups.getId());
    }

    @Override
    public int delete(int groupsId) {
        return jdbcTemplate.update("DELETE FROM groups WHERE id=?", groupsId);
    }
}
