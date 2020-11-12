package scubes.phones_and_accessories.asset.user_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.employee.entity.Employee;
import scubes.phones_and_accessories.asset.user_management.entity.User;

@Repository
public interface UserDao extends JpaRepository< User, Integer > {

    @Query( value = "select id from User where employee_id=?1", nativeQuery = true )
    Integer findByEmployeeId(@Param("employee_id") Integer id);

    @Query( "select id from User where username=?1" )
    Integer findUserIdByUserName(String userName);

    User findByUsername(String name);

    User findByEmployee(Employee employee);
}
