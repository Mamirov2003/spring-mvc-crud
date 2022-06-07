package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Classe;
import uz.pdp.entity.Student;

import java.util.List;

public class ClasseResponsitoryImpl implements ClasseResponsitory{

    JdbcTemplate jdbcTemplate;

    public ClasseResponsitoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Classe classe) {
        try {
            return jdbcTemplate.update("insert into classe(name) values (?)", classe.getName());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Classe> read() {
        return jdbcTemplate.query("select * from classe", BeanPropertyRowMapper.newInstance(Classe.class));
    }

    @Override
    public Classe findClasseById(int classeId) {
        return jdbcTemplate.queryForObject("SELECT * FROM classe WHERE id=?", BeanPropertyRowMapper.newInstance(Classe.class), classeId);
    }

    @Override
    public int update(Classe classe) {
        return jdbcTemplate.update("UPDATE classe SET name=? WHERE id=?", classe.getName(), classe.getId());
    }

    @Override
    public int delete(int classeId) {
        return jdbcTemplate.update("DELETE FROM classe WHERE id=?", classeId);
    }
}
