package com.investec.giftsefakoassessment.model;

public class ProvinceOrState {
    String code;
    String name;

    @Override
    public String toString() {
        return "\n\t\t{\n\t\t\t\"code\": \"" + code + "\", \n\t\t\t\"name\": \"" + name + "\"\n\t\t}";
    }

}
