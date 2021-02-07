package scubes.phones_and_accessories.asset.user_management.user_session_log.dao;

import scubes.phones_and_accessories.asset.user_management.user_session_log.entity.enums.UserSessionLogStatus;
import scubes.phones_and_accessories.asset.user_management.user.entity.User;
import scubes.phones_and_accessories.asset.user_management.user_session_log.entity.UserSessionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionLogDao extends JpaRepository<UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
