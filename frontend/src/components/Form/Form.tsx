import { StyledForm } from "./style"
import { MainContainer } from "./style"
import { StyledInput } from "./style";

export const Form = () => {
    return (
        <>

            <MainContainer>
                <StyledForm customMargin={30}>
                    <p>User</p>
                    <StyledInput placeholder=""></StyledInput>
                    <p>Password</p>
                    <StyledInput placeholder=""></StyledInput>
                </StyledForm>
            </MainContainer>


        </>
    )
}