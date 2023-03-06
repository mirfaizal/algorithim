package com.basicjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class HackerRank {




    public static void main(String[] args) throws IOException {
        String a[] = new String[]{"ab","dc","ef"};

        List list1 = Arrays.asList(a);
        String b[] = new String[]{"af","ee","ef"};

        List list2 = Arrays.asList(b);
        commonSubstring(list1,list2);
////        System.out.println(countingClosedPaths(649578));
////        inheritance();
////        System.out.println(findValidPairs(new int[] {1,1,2,2,3,3}, 1));
//
//        BufferedReader br=new BufferedReader(new InputStreamReader(in));
//        int n1=Integer.parseInt(br.readLine());
//        int n2=Integer.parseInt(br.readLine());
//        int n3=Integer.parseInt(br.readLine());
//        int n4=Integer.parseInt(br.readLine());
//        int n5=Integer.parseInt(br.readLine());
//        Prime ob=new Prime();
//        ob.checkPrime(n1);
//        ob.checkPrime(n1,n2);
//        ob.checkPrime(n1,n2,n3);
//        ob.checkPrime(n1,n2,n3,n4,n5);

    }

    public static void commonSubstring(List<String> a, List<String> b) {


        for(int i=0;i<a.size();i++) {

            String first = a.get(i);
            String second = b.get(i);
            boolean matchFound = false;
            outer :
            for(char ch1 : first.toCharArray()){
                for(char ch2 : second.toCharArray()){
                    if(ch1 == ch2) {
                        matchFound = true;
                        break outer;
                    }
                }
            }
            if(!matchFound){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }



    }

    private static int findValidPairs(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;
        for(int i=0;i<array.length;i++){
            int value = array[i] + k;
            if(map.containsKey(value)){
                pairCount++;
            } else {
                map.put(array[i]+k,array[i]);
                array[i] = 0;
            }
        }
        return pairCount;
    }

    private static void inheritance() {
        List<String> list = new ArrayList<>(Arrays.asList("Square","Hexagon","Rhombus","Circle","Rectangle"));
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> listOfShape = new ArrayList<>();
        for(String s : list) {
            listOfShape.add(shapeFactory.getShape(s));
        }
        System.out.println();
        System.out.println();
        int index = 0;
        for (Shape sh : listOfShape){
            if(sh != null) System.out.println(sh.drawShape());
            else System.out.println(String.format("Drawing %s is not supported", list.get(index)));
            index++;
        }
    }

    public static float addTwo(int a , int b){
        float res = a + b;
        return res /2;
    }
    public static int countingClosedPaths(int number){
        int count = 0;
        int quotient = number;
        while(quotient >= 10){
            int reminder = quotient % 10;
            quotient = quotient /10;
            count = getCount(count, reminder);
        }
        count = getCount(count, quotient);
        return count;
    }

    private static int getCount(int count, int reminder) {
        if(reminder == 0 || reminder == 4 || reminder == 6 || reminder ==9){
            count++;
        } else if(reminder == 8){
            count+=2;
        }
        return count;
    }
}

interface Shape {
    String drawShape();
}
class Circle implements Shape {
    Circle(){
        System.out.println("Drawing a Circle");
    }
    @Override
    public String drawShape() {
        return "Drawing a Circle";
    }
}
class Square implements Shape {
    Square(){
        System.out.println("Drawing a Square");
    }
    @Override
    public String drawShape() {
        return "Drawing a Square";
    }
}
class Rectangle implements Shape {
    Rectangle(){
        System.out.println("Drawing a Rectangle");
    }
    @Override
    public String drawShape() {
        return "Drawing a Rectangle";
    }
}
final class ShapeFactory {

    public  Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        } else if (shapeType.equals("Square")) {
            return new Square();
        } else if (shapeType.equals("Circle")) {
            return new Circle();
        } else if (shapeType.equals("Rectangle")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
