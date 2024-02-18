package com.investec.giftsefakoassessment.service;

import com.investec.giftsefakoassessment.enums.AddressType;
import com.investec.giftsefakoassessment.model.Address;

import java.util.List;

public interface AddressPrinterService {

    String prettyPrintAddress(Address address);
    String printAllAddressesByType(List<Address> addresses, AddressType addressType);
}
