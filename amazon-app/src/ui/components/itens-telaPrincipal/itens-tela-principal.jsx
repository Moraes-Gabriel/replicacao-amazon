import "./itens-tela-principal.css"
import React from "react";

export function ItemTelaPrincipal(titulo, itens) {

    return ( 
        <div>
            <div>
                <h1>{titulo}</h1>
            </div>
            <div>
                {itens?.map(item => {
                    return <Item item={item}/>
                })}
            </div>
        </div>
    )
}

function Item (item) {
    return ( 
        <div>
            <img src={item?.imagem} alt="" />\
            <h1>{item?.nome}</h1>
        </div>
    )
}