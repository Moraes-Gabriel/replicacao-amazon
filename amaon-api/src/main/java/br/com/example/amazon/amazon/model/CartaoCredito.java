package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
@Entity

public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Size(min = 16, max=16)
    @Column(nullable = false, unique = true)
    private String numeroDoCartao;

    @Column(nullable = false)
    private String nomeDoCartao;

    @Column(nullable = false)
    private LocalDate dataDeExpiracao;

    @Column(nullable = false)
    private String codigoDeSeguranca;


}
