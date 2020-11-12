package scubes.phones_and_accessories.asset.user_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.user_management.entity.Enum.UserSessionLogStatus;
import scubes.phones_and_accessories.asset.user_management.entity.User;
import scubes.phones_and_accessories.asset.user_management.entity.UserSessionLog;

@Repository
public interface UserSessionLogDao extends JpaRepository< UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
