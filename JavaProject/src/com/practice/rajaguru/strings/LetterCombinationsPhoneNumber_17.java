package com.practice.rajaguru.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {
    public static void main(String[] args) {

        int[] count = {0};
        new LetterCombinationsPhoneNumber_17().letterCombinations("234")
        .forEach((output) -> {
            count[0]++;
            System.out.print(output+"\t");
            if(count[0]%10 == 0) System.out.println();
        });


    }

    public  List<String> letterCombinations(String digits) {
        List<String> outputList = new ArrayList<>();
        String[] phoneNumbers = digits.split("");
        List<String> phoneNumberValues = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++)
            switch (phoneNumbers[i]) {
                case "2":
                    phoneNumberValues.add("abc");
                    break;
                case "3":
                    phoneNumberValues.add("def");
                    break;
                case "4":
                    phoneNumberValues.add("ghi");
                    break;
                case "5":
                    phoneNumberValues.add("jkl");
                    break;
                case "6":
                    phoneNumberValues.add("mno");
                    break;
                case "7":
                    phoneNumberValues.add("pqrs");
                    break;
                case "8":
                    phoneNumberValues.add("tuv");
                    break;
                case "9":
                    phoneNumberValues.add("wxyz");
                    break;
            }
        List<String> listOne = new ArrayList<>();
        listOne.add("");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("");
        List<String> listThree = new ArrayList<>();
        listThree.add("");
        List<String> listFour = new ArrayList<>();
        listFour.add("");

        if (phoneNumberValues.size() == 1) {
            load(phoneNumberValues,listOne,0);
        } else if (phoneNumberValues.size() == 2) {
            load(phoneNumberValues,listOne,0);
            load(phoneNumberValues,listTwo,1);
        } else if (phoneNumberValues.size() == 3) {
            load(phoneNumberValues,listOne,0);
            load(phoneNumberValues,listTwo,1);
            load(phoneNumberValues,listThree,2);
        } else if (phoneNumberValues.size() == 4) {
            load(phoneNumberValues,listOne,0);
            load(phoneNumberValues,listTwo,1);
            load(phoneNumberValues,listThree,2);
            load(phoneNumberValues,listFour,3);
        } else {
            return new ArrayList<>();
        }
        for(String fourStr : listFour){
            for(String threeStr : listThree){
                for(String twoStr : listTwo){
                    for(String oneStr : listOne){
                        outputList.add(oneStr+twoStr+threeStr+fourStr);
                    }
                }
            }
        }
        return outputList;
    }

    

    private void load(List<String> phoneNumberValues,
            List<String> list,
            int index) {
                list.remove("");
        for (int i = 0; i < phoneNumberValues.get(index).length(); i++)
            list.add(phoneNumberValues.get(index).substring(i, i + 1));

    }

}
