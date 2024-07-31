import { FieldValues, SubmitHandler, useForm } from "react-hook-form"
import { StyledButton, StyledInput } from "../../../SignUp/components/StyleFomrSignUp"
import { useState } from "react"
import { StyledForm } from "../homeContent/style"

export const Welcome = () =>{

    const {register, handleSubmit} = useForm()
    const [name, setName] = useState("")

    const submit: SubmitHandler<FieldValues> = (data) => {
        console.log(data)
        setName(data.name)
        console.log(name)
       
    }
    
    return(
        <>  
        
            <StyledForm onSubmit={handleSubmit(submit)}>  
            <h1>Welcome {name}</h1>
                    <p>Digite seu nome</p>
                    <StyledInput
                         {...register("name")}
                    />
                    <StyledButton type="submit">Nome</StyledButton>
                </StyledForm>
        </>
    )
}


