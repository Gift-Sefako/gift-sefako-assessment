package com.investec.giftsefakoassessment.service.impl;

import com.investec.giftsefakoassessment.model.Address;
import com.investec.giftsefakoassessment.model.Country;
import com.investec.giftsefakoassessment.model.ValidationResult;
import com.investec.giftsefakoassessment.service.AddressValidatorService;
import org.springframework.stereotype.Service;

@Service
public class AddressValidatorServiceImpl implements AddressValidatorService {

    @Override
    public ValidationResult validateAddress(Address address) {
        ValidationResult result = new ValidationResult();
        result.setAddressId(address.getId());

        if(address.countryProvided() && address.numericPostalCode() && address.isAtLeastOneAddressLineProvided()) {
            result.setValid(true);
            result.setReason("Country, numeric postal code and address line detail provided.");

            if(address.getCountry().getCode().equalsIgnoreCase("ZA") && address.getProvinceOrState() == null) {
                result.setValid(false);
                result.setReason("Province NOT provided for SA address");
            }

            return result;
        }

        result.setValid(false);
        result.setReason("Country, numeric postal code and address line detail must all be provided.");

        return result;

    }





}
