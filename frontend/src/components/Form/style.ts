import styled from "styled-components";

interface IStyledFormProps{
    customMargin?: number;
}
export const StyledForm = styled.form<IStyledFormProps>`
    display: flex;
    justify-content: center;
    flex-direction: column;
    margin-top: ${({customMargin}) => customMargin ? customMargin + "px": "30px"}
    
`