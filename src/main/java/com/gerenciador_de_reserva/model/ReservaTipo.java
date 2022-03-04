package com.gerenciador_de_reserva.model;

public enum ReservaTipo {
    ACADEMIA("ACADEMIA"), PISCINA("PISCINA"),
    SALA1("SALA 1"), SALA2("SALA 2"),
    SAUNA("SAUNA"), CONDOMINIO("CONDOMINIO");

    private final String name;

    ReservaTipo(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
