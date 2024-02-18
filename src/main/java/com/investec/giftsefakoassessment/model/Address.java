package com.investec.giftsefakoassessment.model;

import lombok.Data;

@Data
public class Address {
    String id;
    AddressType type;
    String cityOrTown;
    Country country;
    String postalCode;
    String lastUpdated;
    String suburbOrDistrict;
    AddressLineDetail addressLineDetail;
    ProvinceOrState provinceOrState;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n{\n");
        appendField(sb, "id", id);
        appendObject(sb, "type", type);
        appendField(sb, "cityOrTown", cityOrTown);
        appendObject(sb, "country", country);
        appendObject(sb, "addressLineDetail", addressLineDetail);
        appendField(sb, "postalCode", postalCode);
        appendField(sb, "lastUpdated", lastUpdated);
        appendField(sb, "suburbOrDistrict", suburbOrDistrict);
        appendObject(sb, "provinceOrState", provinceOrState);
        removeTrailingComma(sb);
        sb.append("}");
        return sb.toString();
    }

    private void appendField(StringBuilder sb, String fieldName, String fieldValue) {
        if (fieldValue != null) {
            sb.append("\t").append("\"").append(fieldName).append("\": \"").append(fieldValue).append("\"");
            sb.append(",\n");
        }
    }

    private void appendObject(StringBuilder sb, String fieldName, Object fieldValue) {
        if (fieldValue != null) {
            sb.append("\t").append("\"").append(fieldName).append("\": ").append(fieldValue);
            sb.append(",\n");
        }
    }

    private void removeTrailingComma(StringBuilder sb) {
        int lastIndex = sb.lastIndexOf(",");
        if (lastIndex != -1) {
            sb.deleteCharAt(lastIndex);
        }
    }
}
