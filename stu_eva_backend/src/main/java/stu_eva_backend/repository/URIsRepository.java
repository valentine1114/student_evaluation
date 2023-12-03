package stu_eva_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stu_eva_backend.model.Backaccess;
import stu_eva_backend.model.URIs;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface URIsRepository extends JpaRepository<URIs, Long>{
    // @Query("select n from uris n join n.role_uri a join a.role r where r.id = :roleId")
    // List<URIs> findBackaccessByRoleId(Long roleId);

    List<URIs> findAll();
    
    
}
