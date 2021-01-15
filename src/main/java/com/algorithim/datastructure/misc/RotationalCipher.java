package com.algorithim.datastructure.misc;

// Add any extra import statements you may need here


class RotationalCipher {

    // Add any helper functions you may need here


    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            int offset;
            int rotateChar;
            if(c>=48 && c<= 57){
                offset = rotationFactor % 10;
                rotateChar = c + offset;
                if(rotateChar > 57) {
                    int i = 48 + (rotateChar - 58);
                    c =(char) i;
                } else{
                    c+=offset;
                }
            } else if(c>=65 && c<= 90){
                offset = rotationFactor % 26;
                rotateChar = c + offset;
                if(rotateChar > 90) {
                    int i = 65 + (rotateChar - 91);
                    c =(char) i;
                } else{
                    c+=offset;
                }
            } else if(c>=97 && c<= 122){
                offset = rotationFactor % 26;
                rotateChar = c + offset;
                if(rotateChar > 122) {
                    int i = 97 + (rotateChar - 123);
                    c =(char) i;
                } else{
                    c+=offset;
                }
            }
            sb.append(c);
        }
        return sb.toString();

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
