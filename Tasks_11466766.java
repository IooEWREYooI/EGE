import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
import java.util.*;
public class Tasks_11466766 {

    public static void main(String[] args) throws IOException {

    }
    static void task25(){
            int count = 0;
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 174457; i <= 174505; i++){
                ArrayList<Integer> listDelimetr = new ArrayList<>();
                for (int ii = 1; ii < i; ii++){
                    if (i % ii == 0 && ii != 1) {
                        listDelimetr.add(ii);
                    }
                }
                map.put(i,listDelimetr);
            }
            for (int i = 174457; i <= 174505; i++){
                if (map.get(i).size() == 2)
                    System.out.println(map.get(i).get(0) + " " +map.get(i).get(1));
            }
        }
    static void task27(String fileName) throws IOException {
            String[] array = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\"+fileName+".txt")).readAllBytes()).replaceAll("\\r","").split("\\n");
            ArrayList<Integer> listOne = new ArrayList<>();
            ArrayList<Integer> listTwo = new ArrayList<>();
            for (int i = 1; i < array.length; i++) {
                String[] elements = array[i].split("  ");
                listOne.add(Integer.parseInt(elements[0]));
                listTwo.add(Integer.parseInt(elements[1]));
            }
            ArrayList<Integer> summs = new ArrayList<>();
            for (int x = 0; x < listOne.size(); x++) {
                int summ = 0;
                for (int y = 0; y < listTwo.size(); y++) {
                    if (x != y){
                        summ = (x + y) + summ;
                    }
                }
                summs.add(summ);
            }
            System.out.println(summs);
        }
    static void task26() throws IOException{
            String[] array = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\26.txt")).readAllBytes()).replaceAll("\\r","").split("\\n");
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < array.length; i++)
                list.add(Integer.parseInt(array[i]));
            List<Integer> arifList = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int one = list.get(i);
                    int two = list.get(j);
                    int arif = (one + two) / 2;
                    if (one % 2 == 0 && two % 2 == 0) {
                        if (list.contains(arif)) {
                            arifList.add(arif);
                        }
                    }
                }
            }
            System.out.println("count = "+arifList.size()+" max = "+Collections.max(arifList));
        }
    static void task17() throws IOException {
            String[] array = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\17.txt")).readAllBytes()).replaceAll("\\r","").split("\\n");
            List<Integer> list = new ArrayList<>();
            for (String i : array)
                list.add(Integer.parseInt(i));
            long count = 0;
            long max = Long.MIN_VALUE;
            for (int i = 0; i < list.size() -1 ; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int one = list.get(i);
                    int two = list.get(j);
                    int summ = one + two;
                    int delimetr_one = one % 160;
                    int delimetr_two = two % 160;
                    if ((delimetr_one != delimetr_two) && (one % 7 == 0 || two % 7 == 0)){
                        count++;
                        if (summ > max)
                            max = summ;
                    }
                }
            }
            System.out.println("count = "+count+" max = "+max);
        }
    static void task14() {
            long count = 0;
            BigInteger bigInt = new BigInteger("4").pow(511).add(new BigInteger("2").pow(511)).add(new BigInteger("-511"));
            String biteStr = bigInt.toString(2);
            for (String i : biteStr.split("")){
                if (i.equals("1"))
                    count++;
            }
            System.out.println(count);
        }
    static int F(int n){
            if (n == 1)
                return 2;
            if (n >= 2)
                return F(n - 1) * n;
            else return 0;
        }
    static String task12(String str){
            while (str.contains("7777") || str.contains("3333")){
                if (str.contains("3333"))
                    str = str.replaceFirst("3333","77");
                else
                    str = str.replaceFirst("7777","33");
            }
            return str;
        }
    static void task9() throws IOException {
            String[] array = new String(new FileInputStream(new File("C:\\Users\\Яков Мануилов\\Desktop\\test_2.txt")).readAllBytes()).replaceAll("\\r", "").replaceAll(",",".").split("\t");
            ArrayList<Double> list = new ArrayList<>();
            int ii = 0;
            for (String i : array) {
                try {
                    double num = Double.parseDouble(array[ii++]);
                    list.add(num);
                } catch (Exception e){}
            }
            double max = Collections.max(list);
            double arif = 0;
            for (double x : list){
                arif = arif + x;
            }
            arif = Double.parseDouble(new DecimalFormat("#0.0").format(arif / list.size()).replaceAll(",","."));
            int count = 0;
            for (double x : list){
                if ((x > (arif / 2)) && (x < (max / 2)))
                    count++;
            }
            System.out.println(count);


        }
    static void task8(){
            Map<Integer,String> map = new HashMap<>();
            map.put(0,"Г");
            map.put(1,"О");
            map.put(2,"Д");
            int count = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 3; k++)
                        for (int l = 0; l < 3; l++)
                            for (int m = 0; m < 3; m++)
                                for (int n = 0; n < 3; n++){
                                    String format = String.format("%s%s%s%s%s%s", map.get(i),map.get(j),map.get(k),map.get(l),map.get(m),map.get(n));
                                    if (format.startsWith("Г") || format.startsWith("Д"))
                                        count++;
                                }
            System.out.println(count);
        }
    static void executeTask5(){
            int count = 0;
            for (Integer i = 1000; i < 10000; i++){
                if (i % 2 != 0 && task5(i) == 414
                        && Integer.parseInt(i.toString().split("")[0]) % 2 != 0
                        && Integer.parseInt(i.toString().split("")[1]) % 2 != 0
                        && Integer.parseInt(i.toString().split("")[2]) % 2 != 0
                        && Integer.parseInt(i.toString().split("")[3]) % 2 != 0) {
                    count++;
                    System.out.println(i);
                }
            }
            System.out.println(count);
        }
    static int task5(int num){
            String[] arrayStr = String.valueOf(num).split("");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(arrayStr[0]) + Integer.parseInt(arrayStr[1]));
            list.add(Integer.parseInt(arrayStr[2]) + Integer.parseInt(arrayStr[3]));
            Collections.sort(list);
            return Integer.parseInt(list.get(0) + "" + list.get(1));
        }
    static void task2(){
        /*
    def task_2():
    print("y x w z")
    for x in range(0, 2):
        for y in range(0, 2):
            for z in range(0, 2):
                for w in range(0, 2):
                    if not ((x and (not y)) or (y == z) or w):
                        print(y, x, w, z)
         */
            System.out.println("y x w z");
            for (int x = 0; x < 2; x++)
                for (int y = 0; y < 2; y++)
                    for (int z = 0; z < 2; z++)
                        for (int w = 0; w < 2; w++){
                            if (!(((x == 1)  && (y == 0)) || (y == z) || (w == 1))) {
                                System.out.println(y+" "+x+" "+w+" "+z);
                            }
                        }
/*
y x w z
0 0 0 1
1 0 0 0
1 1 0 0
 */
        }
}

