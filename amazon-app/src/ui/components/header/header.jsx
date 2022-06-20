import "./header.css";
import logoAmazon from "../../../asserts/img/logo-amazon.png";
import pin from "../../../asserts/img/pin.png";
import lupa from "../../../asserts/img/lupa.png";
import { useState } from "react";

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
    </header>
  );
}
