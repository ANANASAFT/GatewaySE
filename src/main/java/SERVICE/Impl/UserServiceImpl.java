package SERVICE.Impl;

import DAO.UserDao;
import POJO.Usr;
import SERVICE.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<Usr> getAllUserInfo() {
        return UserDao.getAllUserInfo();
    }

    @Override
    public boolean updateUserInfo(Usr user) {
        return UserDao.updateUserInfo(user);
    }

    @Override
    public boolean insertUser(Usr user) {
        if(UserDao.judgeExistByName(user.getName())){
            return false;
        };
        return UserDao.insertUser(user);
    }

    @Override
    public String getPassword(String name) throws Exception {
        return UserDao.getPassword(name);
    }

    @Override
    public boolean deleteUsrInfo(int id) {
        return UserDao.deleteUsrInfo(id);
    }
}
