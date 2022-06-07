package uz.pdp.repository;

import org.springframework.stereotype.Repository;
import uz.pdp.entity.Classe;

import java.util.List;
//@Repository
public interface ClasseResponsitory {
    public int create(Classe classe);

    public List<Classe> read();

    public Classe findClasseById(int classeId);

    public int update(Classe classe);

    public int delete(int classeId);
}
