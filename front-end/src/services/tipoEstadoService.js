import axios from "axios";
import { API_URL } from "@/context/constants";

export async function getAllTiposEstados() {
  try {
    const url = API_URL.replace("#", "tiposEstados");

    const response = await axios.get(url + "getAll");
    console.log("Response de getAllTiposEstados es: ", response);
    const promises = response.data.map((tipoEstado) => {
      return {
        value: tipoEstado.id_tipo_estado,
        label: tipoEstado.tipo_estado,
      };
    });
    console.log("Promises de getAllTiposEstados son: ", promises);
    return promises;
  } catch (error) {
    console.error();
    return "Error";
  }
}
