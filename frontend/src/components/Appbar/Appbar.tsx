import { StyledNav } from "./style"
import {StyledA} from "./style"
import { StyledContainer } from "./style"


const Appbar = () =>{

    return(
        <>
            <StyledNav>
                <StyledA>Study Platform</StyledA>
                <StyledContainer>
                    <StyledA href="">Login</StyledA>
                    <StyledA href="">Sign up</StyledA>
                    <StyledA href="">Classes</StyledA>
                </StyledContainer>
    
            </StyledNav>

        </>
    )
}



export default Appbar