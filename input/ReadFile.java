package com.company.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static String readFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int intSymbol = inputStream.read();
                char symbol = (char)intSymbol;
                
                result.append(symbol);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return result.toString();
    }





}
