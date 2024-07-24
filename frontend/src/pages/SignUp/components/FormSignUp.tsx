import { ChangeEvent, useEffect, useState } from "react"
import { MainContainer, StyledButton, StyledForm, StyledInput } from "./StyleFomrSignUp"
import { api } from "../../../service/viaCep"
import { toast } from "react-toastify"
import { useForm, SubmitHandler, FieldValues } from "react-hook-form"


export const FormSignUp = () => {


    const [cep, setCep] = useState("")
    const [adress, setAdress] = useState<viaCepData>()
    const { register, handleSubmit, setValue } = useForm()

    interface viaCepData {
        cep: string,
        logradouro: string,
        complemento: string,
        unidade: string,
        bairro: string,
        localidade: string,
        uf: string,
        ibge: string,
        gia: string,
        ddd: string,
        siafi: string
    }

    const submit: SubmitHandler<FieldValues> = (data) => {
        console.log({ ...data, cep: cep })
    }

    const handleCepChange = (e: ChangeEvent<HTMLInputElement>) => {
        setCep(e.target.value)
    }

    useEffect(() => {
        const getAdress = async () => {
            console.log(cep)
            if (cep.length == 8) {
                try {
                    const response = await api.get(`ws/${cep}/json/`);
                    setAdress(response.data)
                    setValue("streetAdress", response.data.logradouro)
                    toast.success("Deu boa fi")
                    console.log(response)

                } catch (error) {
                    console.log(error)
                }
            }
        }
        getAdress()
    }, [cep])
    return (
        <>
            <MainContainer>
                <StyledForm customMargin={30} onSubmit={(handleSubmit(submit))}>
                    <p>Username</p>
                    <StyledInput
                        {...register("username")}
                    />
                    <p>Email</p>
                    <StyledInput
                        {...register("email")}
                    />
                    <p>CPF</p>
                    <StyledInput
                        {...register("cpf")}
                    />
                    <p >CEP</p>
                    <StyledInput
                        value={cep}
                        onChange={handleCepChange}
                    />
                    <p>Street Adress</p>
                    <StyledInput
                        value={adress?.logradouro}
                        {...register("streetAdress")}
                    />
                    <p>Neighborhood</p>
                    <StyledInput
                        value={adress?.bairro}
                        {...register("neighborhood")}
                    />
                    <p>Street Number</p>
                    <StyledInput
                        {...register("streetNumber")}
                    />
                    <StyledButton type="submit">SignUp</StyledButton>
                </StyledForm>
            </MainContainer>

        </>
    )
}