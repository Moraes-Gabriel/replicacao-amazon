import logo from "./logo.svg";
import "./App.css";
import { Header } from "./ui/components/";
import { Navigate, Route, Routes } from "react-router-dom";
import { LoginScreen, RegisterScreen, TelaPrincipal } from "./ui/screen";

function App() {
  return (
    <div className="App">

      <Routes>
        <Route path="/" element={<LoginScreen />} />

        <Route path="/register" element={<RegisterScreen />} />

        <Route
          path="/principal"
          element={
              <TelaPrincipal />
          }
        />
      </Routes>
    </div>
  );
}

export default App;
