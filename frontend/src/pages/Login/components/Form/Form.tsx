import { SyntheticEvent, useState } from "react";
import { StyledForm } from "./style"
import { MainContainer } from "./style"
import { StyledInput } from "./style";
import { StyledButton } from "./style";

export const Form = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event: SyntheticEvent<HTMLFormElement, SubmitEvent>) =>{
        event.preventDefault()
        alert(`The email you entered was: ${email} and the password was ${password}`)

    }

    return (
        <>
            <MainContainer>
                <StyledForm customMargin={30} onSubmit={handleSubmit}>  
                    <p>User</p>
                    <StyledInput
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <p>Password</p>
                    <StyledInput
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <StyledButton type="submit">Login</StyledButton>
                </StyledForm>
            </MainContainer>


        </>
    )
}