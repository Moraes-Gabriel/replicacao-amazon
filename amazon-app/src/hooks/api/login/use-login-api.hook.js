import { useMemo } from "react";
import { useGlobalUser } from "../../../context/user.context";
import { useHttp } from "../_base/use-http.hook";
import { url } from "../../../context/API_URL.js"

export function useLoginApi() {

  const [user,] = useGlobalUser();
  const API_URL = url+""

  const httpInstance = useHttp(API_URL, {});

  async function logar(email, password) {
      const response = httpInstance.login('/login',
      {},
      {
        auth: {username: email, password: password}
      })
      return response;
  }

  async function logout() {
    const response = await httpInstance.post('/logout', 
     {} ,
    {
      headers: {
        'X-Auth-Token': user
      }
    });
    return response;
  } 

  async function register(inputValues) {
    const response = httpInstance.post('/usuario',
    inputValues,
    {})
    return response;
}
  
  

  return useMemo(
    () => ({
      logar,
      register,
      logout
    }),
    [user]
  );
}
