package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
public class Permissao {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
}
