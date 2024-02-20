package com.investec.giftsefakoassessment.model;

import lombok.Data;

@Data
public class ValidationResult {
    boolean valid;
    String reason;
    String addressId;
}
