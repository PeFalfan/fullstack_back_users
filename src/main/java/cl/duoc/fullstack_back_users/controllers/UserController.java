package cl.duoc.fullstack_back_users.controllers;

import cl.duoc.fullstack_back_users.models.ResponseModel;
import cl.duoc.fullstack_back_users.models.UserModel;
import cl.duoc.fullstack_back_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registrar")
    public ResponseModel registerUser(@RequestBody UserModel user) {
        try {
            return userService.registerUser(user);
        } catch (Exception e) {
            return new ResponseModel("Error al intentar Registro", null, e.getMessage());
        }
    }

    @PostMapping("/ingresar")
    public ResponseModel login(@RequestParam("correo") String correo, @RequestParam("password") String password) {
        try {
            return userService.login(correo, password);

        }catch (Exception e) {
            return new ResponseModel("Error al intentar login", null, e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseModel updateUser(@RequestBody UserModel user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            return new ResponseModel("Error al intentar actualizar al usuario", null, e.getMessage());
        }
    }


}
