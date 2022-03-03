package com.gerenciador_de_reserva.model;

public enum ReservaTipo {
    GYM("GYM"), POOL("POOL"),
    SAUNA("SAUNA");

    private final String name;

    private ReservaTipo(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
