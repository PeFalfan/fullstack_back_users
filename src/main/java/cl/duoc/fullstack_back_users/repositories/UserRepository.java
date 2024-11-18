package cl.duoc.fullstack_back_users.repositories;

import cl.duoc.fullstack_back_users.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByCorreo(String correo);
}
