package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.time.LocalDate;
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

public class AvaliacaoProduto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Long nota;

    @Column(nullable = false)
    private LocalDate data;

    @Size(min = 1, max = 3)
    @ElementCollection
    @CollectionTable(name = "imagensAvaliacaoProduto")
    private List<String> imagens;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_voto_util",
            joinColumns = @JoinColumn(name = "util_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> util;

}
