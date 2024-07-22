import axios from "axios"

export const api = axios.create({
    baseURL: "viacep.com.br/ws/01001000/json/",
    timeout: 8000
})