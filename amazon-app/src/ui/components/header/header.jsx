import "./header.css";
import "./header-baixo.css";
import logoAmazon from "../../../asserts/img/logo-amazon.png";
import pin from "../../../asserts/img/pin.png";
import lupa from "../../../asserts/img/lupa.png";
import { useState } from "react";
import React from "react";

export function Header() {
  const [inputValues, setInputValues] = useState();
  const [errors, setErrors] = useState([]);

  const handleChange = (eventoDeChange) => {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  };

  console.log(inputValues);
  return (
    <header>
      <div className="header_header">
        <div className="header_div-img-logoAmazon">
          <img src={logoAmazon} alt="" className="header-img-logoAmazon" />
        </div>
        <div className="header_endereco">
          <img src={pin} alt="" className="header-img-pin" />
          <div className="header_endereco-detalhes">
            <h1 className="header_enviar-para">enviar para giovanna </h1>
            <h1 className="header_enviar-para-endereco">
              sapucaia ...93216330
            </h1>
          </div>
        </div>
        <form action="">
          <input
            onChange={handleChange}
            autoComplete="off"
            className="header_input"
            placeholder="Pesquisar"
            name="pesquisa"
          />
          <div className="header_div-img-lupa">
            <img src={lupa} alt="" className="header_img-lupa" />
          </div>
        </form>
        <div className="header_lado-direito">
          <div className="header_contas-listas">
            <h1 className="header_contas-listas-h1">olá, Ilo</h1>
            <h1>Contas e listas </h1>
          </div>

          <div className="header_devolucoes-pedidos">
            <h1 className="header_devolucoes-pedidos-h1">Devolucoes</h1>
            <h1>e Pedidos</h1>
          </div>

          <div className="header_carrinho">carrinho</div>
        </div>
      </div>
      <div className="header_baixo">
        <div className="header_baixo-div-main">
          <h1> lll todos</h1>
          <h1> Venda na amazon</h1>
          <h1> Compra novamente</h1>
          <h1> Ofertas do dia </h1>
          <h1> Eletronicos</h1>
          <h1> Computadores</h1>
          <h1> Brinquedos e jogos</h1>
          <h1> Ideias para presente</h1>
          <h1> Games </h1>
        </div>
        <div>
          <h1>prime video assista agora</h1>
        </div>
      </div>
    </header>
  );
}
