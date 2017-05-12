package com.hws.Services.security;

import com.hws.DAO.interfaces.IUserDAO;
import com.hws.Services.security.interfaces.IRegisterService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.User;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ihor on 5/7/2017.
 */
@Service
public class RegisterService implements IRegisterService {

    @Autowired
    IUserDAO _userDao;

    @Override
    public ResponseWrapper<User> RegisterNewUser(User newUser) {
        ResponseWrapper<User> result = Validate(newUser);

        if (!result.IsSuccess)
            return result;

        newUser = _userDao.AddNewUser(newUser);

        result.ResponseData = newUser;
        return result;
    }

    @Override
    public ResponseWrapper<User> RegisterNewUser(String login, String password) {
        User newUser = new User(login, password);
        
        return RegisterNewUser(newUser);
    }


    private ResponseWrapper<User> Validate(User user){
        ResponseWrapper<User> result = new ResponseWrapper<>();

        if (StringUtil.IsNullOrEmpty(user.getLogin())){
            result.AddErrorMessage("Login can not be empty!");
        }

        if (_userDao.GetUserByLogin(user.getLogin()) != null){
            result.AddErrorMessage("This Email is in use!");
        }

        return result;
    }
}
