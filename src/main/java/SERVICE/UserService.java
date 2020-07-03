package SERVICE;


import POJO.Usr;

import java.util.List;

public interface UserService {
    List<Usr> getAllUserInfo();
    boolean updateUserInfo(Usr user);
    boolean insertUser(Usr user);
    String getPassword(String name) throws Exception;
    boolean  deleteUsrInfo(int id);
 }
