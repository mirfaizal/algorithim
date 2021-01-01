package com.algorithim.datastructure.string;

public class URLConverter {
    public static void main(String[] args) {
        URLConverter urlConverter = new URLConverter();
        System.out.println(urlConverter.urlify("My Home Page    "));
    }

    private String urlify(String string) {
        string = string.trim();
        string = string.replace(" ", "%20");
        return string;
    }
}
