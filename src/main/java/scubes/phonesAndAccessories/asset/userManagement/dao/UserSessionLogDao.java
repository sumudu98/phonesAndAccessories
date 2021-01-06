package scubes.phonesAndAccessories.asset.userManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phonesAndAccessories.asset.userManagement.entity.Enum.UserSessionLogStatus;
import scubes.phonesAndAccessories.asset.userManagement.entity.User;
import scubes.phonesAndAccessories.asset.userManagement.entity.UserSessionLog;

@Repository
public interface UserSessionLogDao extends JpaRepository< UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
