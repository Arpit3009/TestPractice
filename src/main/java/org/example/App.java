package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.Duration;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static WebDriver driver;

    public static LandingPage land;
    public static CaptchaPage capage;


    public static void main( String[] args ) throws InterruptedException, IOException {
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://demo.nopcommerce.com/");
////        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        land = new LandingPage(driver);
////        capage = new CaptchaPage(driver);
////        land.takeScreenshot();
////        land.takeCompleteScreenshot();
////        System.out.println(land.isBothElementDisplayed());
////        System.out.println(land.refreshBrowserUsingActionClass());
////        capage.handleCaptcha();
////        OverridingClss1 obj = new OverridingClss1();
////        obj.xyz();
//
////        System.out.println(isPrime(13));
////        swapNumberWithout(4,5);
////        swapStringWithout("cat", "dog");
////        System.out.println(thirdLargestNumber(new int [] {1, 4, 8, 3, 5, 33, 60, 56}));
////        System.out.println(getDay(5));
////        System.out.println(getDay(2));
////        printPattern1(5);
////        printPattern2(5);
////        printPattern3(5);
////        printPattern4(5);
////        printPattern5(5);
////        printPattern6(5);
////        printPattern7(5);
////        printPattern8(5);
////        System.out.println(removeDuplicateChar("hvbshmbs"));
////        System.out.println(reverseStringWithout("cat"));
////        swapStringUsingSubstring("cat", "dog");
////        printButterfly(4);
////        pattern11(5);
////        pattern12(5);
////        pattern13(5);
////        pattern14(5);
////        String s1 = new String("ag");
////        String s2 = new String("ag");
////        System.out.println(s1==s2);
//
////        File file = new File(System.getProperty("user.dir")+"/abc.txt");
////        new File(System.getProperty("user.dir")+"/testFolder").mkdir();
////        File ff = new File(System.getProperty("user.dir")+"/testFolder");
////        System.out.println(ff.isDirectory());
////        System.out.println(ff.listFiles().length);
////        if(file.createNewFile()){
////            System.out.println("file created");
////        }
////        else{
////            System.out.println("file exists");
////        }
////
////        FileWriter writer = new FileWriter(file, true);
////        BufferedWriter bf = new BufferedWriter(writer);
////        writer.write("kjfbkj\n");
////        bf.newLine();
////        writer.write("text\n");
////        writer.write("again");
////        writer.close();
////
////        FileReader fr = new FileReader(file);
////        BufferedReader br = new BufferedReader(fr);
////        String line;
////        while((line = br.readLine())!= null){
////            System.out.println(line);
////        }
//            maxProduct(new int [] {1, 5, 3, -78, 52, 90,  5, 55, 4, 2, 0, -67});
//        findConsecutiveOnes(new int [] {0, 0,0,0,0,0,0, 1, 0, 0, 0, 1,1,1,1, 0, 1,1});
//        reverseArrayInGroup(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 11);
    }

    public static boolean isPrime(int x){
        int y = 2;
        while(y<x/2) {
            if (x%y==0){
                return false;
            }
            y++;
        }
        return true;
    }

    public static void swapNumberWithout(int a, int b){
        a = a^b;
        b = b^a;
        a = a^b;
        System.out.println("a : " + a + " b : " + b);
    }

    public static void swapStringWithout(String a, String b){
        char [] aArr = a.toCharArray();
        char [] bArr = b.toCharArray();
        int i = 0;
        while ( i < a.length()) {
            aArr[i] = (char) (aArr[i]^bArr[i]);
            bArr[i] = (char) (bArr[i]^aArr[i]);
            aArr[i] = (char) (aArr[i]^bArr[i]);
            i++;
        }

        System.out.println(" a : " + new String(aArr) + " b : " + new String(bArr) );
    }

    public static int thirdLargestNumber(int [] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i =0; i<arr.length;i++){
            if(arr[i]>first){
                third = second;
                second = first;
                first = arr[i];
            }
            else if(arr[i]<first && arr[i] > second) {
                third = second;
                second = arr[i];
            }
            else if(arr[i]<second && arr[i]>third){
                third = arr[i];
            }
        }
        return third;
    }

    public static String getDay(int n){
        String day = null;
        switch (n) {
            case 1:
                day = "sunday";
                break;
            case 2:
                day = "monday";
                break;
            default:
                day = "tuesday";
                break;
        }
        return day;
    }

    public static void printPattern1(int n){
        int j =0;
        for(int i =0 ; i< n-1; i++){
            for(;j<n;j++){
                System.out.print("*");
            }
            j=0;
            System.out.print("\n");
        }
    }

    public static void printPattern2(int n) {
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            for (; j < n; j++) {
                if(i==0 || i==n-2) {
                    System.out.print("*");
                }
                else if(j==0 || j == n-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            j = 0;
            System.out.print("\n");
        }
    }

    public static void printPattern3(int n) {
        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= i ;j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printPattern4(int n) {
        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n ;j ++){
                if(j >= n-i + 1) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printPattern5(int n) {
        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= i ;j ++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printPattern6(int n) {
        for (int i = n; i >= 1 ; i--) {
            for(int j = 1; j <= i ;j ++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printPattern7(int n) {
        int k = 1;
        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= i ;j ++){
                System.out.print(k);
                k++;
                if(i!=1 && j!=1 || j!=i){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printPattern8(int n) {
        int k = 1;
        for (int i = 1; i <= n ; i++) {
            for(int j = 1; j <= i ;j ++){
                System.out.print(k);
                if(k == 1){
                    k = 0;
                }else{
                    k = 1;
                }
            }
            System.out.println();
        }
    }

    public static List<Character> getDuplicateChar(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> li = new ArrayList<Character>();
        for(int i =0; i<str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue()>1){
                li.add(m.getKey());
            }
        }
        return li;
    }

    public static String removeDuplicateChar(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String st = "";
        for(int i =0; i<str.length(); i++){
            if(!map.containsKey(str.charAt(i))){
                st = st + str.charAt(i);
                map.put(str.charAt(i), 1);
            }
        }
        return st;
    }

    public static String reverseString(String str){
        String st = "";
        for(int i = str.length() -1 ; i>=0; i--){
            st = st + str.charAt(i);
        }
        return st;
    }

    public static String reverseStringWithout(String str){
        int i =0;
        int j = str.length() - 1;
        char[]arr = str.toCharArray();
        while(i<j){
            arr[i] = (char) (arr[i]^arr[j]);
            arr[j] = (char) (arr[j]^arr[i]);
            arr[i] = (char) (arr[i]^arr[j]);
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void swapStringUsingSubstring(String a, String b){
        int x = a.length();
        int y = b.length();
        a = a +b;
        b = a.substring(0, x);
        a = a.substring(x, x+y);
        System.out.println(" a :" + a + " b : " + b);
    }

    public static void printButterfly(int n){
        int x = 2*n;
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= x; j++){
                if(j <= i || j> x - i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int i = n; i>=1; i--){
            for(int j = x; j>=1; j--){
                if(j <= i || j> x - i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void pattern11(int n){
        for(int i = 1; i<= n; i++){
            for(int j =1; j<= 2*n -i ; j++){
                if(j<n -i + 1){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void pattern12(int n){
        int count = 0;
        int c = n+1;
        for(int i =1 ; i<= n; i++){
            if(i%2 != 0){
                for(int j =1; j<= n; j++){
                    int k = n - i ;
                    int v = k/2;
                    if(j <= v){
                        System.out.print(" ");
                        count ++;
                    }
                    else if( v == count && j<= n-v){
                        System.out.print(i);
                    }
                }
            }
            else {

                for(int j =1; j<= c; j++){
                    int k = c - i ;
                    int v = k/2;
                    if(j <= v){
                        System.out.print(" ");
                        count ++;
                    }
                    else if( v == count && j<= c-v){
                        System.out.print(i);
                    }
                }
            }

            count = 0;
            System.out.println();

        }
    }

    public static void pattern13(int n){
        for(int i = 1 ; i<= n; i++){
            for(int j = 1; j<= 2*n -1; j++){
                if(j<=n-i){
                    System.out.print(" ");
                }
                else if(j == n-i+1 || j< n+i){
                    if(i%2!=0 && j%2!=0 || i%2 == 0 && j%2==0){
                        System.out.print(i);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }


    public static void pattern14(int n){
        for(int i = 1; i<=n; i++){
            for(int j = n; j>=1; j--){
                if(j > i){
                    System.out.print(" ");
                }
                else{
                    System.out.print(j);
                }
            }
            for(int j = 2; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void sortArr(int [] arr){
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i ++){
            for(int j =0; j<arr.length -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i : arr){
            System.out.println(i);
        }
    }

    //find max product of three number in array
    public static void maxProduct(int arr []) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i]< max1 && arr[i]> max2) {
                max3= max2;
                max2 = arr[i];
            } else if (arr[i]<max2 && arr[i]>max3) {
                max3 = arr[i];
            }

            if(arr[i]<min1){
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i]<min2 && arr[i]>min1) {
                min2 = arr[i];
            }
        }
        System.out.println(Math.max(min1 * min2 * max1, max1 * max2 * max3));
    }

    public static void findConsecutiveOnes(int arr[]){
        int fs = 1;
        int se = 1;
        int sed = 1;
        for(int i = 0; i<arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                fs++;
            }
            else{
                if(se < fs){
//                    sed = se;
                    se = fs;
                }
                fs = 1;
            }
        }
        if(fs>se){
            se = fs;
        }
        System.out.println(se);
    }

    public static void reverseArrayInGroup(int arr[], int k){
        int x = 0;
        int y = k-1;
        int temp = 0;
        int c = arr.length/k;
        int g = c;
        while(c>0){
            int a = x;
            int b = y;
            while(x<y){
                temp = arr [x];
                arr[x] = arr[y];
                arr[y] = temp;
                x++;
                y--;
            }
            x = k + a;
            y = k+b;
            c--;
        }
        if(arr.length%k != 0){
            int z = arr.length%k;
            System.out.println("y"+y);
            int r = k*g;
            int e = arr.length - 1;
            while(r<e){
                temp = arr [r];
                arr[r] = arr[e];
                arr[e] = temp;
                r++;
                e--;
            }
        }
        for(int i: arr){
            System.out.println(i);
        }
    }

}