package model;

import enums.Roles;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UserData")
public class User {

    public User(String userName, String email, String password, Roles role,String cpf,String cep, String street,String neighborhood, String houseNumber) {
        this.username = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cpf = cpf;
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.houseNumber = houseNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private Roles role;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "Street")
    private String street;

    @Column(name = "Neiighborhood")
    private String neighborhood;

    @Column(name = "HouseNumber")
    private String houseNumber;
}


