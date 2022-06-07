package uz.pdp.repository;

import org.springframework.stereotype.Repository;
import uz.pdp.entity.Groups;

import java.util.List;
//@Repository
public interface GroupsResponsitory {
    public int create(Groups groups);

    public List<Groups> read();

    public Groups findGroupsById(int groupsId);

    public int update(Groups groups);

    public int delete(int groupsId);
}
