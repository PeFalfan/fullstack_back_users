package cl.duoc.fullstack_back_users.service.impl;

import cl.duoc.fullstack_back_users.core.exceptions.BadRequestException;
import cl.duoc.fullstack_back_users.core.exceptions.EmailAlreadyRegisteredException;
import cl.duoc.fullstack_back_users.core.exceptions.InvalidCredentialsException;
import cl.duoc.fullstack_back_users.core.exceptions.UserNotFoundException;
import cl.duoc.fullstack_back_users.core.security.JWTAuthtenticationConfig;
import cl.duoc.fullstack_back_users.models.LoginResponse;
import cl.duoc.fullstack_back_users.models.ResponseModel;
import cl.duoc.fullstack_back_users.models.UserModel;
import cl.duoc.fullstack_back_users.repositories.UserRepository;
import cl.duoc.fullstack_back_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseModel registerUser(UserModel user) {
        try {
            ArrayList<String> missingFields = new ArrayList<>();

            if (user.getEmail() == null || user.getEmail().isEmpty()) {
                missingFields.add("email");
            }
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                missingFields.add("password");
            }
            if (user.getNombre() == null || user.getNombre().isEmpty()) {
                missingFields.add("nombre");
            }

            if (!missingFields.isEmpty()) {
                throw new BadRequestException("Faltan los valores o campos para: " + missingFields.toString());
            }

            if (userRepository.findByCorreo(user.getEmail()) != null) {
                throw new EmailAlreadyRegisteredException("Email ya registtrado");
            }

            ResponseModel response = new ResponseModel();
            response.setData(userRepository.save(user));
            response.setError(null);
            response.setMessageResponse("usuario registrado con exito");

            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseModel login(String correo, String password) {
        try {

            ResponseModel response = new ResponseModel();
            LoginResponse resp = new LoginResponse();

            UserModel userFound = userRepository.findByCorreo(correo);

            if (userFound == null) {
                throw new UserNotFoundException("Correo: " + correo +" no se encuentra registrado");
            } else if (userFound.getPassword().equals(password)) {

                resp.setToken(jwtAuthtenticationConfig.getJWTToken(correo));

                resp.setUser(userFound);

                response.setData(resp);
                response.setError(null);
                response.setMessageResponse("Bienvenido!");

            } else if (!password.equals(userFound.getPassword())) {
                throw new InvalidCredentialsException("Credenciales incorrectas!");
            }

            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseModel updateUser(UserModel user) {
        try {

            ResponseModel response = new ResponseModel();

            response.setData(userRepository.findById(user.getId())
                    .map(currentUser -> {
                        currentUser.setEmail(user.getEmail());
                        currentUser.setPassword(user.getPassword());
                        currentUser.setNombre(user.getNombre());
                        return userRepository.save(currentUser);
                    })

            );
            response.setError(null);
            response.setMessageResponse("usuario actualizado con exito");

            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
