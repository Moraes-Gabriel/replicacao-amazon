import logo from "./logo.svg";
import "./App.css";
import { Header } from "./ui/components/";
import { Navigate, Route, Routes } from "react-router-dom";
import { TelaPrincipal } from "./ui/screen";
import React from "react";

function App() {
  return (
    <div className="App">
      <TelaPrincipal/>
    </div>
  );
}

export default App;
