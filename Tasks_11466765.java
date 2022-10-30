import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Tasks_11466765 {
    public static void main(String[] args) throws IOException {
    }
    static void task25_47229_not_correct(){
        ArrayList<Long> list = new ArrayList<>();
        String mask = "1?2139*4";
        for (int i = 0; i < new BigInteger("10").pow(10).intValue(); i++){
            String mask1 = mask.replaceAll("\\*",""+i);
            int ii = 0;
            while (ii++ <= 9){
                String mask2 = mask1.replaceAll("\\?",""+ii);
                long num = Long.parseLong(mask2);
                if (num % 2023 == 0)
                    list.add(num);
            }
        }
        Collections.sort(list);
        list.forEach(x -> System.out.println(x+" "+(x / 2023)));
/*
Назовём маской числа последовательность цифр, в которой также могут встречаться следующие символы:
    — символ «*» означает любую последовательность цифр произвольной длины; в том числе «*» может задавать и пустую последовательность.
    — символ «?» означает ровно одну произвольную цифру;
Например, маске 123*4?5 соответствуют числа 123405 и 12300405.
Среди натуральных чисел, не превышающих 10^10, найдите все числа, соответствующие маске 1?2139*4, делящиеся на 2023 без остатка.
В ответе запишите в первом столбце таблицы все найденные числа в порядке возрастания, а во втором столбце — соответствующие им результаты деления этих чисел на 2023.
 */
    }
    static void task24_27692()throws IOException{
        String[] fileArray = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\24.txt")).readAllBytes()).replaceAll("\r","").split("");
        Iterator<String> fileIter = Arrays.stream(fileArray).iterator();
        int count = 0;
        ArrayList<Integer> counts = new ArrayList<>();
        while (fileIter.hasNext()){
            while (fileIter.next().equals("B")){
                count++;
            }
            counts.add(count);
            count = 0;
        }
        System.out.println(Collections.max(counts));
    }
    static void task17_47221()throws IOException {
        String[] file = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Downloads\\17.txt")).readAllBytes()).replaceAll("\r", "").split("\n");
        ArrayList<Integer> list = new ArrayList<>();
        Integer max = 0;
        for (String i : file) {
            Integer element = Integer.parseInt(i);
            list.add(element);
            if (max < element && element.toString().endsWith("3"))
                max = element;
        }
        Integer maxSqrt = max * max;
        int count = 0;
        ArrayList<Integer> maximus = new ArrayList<>();
        for (Integer i = 0; i < list.size() - 1; i++) {
            Integer firstElement = list.get(i);
            Integer secondElement = list.get(i + 1);
            if (firstElement.toString().endsWith("3") && !secondElement.toString().endsWith("3") || secondElement.toString().endsWith("3") && !firstElement.toString().endsWith("3")) {
                Integer sumSqrtOfElements = (firstElement * firstElement) + (secondElement * secondElement);
                if (sumSqrtOfElements > maxSqrt) {
                    count++;
                    maximus.add(sumSqrtOfElements);
                }
            }

        }
        System.out.println("count = " + count + " max = " + Collections.max(maximus));
    }
    static int F(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        return F(n - 3) * n;
    }
    static void task14_16892(){
       //125 4 + 25 8 − 30
        BigInteger bigInt = new BigInteger("125").pow(4).add(new BigInteger("25").pow(8)).add(new BigInteger("-30"));
        String bigIntRadix5 = bigInt.toString(5);
        int count = 0;
        for (String i : bigIntRadix5.split(""))
            if (i.equals("4"))
                count++;
        System.out.println(count);
    }
    static void task12_13490(String str){
        while (str.contains("81") || str.contains("882") || str.contains("8883")){
            if (str.contains("81"))
                str = str.replaceFirst("81","2");
            else if (str.contains("882"))
                str = str.replaceFirst("882","3");
            else
                str = str.replaceFirst("8883","1");
        }
        System.out.println(str);
    }
    static void task9_35898() throws IOException {
        String[] fileStr = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\9.txt")).readAllBytes()).replaceAll("\r","").replaceAll(",",".").split("\n");
        ArrayList<Double> list = new ArrayList<>();
        for (String i : fileStr) {
            String[] array = i.split("\t");
            for (String ii : array)
                list.add(Double.parseDouble(ii));
        }
        int count = 0;
        for (int i = list.size() - 1; i > 0; i--){
            double that = list.get(i);
            double beforeThat = list.get(i - 1);
            if ((beforeThat - that) >= 2){
                count++;
            }
        }
        System.out.println(count);

    }
    static void task8_7667(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"Е");
        map.put(1,"Г");
        map.put(2,"Э");
        int count = 0;
        for (int x1 = 0; x1 < 3; x1++)
            for (int x2 = 0; x2 < 3; x2++)
                for (int x3 = 0; x3 < 3; x3++)
                    for (int x4 = 0; x4 < 3; x4++)
                        for (int x5 = 0; x5 < 3; x5++){
                            String format = String.format("%s%s%s%s%s",map.get(x1),map.get(x2),map.get(x3),map.get(x4),map.get(x5));
                            if (!format.startsWith("Г"))
                                count++;
                        }
        System.out.println(count);
    }
    static void task5_8094(int N){
        String binaryN = Integer.toBinaryString(N);
        int sum = 0;
        for (int ii = 0; ii < 2; ii++) {
            for (String i : binaryN.split("")) {
                sum += Integer.parseInt(i);
            }
            binaryN = binaryN + (sum % 2);
            sum = 0;
        }
        System.out.println(Integer.parseInt(binaryN,2));
    }
}
