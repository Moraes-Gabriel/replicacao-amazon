import "./TelaPrincipal.css";
import imagemTelaPrincipal from "../../../asserts/img/telaPrincipal.jpg";
import { Header } from "../../components";
import React from "react";

export function TelaPrincipal() {
  return (
    <>
      <Header />
      <div>
        <img src={imagemTelaPrincipal} alt="" />
      </div>
    </>
  );
}
