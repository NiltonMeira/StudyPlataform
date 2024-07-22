import { ChangeEvent, SyntheticEvent, useState } from "react"
import { MainContainer, StyledButton, StyledForm, StyledInput } from "./StyleFomrSignUp"


export const FormSignUp = () => {

    const [name, setName] = useState("")
    const [email, setemail] = useState("")
    const [cep, setCep] = useState("")
    const [cpf, setCpf] = useState("")
    const [streetAdress, setStreetAdress] = useState("")
    const [neighborhood, SetNeighborhood] = useState("")
    const [streetNumber, setStreetNumber] = useState("")
    

    const handleSubmit = (event: SyntheticEvent<HTMLFormElement, SubmitEvent>) => {
        event.preventDefault()
        alert(`The name you entered was: ${name} and the password was ${email}`)

    }

    
    const handleCepChange = (e: ChangeEvent<HTMLInputElement>) => {
        setCep(e.target.value)
        alert("CEP alterado!")
    }
    
    return (
        <>
            <MainContainer>
                <StyledForm customMargin={30} onSubmit={handleSubmit}>
                    <p>Username</p>
                    <StyledInput
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <p>Email</p>
                    <StyledInput
                        value={email}
                        onChange={(e) => setemail(e.target.value)}
                    />
                    <p>CPF</p>
                    <StyledInput
                        value={cpf}
                        onChange={(e) => setCpf(e.target.value)}
                    />
                    <p >CEP</p>
                    <StyledInput
                        value={cep}
                        onChange={handleCepChange}
                    />
                    <p>Street Adress</p>
                    <StyledInput
                        value={streetAdress}
                        onChange={(e) => setStreetAdress(e.target.value)}
                    />
                    <p>Neighborhood</p>
                    <StyledInput
                        value={neighborhood}
                        onChange={(e) => SetNeighborhood(e.target.value)}
                    />
                    <p>Street Number</p>
                    <StyledInput
                        value={streetNumber}
                        onChange={(e) => setStreetNumber(e.target.value)}
                    />
                    <StyledButton type="submit">SignUp</StyledButton>
                </StyledForm>
            </MainContainer>

        </>
    )
}