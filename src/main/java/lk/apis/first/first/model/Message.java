package lk.apis.first.first.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Table(name = "messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}

