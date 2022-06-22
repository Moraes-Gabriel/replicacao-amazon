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

    private String titulo;

    private String descricao;

    @Column(nullable = false)
    private Double nota;

    @Column(nullable = false)
    private LocalDate data;

    @Size(max = 5)
    @ElementCollection
    @CollectionTable(name = "imagensAvaliacaoProduto")
    private List<String> imagens;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_voto_util",
            joinColumns = @JoinColumn(name = "util_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> util;

}
