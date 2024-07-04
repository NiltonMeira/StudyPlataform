import logoFoda from "../../assets/images/logo_foda.png"
import { StyledNav } from "./style"
import {StyledA} from "./style"
import { StyledContainer } from "./style"


const Appbar = () =>{

    return(
        <>
            <StyledNav>
                <img src={logoFoda} height={70}/>
                <StyledContainer>
                    <StyledA href="">Login</StyledA>
                    <StyledA href="">Sign up</StyledA>
                    <StyledA href="">Cursos</StyledA>
                </StyledContainer>
    
            </StyledNav>

        </>
    )
}



export default Appbar