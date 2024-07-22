import { SyntheticEvent, useState } from "react"
import { MainContainer, StyledButton, StyledForm, StyledInput } from "./StyleFomrSignUp"


export const SignUp = () => {

    const [name, setName] = useState("")
    const [email, setemail] = useState("")
    const [cep, setCep] = useState("")

    const handleSubmit = (event: SyntheticEvent<HTMLFormElement, SubmitEvent>) => {
        event.preventDefault()
        alert(`The name you entered was: ${name} and the password was ${email}`)

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
                        value={email}
                        onChange={(e) => setemail(e.target.value)}
                    />
                    <p>CEP</p>
                    <StyledInput
                        value={cep}
                        onChange={(e) => setCep(e.target.value)}
                    />
                    <StyledButton type="submit">SignUp</StyledButton>
                </StyledForm>
            </MainContainer>

        </>
    )
}