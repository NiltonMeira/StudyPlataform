import styled from "styled-components";

interface IStyledNavProps {
    stateColor: "red"|"blue";
}

export const StyledNav = styled.nav<IStyledNavProps>`

    background-color: ${({stateColor}) => stateColor};

    padding: 20px;
`

export const SecondStyledNav = styled(StyledNav)`
    
`