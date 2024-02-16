package com.investec.giftsefakoassessment.enums;

public enum AddressType {
    POSTAL("Postal Address"),
    PHYSICAL("Physical Address"),
    BUSINESS("Business Address");

    private final String typeName;

    AddressType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
