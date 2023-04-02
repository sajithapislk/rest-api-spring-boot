package lk.apis.first.first.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String first_name;
    private String last_name;

//    @OneToMany(mappedBy="messages", cascade=CascadeType.ALL)
//    List<Message> messages;
}

