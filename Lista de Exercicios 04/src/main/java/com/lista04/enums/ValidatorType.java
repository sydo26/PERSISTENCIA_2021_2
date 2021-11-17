package com.lista04.enums;

public enum ValidatorType {

    IsEmail("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+",
            "O e-mail deve estar no seguinte formato: example@example.com"),
    IsOnlyNumber("^[0-9]+$", "Apenas dígitos numéricos 0-9 são aceitos."),
    IsName("^[a-zA-Záéíóúâêîô]+[\\-'\\s]?[a-zA-Záéíóúâêîô ]+$", "Precisa ser um nome válido. Ex: Vinicius Roque"),
    IsCPF("^((\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})|(\\d{3}\\d{3}\\d{3}\\d{2}))$",
            "O cpf deve ser uma sequência numérica de 11 números ou no seguinte formato: XXX.XXX.XXX-XX"),
    IsPlainPhone("^([1-9]{1}[0-9]{10})+$",
            "O número de telefone deve possuir apenas números e contento no máximo 11 dígitos.");

    private String value, message;

    private ValidatorType(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
