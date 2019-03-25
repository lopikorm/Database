package com.company.output;

import java.io.FileOutputStream;

public class WriteFile {
    public static void writeFile(String content, String fileName) {
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(fileName);
            for (char symbol : content.toCharArray()) {
                outputStream.write((int) symbol);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
