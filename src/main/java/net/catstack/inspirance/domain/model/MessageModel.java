package net.catstack.inspirance.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "message")
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private String date;
}
