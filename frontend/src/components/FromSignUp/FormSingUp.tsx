import { SyntheticEvent, useState } from "react";
import { StyledForm } from "./style"
import { MainContainer } from "./style"
import { StyledInput } from "./style";
import { StyledButton } from "./style";

export const FormSignUp = () => {

    const [name, setName] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event: SyntheticEvent<HTMLFormElement, SubmitEvent>) =>{
        event.preventDefault()
        alert(`The name you entered was: ${name} and the password was ${password}`)

    }

    return (
        <>
            <MainContainer>
                <StyledForm customMargin={30} onSubmit={handleSubmit}>
                    <p>User</p>
                    <StyledInput
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <p>Email</p>
                    <StyledInput
                        value={name}
                        onChange={(e) => setName(e.target.value)}
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