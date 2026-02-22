package br.com.dio.model.enums;

public enum GameStatusEnum {
    NON_STARTED("não iniciado"),
    INCOMPLETE("incompleto"),
    COMPLETE("finalizado"),;

    private String label;

    GameStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
