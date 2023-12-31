import axios from "axios";
import { API_URL } from "@/context/constants";

export async function getAllTiposUsuarios() {
  const url = API_URL.replace("#", "tiposUsuarios");
  try {
    const response = await axios.get(url + "getAll");
    console.log("Response de getAllTiposUsuarios es: ", response);
    const promises = response.data.map((tipoUsuario) => {
      return {
        value: tipoUsuario.id_tipo_usuario,
        label: tipoUsuario.tipo_usuario,
      };
    });
    console.log("Promises de getAllTiposUsuarios son: ", promises);
    return promises;
  } catch (error) {
    console.error();
    return "Error";
  }
}
