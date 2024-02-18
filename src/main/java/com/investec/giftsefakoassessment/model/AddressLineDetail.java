package com.investec.giftsefakoassessment.model;

import lombok.Data;

@Data
public class AddressLineDetail {
    String line1;
    String line2;

    @Override
    public String toString() {
        return "\n\t\t{\n\t\t\t\"line1\": \"" + line1 + "\", \n\t\t\t\"line2\": \"" + line2 + "\"\n\t\t}";
    }
}
