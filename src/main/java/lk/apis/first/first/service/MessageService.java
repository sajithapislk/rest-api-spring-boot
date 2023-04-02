package lk.apis.first.first.service;

import lk.apis.first.first.model.Message;
import lk.apis.first.first.model.User;
import lk.apis.first.first.repository.MessageRepository;
import lk.apis.first.first.repository.UserRepository;
import lk.apis.first.first.request.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Message> listAllMessage() {
        return messageRepository.findAll();
    }

    public void saveMessage(MessageRequest messageRequest) {

        Optional<User> optionalUser = userRepository.findById(messageRequest.user_id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Message message = new Message();
            message.setUser(user);
            message.setMessage(messageRequest.message);
            messageRepository.save(message);
            // ... do something with the message
        } else {
            // handle the case where the user is not found
        }

//        messageRepository.save(message);
    }

    public Message getMessage(Integer id) {
        return messageRepository.findById(id).get();
    }

    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}
