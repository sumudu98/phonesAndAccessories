package scubes.phonesAndAccessories.asset.userManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import scubes.phonesAndAccessories.asset.userManagement.dao.UserSessionLogDao;
import scubes.phonesAndAccessories.asset.userManagement.entity.Enum.UserSessionLogStatus;
import scubes.phonesAndAccessories.asset.userManagement.entity.User;
import scubes.phonesAndAccessories.asset.userManagement.entity.UserSessionLog;
import scubes.phonesAndAccessories.util.interfaces.AbstractService;

import java.util.List;

@Service
@CacheConfig( cacheNames = {"userSessionLog"} )
public class UserSessionLogService implements AbstractService< UserSessionLog, Integer > {
    private final UserSessionLogDao userSessionLogDao;

    @Autowired
    public UserSessionLogService(UserSessionLogDao userSessionLogDao) {
        this.userSessionLogDao = userSessionLogDao;
    }


    @Cacheable
    public List<UserSessionLog> findAll() {
        return userSessionLogDao.findAll();
    }

    @Cacheable
    public UserSessionLog findById(Integer id) {
        return userSessionLogDao.getOne(id);
    }


    @Caching( evict = {@CacheEvict( value = "userSessionLog", allEntries = true )},
            put = {@CachePut( value = "userSessionLog", key = "#userSessionLog.id" )} )
    public UserSessionLog persist(UserSessionLog userSessionLog) {
        return userSessionLogDao.save(userSessionLog);
    }


    public boolean delete(Integer id) {
        // can not be implement

        return true;
    }

    public void delete(UserSessionLog userSessionLog){
        userSessionLogDao.delete(userSessionLog);
    }


    public List<UserSessionLog> search(UserSessionLog userSessionLog) {
        return null;
    }

    @Cacheable
    public UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus) {
        return userSessionLogDao.findByUserAndUserSessionLogStatus(user, userSessionLogStatus);
    }
}

