package com.investec.giftsefakoassessment.service.impl;

import com.investec.giftsefakoassessment.service.JsonFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class JsonFileServiceImpl implements JsonFileService {

    private final ResourceLoader resourceLoader;

    @Override
    public String loadJsonFile(String fileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:addresses/" + fileName);
            InputStream inputStream = resource.getInputStream();
            return readFromInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readFromInputStream(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
