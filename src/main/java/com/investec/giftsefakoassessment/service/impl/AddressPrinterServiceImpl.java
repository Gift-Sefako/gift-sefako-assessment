package com.investec.giftsefakoassessment.service.impl;

import com.investec.giftsefakoassessment.enums.AddressType;
import com.investec.giftsefakoassessment.model.Address;
import com.investec.giftsefakoassessment.service.AddressPrinterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class AddressPrinterServiceImpl implements AddressPrinterService {

    @Override
    public String prettyPrintAddress(Address address) {
        log.info(address.toString());
        return address.toString();
    }

    @Override
    public String printAllAddressesByType(List<Address> addresses, AddressType addressType) {
        List<Address> filteredAddresses = addresses
                .stream()
                .filter(address -> address.getType().getName().equalsIgnoreCase(addressType.getTypeName())).toList();
        StringBuilder arrayBuilder = new StringBuilder();

        arrayBuilder.append("[\n");
        for (int i = 0; i < filteredAddresses.size(); i++) {
            arrayBuilder.append("\t\t").append(filteredAddresses.get(i).toString().replace("\n", "\n\t\t"));
            if (i != filteredAddresses.size() - 1) {
                arrayBuilder.append(",");
            }
        }
        arrayBuilder.append("\n]");

        log.info("\n" + arrayBuilder);
        return arrayBuilder.toString();
    }
}
