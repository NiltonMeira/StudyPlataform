import axios from "axios"

export const api = axios.create({
    baseURL: "http://viacep.com.br/",
    timeout: 8000
})