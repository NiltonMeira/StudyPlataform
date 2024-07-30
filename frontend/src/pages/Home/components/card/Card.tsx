import { useState, useEffect } from "react";
import { StyledButton, StyledCard } from "./style";

export const Card = () => {
    const [currentDate, setCurrentDate] = useState(new Date());
    const [isTimeVisible, setTimeIsVisible] = useState(true);
    const [isColorChanged, setIsColorChanged] = useState(false);

    useEffect(() => {
        const timer = setInterval(() => {
            setCurrentDate(new Date());
        }, 1000);

        return () => clearInterval(timer); // Cleanup interval on component unmount
    }, []);

    const formattedTime = `${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;

    const toggleVisibility = () => {
        setTimeIsVisible(!isTimeVisible);
    };

    const toggleColor = () => {
        setIsColorChanged(!isColorChanged);
    };

    return (
        <>
            <StyledCard style={{ backgroundColor: isColorChanged ? 'black' : 'darkg' }}>
                <h2>Titulo do cartão</h2>
                <StyledButton onClick={toggleVisibility}>
                    <p>{isTimeVisible ? 'Esconder' : 'Mostrar'} Tempo</p>
                </StyledButton>
                {isTimeVisible && <p>{formattedTime}</p>}
                <StyledButton onClick={toggleColor}>
                    <p>Mudar Cor</p>
                </StyledButton>
            </StyledCard>
        </>
    );
};
