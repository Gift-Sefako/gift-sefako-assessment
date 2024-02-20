package com.investec.giftsefakoassessment.utility;

import com.investec.giftsefakoassessment.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddressUtilityTest {

    @Mock
    private JsonReader jsonReaderMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testParseJsonStringToAddresses_correctInput() {
        String jsonStringArray = "[   {\n" +
                "        \"id\": \"1\",\n" +
                "        \"type\": {\n" +
                "            \"code\": \"1\",\n" +
                "            \"name\": \"Physical Address\"\n" +
                "        },\n" +
                "        \"addressLineDetail\": {\n" +
                "            \"line1\": \"Address 1\",\n" +
                "            \"line2\": \"Line 2\"\n" +
                "        },\n" +
                "        \"provinceOrState\": {\n" +
                "            \"code\": \"5\",\n" +
                "            \"name\": \"Eastern Cape\"\n" +
                "        },\n" +
                "        \"cityOrTown\": \"City 1\",\n" +
                "        \"country\": {\n" +
                "            \"code\": \"ZA\",\n" +
                "            \"name\": \"South Africa\"\n" +
                "        },\n" +
                "        \"postalCode\": \"1234\",\n" +
                "        \"lastUpdated\": \"2015-06-21T00:00:00.000Z\"\n" +
                "    } ]";

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("id", "1")
                .add("cityOrTown", "City 1")
                .add("postalCode", "1234")
                .add("lastUpdated", "2015-06-21T00:00:00.000Z")
                .add("type", Json.createObjectBuilder()
                        .add("code", "1")
                        .add("name", "Physical Address"))
                .add("addressLineDetail", Json.createObjectBuilder()
                        .add("line1", "Address 1")
                        .add("line2", "Line 2"))
                .add("country", Json.createObjectBuilder()
                        .add("code", "ZA")
                        .add("name", "South Africa"))
                .build();

        JsonArray jsonArray = Json.createArrayBuilder().add(jsonObject).build();

        when(jsonReaderMock.readArray()).thenReturn(jsonArray);

        List<Address> addresses = AddressUtility.parseJsonStringToAddresses(jsonStringArray);

        assertEquals(1, addresses.size());

        Address address = addresses.get(0);
        assertEquals("1", address.getId());
        assertEquals("City 1", address.getCityOrTown());
        assertEquals("1234", address.getPostalCode());
        assertEquals("2015-06-21T00:00:00.000Z", address.getLastUpdated());
        assertEquals("1", address.getType().getCode());
        assertEquals("Physical Address", address.getType().getName());
        assertEquals("Address 1", address.getAddressLineDetail().getLine1());
        assertEquals("Line 2", address.getAddressLineDetail().getLine2());
        assertEquals("ZA", address.getCountry().getCode());
        assertEquals("South Africa", address.getCountry().getName());
    }


    @Test
    void testParseJsonStringToAddresses_someNullValuesShouldStillParse() {
        String jsonStringArray = "[   {\n" +
                "        \"id\": \"1\",\n" +
                "        \"type\": {\n" +
                "            \"code\": \"1\",\n" +
                "            \"name\": \"Physical Address\"\n" +
                "        },\n" +
                "        \"addressLineDetail\": {\n" +
                "            \"line1\": \"Address 1\",\n" +
                "            \"line2\": \"Line 2\"\n" +
                "        },\n" +
                "        \"provinceOrState\": {\n" +
                "            \"code\": \"5\",\n" +
                "            \"name\": \"Eastern Cape\"\n" +
                "        },\n" +
                "        \"cityOrTown\": \"City 1\",\n" +
                "        \"postalCode\": \"1234\",\n" +
                "        \"lastUpdated\": \"2015-06-21T00:00:00.000Z\"\n" +
                "    } ]";

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("id", "1")
                .add("postalCode", "1234")
                .add("lastUpdated", "2015-06-21T00:00:00.000Z")
                .add("type", Json.createObjectBuilder()
                        .add("code", "1")
                        .add("name", "Physical Address"))
                .add("addressLineDetail", Json.createObjectBuilder()
                        .add("line1", "Address 1")
                        .add("line2", "Line 2"))
                .build();

        JsonArray jsonArray = Json.createArrayBuilder().add(jsonObject).build();

        when(jsonReaderMock.readArray()).thenReturn(jsonArray);

        List<Address> addresses = AddressUtility.parseJsonStringToAddresses(jsonStringArray);

        assertEquals(1, addresses.size());

        Address address = addresses.get(0);
        assertEquals("1", address.getId());
        assertEquals("City 1", address.getCityOrTown());
        assertEquals("1234", address.getPostalCode());
        assertEquals("2015-06-21T00:00:00.000Z", address.getLastUpdated());
        assertEquals("1", address.getType().getCode());
        assertEquals("Physical Address", address.getType().getName());
        assertEquals("Address 1", address.getAddressLineDetail().getLine1());
        assertEquals("Line 2", address.getAddressLineDetail().getLine2());
        assertNull(address.getCountry());
    }
}
