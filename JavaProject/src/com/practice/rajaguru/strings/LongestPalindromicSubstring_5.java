package com.practice.rajaguru.strings;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(
            "vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhblegfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmlapccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgubeybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyzecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkqnxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfwenhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvadlwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfbbnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstvegyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwnvpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf"
        ));
    }

    //working but slow
    public static String longestPalindrome(String s) {
        String output = "";
        if(s.length()>0)output=s.substring(0,1); else return output;
        for(int i=0; i<s.length(); i++){
            int maxL = s.substring(i).length();
            if(output.length() >  maxL) break;
            for(int j=s.length(); j>=i+1; j--){
                String str = s.substring(i,j);
                if(new StringBuilder(str).reverse().toString().equals(str) 
                && output.length()<str.length()){
                    output = str;
                    break;
                }
            }
        }
        return output;
    }
}
