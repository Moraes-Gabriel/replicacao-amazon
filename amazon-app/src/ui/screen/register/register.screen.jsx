import "./register.screen.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useLoginApi } from "../../../hooks/api/login/use-login-api.hook"

export function RegisterScreen() {

  const [inputValues, setInputValues] = useState();
  const navigate = useNavigate();
  const loginApi = useLoginApi();

  const handleChange = (eventoDeChange) => {
    const { name, value } = eventoDeChange.target;
    setInputValues({ ...inputValues, [name]: value });
  };

  async function registerUser() {
    try{
      await loginApi.register(
        inputValues);
        navigate('/')
      }catch(error){

      }
  }
  
  async function handleSubmit(event) {
    event.preventDefault();
    registerUser();
  }
  return (
    <div className="login_div-main">
      <div className="login_div_logo">
      </div>
      <div className="login_div_content">
        <h1>Acontecendo agora</h1>
        <h1>Crie sua conta!! simples e pratico.</h1>
        <h1>Ifter a todo momento.</h1>

        <form className="login-form" onSubmit={handleSubmit}>
      <input
        value={inputValues?.nickName}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="NickName" 
        name="nickName"
      />
      <input
        value={inputValues?.identify}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="identify" 
        name="identify"
      />
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
        placeholder="Password" 
        name="senha"
        type="password"
      />
      <input
        value={inputValues?.birthday}
        onChange={handleChange}
        autoComplete="off"
        className="login-form__input"
        placeholder="BirthDay"
        name="birthdate"
        type={`date`}
      />

      

      <button type="submit" >
        registrar  
      </button>
      
    </form>
      </div>
    </div>
  );
}
