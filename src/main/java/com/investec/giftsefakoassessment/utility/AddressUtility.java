package com.investec.giftsefakoassessment.utility;

import com.investec.giftsefakoassessment.model.*;

import javax.json.*;
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

                JsonString idJsonString = jsonObject.getJsonString("id");
                address.setId(idJsonString != null ? idJsonString.getString() : null);

                JsonString cityOrTownJsonString = jsonObject.getJsonString("cityOrTown");
                address.setCityOrTown(cityOrTownJsonString != null ? cityOrTownJsonString.getString() : null);

                JsonString postalCodeJsonString = jsonObject.getJsonString("postalCode");
                address.setPostalCode(postalCodeJsonString != null ? postalCodeJsonString.getString() : null);

                JsonString lastUpdatedJsonString = jsonObject.getJsonString("lastUpdated");
                address.setLastUpdated(lastUpdatedJsonString != null ? lastUpdatedJsonString.getString() : null);

                JsonString suburbOrDistrictJsonString = jsonObject.getJsonString("suburbOrDistrict");
                address.setSuburbOrDistrict(suburbOrDistrictJsonString != null ? suburbOrDistrictJsonString.getString() : null);

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

                JsonObject provinceOrStateJson = jsonObject.getJsonObject("provinceOrState");
                if (provinceOrStateJson != null) {
                    ProvinceOrState provinceOrState = new ProvinceOrState();
                    provinceOrState.setCode(jsonObject.getJsonObject("provinceOrState").getString("code"));
                    provinceOrState.setName(jsonObject.getJsonObject("provinceOrState").getString("name"));

                    address.setProvinceOrState(provinceOrState);
                }

                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
