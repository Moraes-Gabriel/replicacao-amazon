package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.*;

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

public class PerguntaProduto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false)
    private String pergunta;

    @Column(nullable = false)
    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private List<RespostaPerguntaProduto> resposta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_voto",
            joinColumns = @JoinColumn(name = "voto_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> voto;
}
