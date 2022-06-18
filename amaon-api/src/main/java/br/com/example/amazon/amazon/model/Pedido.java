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

public class Pedido {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carrinho_pedido",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Carrinho> carrinho;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(name="numero_caminhao_pedido")
    private String numeroCaminhaoPedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoEntregue_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoEntregue_id")
    private CartaoCredito cartao;

    @Column(nullable = false)
    private SituacaoPedido situacaoPedido;

    @Column(nullable = false)
    private LocalDate dataPedidoRealizado;

    @Column
    private LocalDate dataPedidoEntregue;

    @Column
    private LocalDate dataElegivelDevolucao;

    @Column
    private String entregueAssinado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
}
