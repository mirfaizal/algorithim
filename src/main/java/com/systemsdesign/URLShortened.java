package com.systemsdesign;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class URLShortened {
    static Map<String,String>  map = new HashMap<>();
    static int counter = 999999;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many operations :");
        int numberOfOperations = scan.nextInt();
        for(int i=0;i<numberOfOperations;i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1. Create new shortened URL");
            System.out.println("2. Get back long URL by using shortened URL");
            int choice = scan.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(choice == 1){
                // Encode
                System.out.println("Enter Long URL : ");
                String longUrl = scan.next();
                System.out.println("Short URL is :"+ encode_counter(longUrl));
            } else {
                // Decode
                System.out.println("Enter Short URL : ");
                String shortUrl = scan.next();
                System.out.println("Long URL is :"+ decode_counter(shortUrl));
            }
        }
    }

    private static String encode_counter(String longUrl) throws MalformedURLException {
        URL url = new URL(longUrl);
        StringBuilder prefix = new StringBuilder();
        prefix.append(url.getProtocol()).append("://").append(url.getHost()).append("/");
        String path = url.getPath();
        counter++;
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";
        StringBuilder shortURL = new StringBuilder();
        int currentval = counter;
        int base = 64;
        while(currentval >= base){
            int remainder = currentval % base;
            int quotient = currentval / base;
            shortURL.append(characters.charAt(remainder));
            currentval = quotient;
        }
        if(currentval > 0){
            shortURL.append(characters.charAt(currentval));
        }
        shortURL.reverse();
        map.put(shortURL.toString(),path);
        return prefix.append(shortURL).toString();
    }
    private static String decode_counter(String longUrl) throws MalformedURLException {
        URL url = new URL(longUrl);
        StringBuilder prefix = new StringBuilder();
        prefix.append(url.getProtocol()).append("://").append(url.getHost());
        String path = url.getPath();
        if(!map.containsKey(path.substring(1))) {
            return "Path not exist";
        }
        return prefix.append(map.get(path.substring(1))).toString();
    }
}
