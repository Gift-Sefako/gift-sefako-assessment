package com.investec.giftsefakoassessment.utility;

import com.investec.giftsefakoassessment.model.Address;
import com.investec.giftsefakoassessment.model.AddressLineDetail;
import com.investec.giftsefakoassessment.model.AddressType;
import com.investec.giftsefakoassessment.model.Country;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AddressUtility {

    public static List<Address> parseJsonStringToAddresses(String jsonStringArray) {

        List<Address> addresses = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new StringReader(jsonStringArray))) {

            JsonArray jsonArray = reader.readArray();
            for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
                Address address = new Address();
                address.setId(jsonObject.getString("id"));
                address.setCityOrTown(jsonObject.getString("cityOrTown"));
                address.setPostalCode(jsonObject.getString("postalCode"));
                address.setLastUpdated(jsonObject.getString("lastUpdated"));


                JsonObject addressTypeJson = jsonObject.getJsonObject("type");
                if (addressTypeJson != null) {
                    AddressType addressType = new AddressType();
                    addressType.setCode(jsonObject.getJsonObject("type").getString("code"));
                    addressType.setName(jsonObject.getJsonObject("type").getString("name"));
                    address.setType(addressType);
                }

                JsonObject addressLineDetailJson = jsonObject.getJsonObject("addressLineDetail");

                if (addressLineDetailJson != null) {

                    AddressLineDetail addressLineDetail = new AddressLineDetail();
                    addressLineDetail.setLine1(addressLineDetailJson.getString("line1"));
                    addressLineDetail.setLine2(addressLineDetailJson.getString("line2"));

                    address.setAddressLineDetail(addressLineDetail);
                }

                JsonObject countryJson = jsonObject.getJsonObject("country");
                if (countryJson != null) {
                    Country country = new Country();
                    country.setCode(jsonObject.getJsonObject("country").getString("code"));
                    country.setName(jsonObject.getJsonObject("country").getString("name"));

                    address.setCountry(country);
                }

                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
