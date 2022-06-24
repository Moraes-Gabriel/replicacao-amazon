import "./login.screen.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useGlobalUser } from "../../../context/user.context";
import { useLoginApi } from "../../../hooks/api/login/use-login-api.hook"

export function LoginScreen() {

  const [inputValues, setInputValues] = useState();
  const [globalUser, setGlobalUser] = useGlobalUser();
  const navigate = useNavigate();
  const loginApi = useLoginApi();

  const handleChange = (eventoDeChange) => {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  };

  async function getLoginApi() {
      const response = await loginApi.logar(inputValues?.email, inputValues?.password);
      setGlobalUser(response)
  }
  
  async function handleSubmit(event) {
    event.preventDefault();
    getLoginApi();
    if(globalUser) navigate('/home')

    localStorage.setItem('token', {})
  }
  return (
    <div className="login_div-main">
      <div className="login_div_logo">
      </div>
      <div className="login_div_content">
        <h1>Acontecendo agora</h1>
        <h1>Inscreva-se no Twitter hoje mesmo.</h1>

        <form className="login-form" onSubmit={handleSubmit}>
      <input
        value={inputValues?.email}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="Email" 
        name="email"
      />
      <input
        value={inputValues?.password}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="password"
        name="password"
        type="password"
      />

      

      <button type="submit" >
        logar
      </button>
        <a href="http://localhost:3000/register"> nao tem conta? inscreva-se agora</a>
    </form>
      </div>
    </div>
  );
}
