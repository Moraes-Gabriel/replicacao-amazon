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

public class RespostaPerguntaProduto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false)
    private String resposta;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_voto_util",
            joinColumns = @JoinColumn(name = "util_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> util;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_voto_naoUitl",
            joinColumns = @JoinColumn(name = "naoUtil_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> naoUtil;


}
