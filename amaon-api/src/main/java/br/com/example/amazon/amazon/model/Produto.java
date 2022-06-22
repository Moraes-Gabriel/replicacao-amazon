package br.com.example.amazon.amazon.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

public class Produto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private CategoriaProduto categoria;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Long quantidadeProduto;

    @Column(nullable = false)
    private Double nota;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<AvaliacaoProduto> avaliacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private List<PerguntaProduto> perguntas;

    @ElementCollection
    @CollectionTable(name = "configuracaoProduto")
    private List<String> configuracao;

    @Size(min = 1, max = 7)
    @ElementCollection
    @CollectionTable(name = "imagensProduto")
    private List<String> imagens;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public void adicionarQuantidadeProduto(Long quantidadeProdutoSomar){
        this.quantidadeProduto += quantidadeProdutoSomar;
    }
}
