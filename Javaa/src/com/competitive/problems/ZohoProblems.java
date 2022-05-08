package com.competitive.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZohoProblems {
	public static void main(String[] args) throws IOException, ParseException {
//		maxAircraftAtTime(new String[] { "9:00", "9:40", "9:50", "11:00", "15:00", "18:00" },
//				new String[] { "9:10", "12:00", "11:20", "11:30", "19:00", "20:00" });
//		maxAircraftAtTime(new String[] { "9:00", "9:40" }, new String[] { "9:10", "12:00" });
//		maxAircraftAtTime(new String[] { "9:50", "11:00", "15:00", "18:00" },
//				new String[] { "11:20", "11:30", "19:00", "20:00" });
//		updateHoursMinutesSec();
//		System.out.println(011);
		carriersToAvoidCrash();

		/*
		 * 1 3 2 4 5 1 2 3 -
		 * 
		 */
	}
	
	public static void carriersToAvoidCrash() {
		double[] arr = {9.00, 9.40, 9.50, 11.00, 15.00, 18.00};
		double[] dep = {9.10, 12.00, 1120, 11.30, 19.00, 20.00};
		double[] ar = new double[arr.length];
		double[] dp = new double[arr.length];
		int[] cnt = new int[arr.length];
	    int count=0; 
		for(int i=0;i<dep.length-1;i++) {
			if(ar[i]==0) {
			ar[i]=arr[i];
			dp[i]=dep[i];
			cnt[i]=1;
			}
			for(int j=i+1;j<dep.length;j++) {
				//if(i==j)continue;
				if(dep[i]>=arr[j] && dep[i]<=dep[j]) {
					ar[i]=(arr[j]<ar[i]?arr[j]:ar[i]);
					dp[i]=(dep[j]<dp[i]?dep[j]:dp[i]);
					cnt[i]=cnt[i]+1;
				}
				else if(dep[j]>=arr[i] && dep[j]<=dep[i]) {
					ar[j]=(arr[j]<arr[i]?arr[j]:arr[i]);
					dp[j]=(dep[j]<dep[i]?dep[j]:dep[i]);
					cnt[j]=2;
				}
			}	
		}
//		for(int i:timeMap1.values()) {
//			if(i>count)count=i;
//		}
//		System.out.println("Carriers Required "+count);
		count=0;
		for(int i:cnt) {
			if(i>count)count=i;
		}
		System.out.println("Carriers Required "+count);
	}
	
	

	// L2 BATCH 2 Q4
	static void updateHoursMinutesSec() {
		int h = 15;
		int m = 59;
		int s = 59;
		int[] arr = { 2, 88, 12345 };
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				h = h + arr[i];
			} else if (i == 1) {
				m = m + arr[i];
				int div = m / 60;
				h = h + div;
				m = m - (div * 60);
			} else {
				s = s + arr[i];
				int div = s / 60;
				int temp = m + div;
				if (temp >= 60) {
					int hDiv = temp / 60;
					h = h + hDiv;
					m = temp - (hDiv * 60);
				} else
					m = m + div;
				s = s - (div * 60);
			}
			System.out.println(zeroPrefixPadding(h) + ":" + zeroPrefixPadding(m) + ":" + zeroPrefixPadding(s));

		}
	}

	static String zeroPrefixPadding(Integer i) {
		return String.valueOf(i).length() == 1 ? "0" + i : "" + i;
	}

	// L2 BATCH 1 Q5
	static void maxAircraftAtTime(String[] arrStr, String[] depStr) throws ParseException {
//		maxAircraftAtTime(new String[] {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00"},new String[] {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00"});
//		maxAircraftAtTime(new String[] {"9:00", "9:40"},new String[] {"9:10", "12:00"});
//		maxAircraftAtTime(new String[] {"9:50", "11:00", "15:00", "18:00"},new String[] {"11:20", "11:30", "19:00", "20:00"});
		Integer[] arr = Stream.of(arrStr).map(a -> {
			String[] arrr = a.split(":");
			return (Integer.parseInt(arrr[0]) * 60) + Integer.parseInt(arrr[1]);
		}).collect(Collectors.toList()).toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr));
		Integer[] dep = Stream.of(depStr).map(a -> {
			String[] deprr = a.split(":");
			return (Integer.parseInt(deprr[0]) * 60) + Integer.parseInt(deprr[1]);
		}).collect(Collectors.toList()).toArray(new Integer[0]);
		System.out.println(Arrays.toString(dep));
		int l = arr.length;
		int[][] adc = new int[l][3];
		int count = 0;
		for (int i = 0; i < l; i++) {
			if (i == 0) {
				adc[i][0] = arr[i];
				adc[i][1] = dep[i];
				adc[i][2] = 1;
				count++;
			} else {
				boolean isNewEntry = true;
				for (int j = 0; j < count; j++) {
					if ((adc[j][0] <= arr[i]) && (arr[i] <= adc[j][1])) {
						adc[j][2]++;
						isNewEntry = false;
					}
				}
				if (isNewEntry) {
					adc[i][0] = arr[i];
					adc[i][1] = dep[i];
					adc[i][2] = 1;
					count++;
				}
			}
		}
		int maxAirCraft = 0;
		for (int i = 0; i < count; i++) {
			if (maxAirCraft < adc[i][2]) {
				maxAirCraft = adc[i][2];
			}
		}

		System.out.println("Aircraft at a time(ut most) - " + maxAirCraft);
	}

	// L2 BATCH 1 Q3
	static void printStringNPosition(String alphabet, String nonZeroDigits) {
		int nonZeroDigitsLength = nonZeroDigits.length();
		List<Integer> digitArr = Stream.of(nonZeroDigits.split("")).collect(Collectors.toList()).stream()
				.map(d -> Integer.parseInt(d)).collect(Collectors.toList());
		System.out.println(digitArr);

		for (int i = 0; i < nonZeroDigitsLength; i++) {
			String str = alphabet.substring(0, i + 1);
			int printcount = digitArr.get(i);
			for (int j = 0; j < printcount; j++) {
				System.out.print(str);
			}
			System.out.println();
		}

	}

	// L2 BATCH 1 Q4
	static void printSmallestSubArrLength(int[] arr, int k) {
		int output = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= k) {
				output = 1;
				break;
			}
			int count = 1;
			sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum = sum + arr[j];
				count++;
				if (sum >= k && ((output > count) || i == 0)) {
					output = count;
					break;
				}
			}
		}
		System.out.println("output = " + output);
	}

	// L2 BATCH 2 Q1
	static void moveZerosToRight(int[] arr) {
		int[] outputArr = new int[arr.length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				outputArr[index] = arr[i];
				index++;
			}
		}
		System.out.println(Arrays.toString(outputArr));
	}

	// L2 BATCH 2 Q2
	static void printLexicographicalOrderCount() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input count : ");
		int inputCount = Integer.parseInt(bf.readLine());
		System.out.println("no of alphabet per line is : ");
		int noOfChar = Integer.parseInt(bf.readLine());
		System.out.println("Please enter " + inputCount + " inputs : ");
		String[] inputArr = new String[inputCount];
		for (int i = 0; i < inputCount; i++) {
			inputArr[i] = bf.readLine().replaceAll("\\s+", "");
		}
		System.out.println(Arrays.toString(inputArr));

		int output = 0;
		for (int i = 0; i < inputCount; i++) {
			char[] charArr = inputArr[i].toCharArray();
			boolean isAlphabetOrder = true;
			for (int j = 0; j < charArr.length - 1; j++) {
				int diff = charArr[j + 1] - charArr[j];
				if (diff < 0) {
					isAlphabetOrder = false;
					break;
				}
			}
			if (isAlphabetOrder) {
				output++;
			}

		}
		System.out.println(output);// a s d f

	}

	// L2 BATCH 2 Q3
	static void sumAfterRemoveFirstZero() throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of inputs needs to be add : ");
		int arrLength = Integer.parseInt(bf.readLine());
		String[] arr = new String[arrLength];
		System.out.println("Please enter input values : ");
		for (int i = 0; i < arrLength; i++) {
			arr[i] = bf.readLine().trim();
		}
		int output = 0;
		for (int i = 0; i < arrLength; i++) {
			String str = arr[i];
			char[] c = str.toCharArray();
			boolean isFirstZero = true;
			String strInit = "";
			for (int j = 0; j < c.length; j++) {
				if (c[j] != '0' || !isFirstZero) {
					strInit = strInit + c[j];
				}
				if (isFirstZero && c[j] == '0') {
					isFirstZero = false;
				}

			}
			output = output + Integer.parseInt(strInit);
		}
		System.out.println(output);
	}

}
