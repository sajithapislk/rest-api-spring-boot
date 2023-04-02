package lk.apis.first.first.controller;
import lk.apis.first.first.model.Message;
import lk.apis.first.first.request.MessageRequest;
import lk.apis.first.first.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public List<Message> list() {
        return messageService.listAllMessage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> get(@PathVariable Integer id) {
        try {
            Message user = messageService.getMessage(id);
            return new ResponseEntity<Message>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody MessageRequest message) {
        messageService.saveMessage(message);
    }
    //    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody Message user, @PathVariable Integer id) {
//        try {
//            Message existMessage = messageService.getMessage(id);
//            user.setId(id);
//            messageService.saveMessage(user);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        messageService.deleteMessage(id);
    }
}
