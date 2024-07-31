import { CardContainer, MainContainer } from "./style"
import { Card } from "../card/Card"
import { Welcome } from "../Welcome/Welcome"

export const HomeContent = () => {
    return(
        <>
            <MainContainer>
                <Welcome/>
                <CardContainer>
                    <Card/>
                    <Card/>
                    <Card/>
                </CardContainer>
            </MainContainer>
        </>
    )
}