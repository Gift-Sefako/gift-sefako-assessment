package com.investec.giftsefakoassessment.service;

import com.investec.giftsefakoassessment.model.Address;
import com.investec.giftsefakoassessment.model.ValidationResult;

public interface AddressValidatorService {
    ValidationResult validateAddress(Address address);
}
