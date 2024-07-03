import { useState } from "react"
import logoFoda from "../../assets/images/logo_foda.jfif"
import { StyledNav } from "./style"

const Appbar = () =>{

    const [color, setColor] = useState<"red"|"blue">("red")


    return(
        <>
            <StyledNav stateColor={color}>
                <img src={logoFoda} height={300}/>
                <div>
                    <a href="">Login</a>
                    <a href="">Sign up</a>
                </div>
                <button onClick={() => setColor((color == "red" ? "blue" : "red"))}>trocar</button>
            </StyledNav>

        </>
    )
}



export default Appbar