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
public interface BackaccessRepository extends JpaRepository<Backaccess, Long> {
    @Query("select b from Backaccess b where b.role.id = :roleId")
    List<Backaccess> findByRoleId(@Param("roleId") Integer roleId);

    List<Backaccess> findAll();
}
