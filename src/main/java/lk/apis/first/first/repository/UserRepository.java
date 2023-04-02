package lk.apis.first.first.repository;

import lk.apis.first.first.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}