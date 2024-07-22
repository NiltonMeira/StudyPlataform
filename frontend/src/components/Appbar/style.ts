import styled from "styled-components";
import { Link } from "react-router-dom";


export const StyledNav = styled.nav`

    padding: 20px;
    display: flex;
    width: 100%;
    justify-content: space-between;
    align-items: center;
    border: none;
    border-bottom: 1px #023E7D solid;
    position: fixed;
    z-index: 99;
    background-color: #141414;
    top: 0;
`

export const StyledA = styled(Link)`
    text-decoration: none;
    color: white;
    font-weight: 500;
    transition: 0.4s;   

    &:hover{
        transform: scale(1.2);
        color: #0353A4;
    }
    
`

export const StyledContainer = styled.div`
    display: flex;
    gap: 50px
`
