package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class user {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @Getter @Setter
    public String firstname;

    @Getter @Setter
    @Column(nullable = false)
    public String lastname;

    @Getter @Setter
    @Column(unique = true, nullable = false)
    public String email;
}
