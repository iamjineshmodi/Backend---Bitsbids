package com.bitsbids.BITSBids.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private String senderName;
    @Column
    private String receiverName;
    @Column
    private String message;
    @Column
    private Status status;
}
