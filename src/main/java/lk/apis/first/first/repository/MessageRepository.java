package lk.apis.first.first.repository;

import lk.apis.first.first.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
