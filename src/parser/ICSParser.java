package parser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ICSParser {

    private Scanner fileReader;

    public ICSParser(String filePath) {
        try {
            fileReader = new Scanner(new URL(filePath).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFile() throws IOException {
        while(fileReader.hasNextLine()){
            System.out.println(fileReader.nextLine());
        }
    }

    public void printNextLine() {
        if(fileReader.hasNextLine()) {
            System.out.println(fileReader.nextLine());
        }
    }

    public String searchNextKey(String key) {
        String line = "END";
        while(fileReader.hasNextLine() && !key.equals(getKey((line = fileReader.nextLine()))));
        return getValue(line);
    }

    private String getKey(String line) {
        return line.split(":")[0];
    }

    private String getValue(String line) {
        try {
            return line.split(":")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    public static Date parseICSTimestamp(String icsTimestamp) {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss").parse(icsTimestamp, new ParsePosition(0));
    }



}
