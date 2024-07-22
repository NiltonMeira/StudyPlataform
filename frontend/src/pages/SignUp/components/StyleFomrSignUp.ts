import styled from "styled-components";

interface IStyledFormProps{
    customMargin?: number;
}
export const StyledForm = styled.form<IStyledFormProps>`
    display: flex;
    justify-content: center;
    flex-direction: column;
    margin-top: ${({customMargin}) => customMargin ? customMargin + "px": "30px"};
    width: 40%;
    min-width: 300px;   
    color: white;
    gap: 30px;
    border: 3px #222222 solid;
    padding: 50px;
    border-radius: 5px;

`

export const MainContainer = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    padding-top: 60px;
`

export const StyledInput = styled.input`
    background-color:  #141414;
    border: none;
    border-bottom: 1px #023E7D solid;
    color: white;
    outline: none;
    padding: 5px;

`

export const StyledButton = styled.button`
    padding: 15px;

    background-color:  #023E7D;
    color: white;
    
    border-radius: 15px;
    font-weight: 600;
    border: 1px #023E7D solid;
    
`