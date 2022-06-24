import { useMemo } from "react";
import { useGlobalUser } from "../../../context/user.context";
import { useHttp } from "../_base/use-http.hook";
import { url } from "../../../context/API_URL.js";

export function useProdutoApi() {
  const [user] = useGlobalUser();
  const API_URL = url + " /produto";

  const httpInstance = useHttp(API_URL, {});

  async function listarPosts() {
    const response = await httpInstance.get("/listar/feed", {
      headers: {
        "X-Auth-Token": user,
      },
    });
    return response;
  }

  async function buscarPostPorId(postId) {
    const response = await httpInstance.get(`/buscar/${postId}`, {
      headers: {
        "X-Auth-Token": user,
      },
    });
    return response;
  }

  async function listarComentariosPorPostId(postId) {
    const response = await httpInstance.get(`/listar/comentarios/${postId}`, {
      headers: {
        "X-Auth-Token": user,
      },
    });
    return response;
  }

  async function pesquisarProdutoPorNome(nome) {
    const response = await httpInstance.get(`/pesquisar/${nome}`, {
      headers: {
        "X-Auth-Token": user,
      },
    });
    return response;
  }

  async function incluir(description, category) {
    const object = { description, category };
    const response = await httpInstance.post("/incluir", object, {
      headers: {
        "X-Auth-Token": user,
      },
    });
    return response;
  }
  async function incluirComentario(description, category, postId) {
    const object = { description, category };
    const response = await httpInstance.put(
      `/incluir/comentario/${postId}`,
      object,
      {
        headers: {
          "X-Auth-Token": user,
        },
      }
    );
    return response;
  }
  async function deletarPost(postId) {
    const response = await httpInstance.put(`/deletar/${postId}`, {
      headers: {
        "X-Auth-Token": user,
      },
    });
  }

  async function gostar(postId) {
    const response = await httpInstance.put(
      `/curtir/${postId}`,
      {},
      {
        headers: {
          "X-Auth-Token": user,
        },
      }
    );
    return response;
  }

  async function desgostar(postId) {
    const response = await httpInstance.put(
      `/descurtir/${postId}`,
      {},
      {
        headers: {
          "X-Auth-Token": user,
        },
      }
    );
    return response;
  }

  return useMemo(
    () => ({
      listarPosts,
      incluir,
      gostar,
      desgostar,
      listarPostsDoUsuarioPorIdentify,
      buscarPostPorId,
      listarComentariosPorPostId,
      incluirComentario,
      deletarPost,
    }),
    [user]
  );
}
