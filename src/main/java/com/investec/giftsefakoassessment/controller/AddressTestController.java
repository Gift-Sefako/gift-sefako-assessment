package com.investec.giftsefakoassessment.controller;

import com.investec.giftsefakoassessment.enums.AddressType;
import com.investec.giftsefakoassessment.model.Address;
import com.investec.giftsefakoassessment.model.ValidationResult;
import com.investec.giftsefakoassessment.service.JsonFileService;
import com.investec.giftsefakoassessment.service.impl.AddressPrinterServiceImpl;
import com.investec.giftsefakoassessment.service.impl.AddressValidatorServiceImpl;
import com.investec.giftsefakoassessment.utility.AddressUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address/")
@RequiredArgsConstructor
public class AddressTestController {

    private final AddressPrinterServiceImpl addressService;

    private final JsonFileService jsonFileService;

    private final AddressValidatorServiceImpl addressValidatorService;

    @GetMapping("/prettyPrintAllFromFile")
    public String prettyPrintAllAddressesFromFile() {
        List<Address> addresses = AddressUtility.parseJsonStringToAddresses(jsonFileService.loadJsonFile("addresses.json"));
        addresses.forEach(addressService::prettyPrintAddress);

        return addresses.toString();
    }

    @GetMapping("/{type}")
    public String getAddressByType(@PathVariable AddressType type) {
        List<Address> addresses = AddressUtility.parseJsonStringToAddresses(jsonFileService.loadJsonFile("addresses.json"));
        return addressService.printAllAddressesByType(addresses, type);
    }

    @GetMapping("/validateAddressesFromFile")
    public List<ValidationResult> getAddressByType() {
        List<Address> addresses = AddressUtility.parseJsonStringToAddresses(jsonFileService.loadJsonFile("addresses.json"));

        List<ValidationResult> validationResults = new ArrayList<>();

        addresses.forEach(address -> {
            validationResults.add(addressValidatorService.validateAddress(address));
        });

    return validationResults;
    }

}
