package ar.edu.utn.frc.tup.lc.iii.repositories;

import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getByEmail(String email);
}
