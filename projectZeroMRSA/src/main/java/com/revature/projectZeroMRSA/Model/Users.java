package com.revature.projectZeroMRSA.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String user_name;
    @Column
    private String user_password;

    //todo connect to games table

}
