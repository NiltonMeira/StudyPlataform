import { StyledA, StyledNav } from "./style"
import { StyledContainer } from "./style"


const Appbar = () =>{

    return(
        <>
            <StyledNav>
                <StyledA to={"/"}>Study Platform</StyledA>
                <StyledContainer>
                    <StyledA to={"/"} >Login</StyledA>
                    <StyledA to={"/signup"}>Sign up</StyledA>
                    <StyledA to={"/"}>Classes</StyledA>
                </StyledContainer>
    
            </StyledNav>

        </>
    )
}



export default Appbar