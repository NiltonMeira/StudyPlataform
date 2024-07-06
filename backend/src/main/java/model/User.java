package model;

import enums.Roles;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserData")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private Roles role;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "Street")
    private String street;

    @Column(name = "Neiighborhood")
    private String neighborhood;

    @Column(name = "HouseNumber")
    private String houseNumber;
}


