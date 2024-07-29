import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import { Login } from "../pages/Login/Login";
import { SignUp } from "../pages/SingUp";
import { Home } from "../pages/Home/home";


const mainRoutes = createBrowserRouter([
    {
        path: "/",
        element:
            <App>
                <Login />
            </App>
    },
    {
        path: "/signup",
        element:
            <App>
                <SignUp />
            </App>
    },
    {
        path: "/home",
        element:
        <App>
            <Home/>
        </App>
    }
])

export default mainRoutes