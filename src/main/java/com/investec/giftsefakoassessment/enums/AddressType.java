package com.investec.giftsefakoassessment.enums;

import lombok.Getter;

@Getter
public enum AddressType {
    POSTAL("Postal Address", "2"),
    PHYSICAL("Physical Address", "1"),
    BUSINESS("Business Address", "3" );

    private final String typeName;
    private final String typeCode;

    AddressType(String typeName, String typeCode) {
        this.typeName = typeName;
        this.typeCode = typeCode;
    }
}
