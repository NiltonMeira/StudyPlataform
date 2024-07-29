import { StyledForm } from "./style"
import { MainContainer } from "./style"
import { StyledInput } from "./style";
import { StyledButton } from "./style";
import { useForm, SubmitHandler, FieldValues } from "react-hook-form"
import { api } from "../../../../service/api";
import { toast } from "react-toastify";


export const Form = () => {

    const {register, handleSubmit, setValue} = useForm()

    const submit: SubmitHandler<FieldValues> = async (data) => {
        console.log(data)
        try{
            const response =await api.post("login", data) 
            toast.success("Login realizado com sucesso")
            console.log(response.data)
        } catch(error){
            toast.error("erro ao fazer login" + error)
        }
    }

    return (
        <>
            <MainContainer>
                <StyledForm customMargin={30} onSubmit={handleSubmit(submit)}>  
                    <p>Email</p>
                    <StyledInput
                         {...register("email")}
                    />
                    <p>Password</p>
                    <StyledInput
                         {...register("password")}
                    />
                    <StyledButton type="submit">Login</StyledButton>
                </StyledForm>
            </MainContainer>


        </>
    )
}