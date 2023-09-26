import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanKey = new TreeMap<>();
    TreeMap<Integer, String> arabicKey = new TreeMap<>();
    public Converter() {
        romanKey.put('I', 1);
        romanKey.put('V', 5);
        romanKey.put('X', 10);

        arabicKey.put(100, "C");
        arabicKey.put(90, "XC");
        arabicKey.put(50, "L");
        arabicKey.put(40, "XL");
        arabicKey.put(10, "X");
        arabicKey.put(9, "IX");
        arabicKey.put(5, "V");
        arabicKey.put(4, "IV");
        arabicKey.put(1, "I");
    }
    //  Определяет римское число или нет
    public boolean isRoman(String number) {
        return romanKey.containsKey(number.charAt(0));
    }
    // Переделывает Арабские в Римские
    public String arabicToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        int arabicNum;
        do {
            arabicNum = arabicKey.floorKey(number);
            roman.append(arabicKey.get(arabicNum));
            number -= arabicNum;
        } while (number !=0);
        return roman.toString();
    }
    // Преобразует Римские в Арабские
    public int romanToArabic(String s) {
        int end = s.length() -1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKey.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKey.get(arr[i]);
            if (arabian < romanKey.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        } return result;
    }

}