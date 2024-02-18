package com.investec.giftsefakoassessment.model;

import lombok.Data;

@Data
public class AddressType {
    String code;
    String name;

    @Override
    public String toString() {
        return "\n\t\t{\n\t\t\t\"code\": \"" + code + "\", \n\t\t\t\"name\": \"" + name + "\"\n\t\t}";
    }
}
