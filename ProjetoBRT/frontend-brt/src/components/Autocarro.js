import React, { useEffect, useState } from "react";

const Autocarro = () => {
    const [autocarros, setAutocarros] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/autocarros") // Endereço do backend
            .then(response => response.json())
            .then(data => setAutocarros(data)) // Guardar os dados no estado
            .catch(error => console.error("Erro ao buscar autocarros:", error));
    }, []);

    const alterarPassageiros = (id, acao) => {
        fetch(`http://localhost:8080/autocarros/${id}/${acao}`, {
            method: "PATCH",
        })
            .then(response => response.json())
            .then(data => {
                setAutocarros(autocarros.map(bus =>
                    bus.id === id ? { ...bus, passageirosAtuais: data.passageirosAtuais } : bus
                ));
            })
            .catch(error => console.error("Erro ao alterar passageiros:", error));
    };

    return (
        <div>
            <h2>Lista de Autocarros</h2>
            <ul>
                {autocarros.map(bus => (
                    <li key={bus.id}>
                        <strong>Matrícula:</strong> {bus.matricula} | <strong>Capacidade:</strong> {bus.capacidadeMaxima} | <strong>Passageiros Atuais:</strong> {bus.passageirosAtuais}
                        <button onClick={() => alterarPassageiros(bus.id, "entrar")}>Entrar</button>
                        <button onClick={() => alterarPassageiros(bus.id, "sair")}>Sair</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Autocarro;
