package cl.duoc.fullstack_back_users.service;

import cl.duoc.fullstack_back_users.models.ResponseModel;
import cl.duoc.fullstack_back_users.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseModel registerUser(UserModel user);

    ResponseModel login(String correo, String password);

    ResponseModel updateUser(UserModel user);
}
