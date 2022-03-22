package com.algorithim.datastructure.array;


import com.google.gson.JsonArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class FourBillion {
    /*
     * Asymptotic complexity in terms of size of `arr` `n`:
     * Time: O(n).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    static Long find_integer(ArrayList<Long> arr) {
        int size = (int)((Math.pow(2, 32)) / 8);
        byte[] bytes = new byte[size]; // Initialized with zeros by the JVM.
        for(long inputValue : arr) {
            int byteIndex = (int) (inputValue / 8);
            int bitIndex = (int) (inputValue % 8);
            // Set the bit corresponding to inputValue:
            bytes[byteIndex] |= 1 << bitIndex;
        }
        for(int byteIndex = 0; byteIndex < size; byteIndex++) {
            for(int bitIndex = 0; bitIndex < 8; bitIndex++) {
                if((bytes[byteIndex] & (1 << bitIndex)) == 0) {
                    // As soon as we have found the first unset bit,
                    // return the number corresponding to that bit.
                    return byteIndex * 8L + bitIndex;
                }
            }
        }
        throw new IllegalStateException(
                "Must have found an unset bit and returned from the loop");
    }}

class Result {

    static void output_int64(Long argument) throws IOException {
        output_string.append(argument);
    }


    static Long input_int64(Object data) {
        Long argument = new Long(data.toString());
        return argument;
    }


    static ArrayList<Long> input_list_int64(Object data) {
        JsonArray json_array = (JsonArray) data;
        ArrayList argument = new ArrayList<Long>();
        for (Object json_array_item: json_array) {
            argument.add(input_int64(json_array_item));
        }
        return argument;
    }


    private static final DecimalFormat float_formatter = new DecimalFormat("0.00");
    private static final StringBuilder output_string = new StringBuilder();
    public static void main(String[] args) throws Exception {

        ArrayList<Long> arr;
        try {
            ByteArrayOutputStream json_string = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = System.in.read(buffer)) != -1; ) {
                json_string.write(buffer, 0, length);
            }
            JSONObject data = new JSONObject(json_string.toString("UTF-8"));
            arr = input_list_int64(data.get("arr"));
        } catch (Exception ex) {
            System.err.println("reading-input-failed-json");
            ex.printStackTrace();
            throw ex;
        }

        PrintStream original_out = System.out;
        System.setOut(System.err);
        Long result = FourBillion.find_integer(arr);
        System.setOut(original_out);
        output_int64(result);
        output_string.append('\n');
        System.out.print(output_string.toString());
    }
}