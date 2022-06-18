package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Builder
@Entity

public class CarrinhoUsuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "carrinhoUsuario_id")
    private List<Carrinho> carrinho;

    @Column(nullable = false)
    private Double valorTotal;

}
