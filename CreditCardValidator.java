import java.util.*;

public class CreditCardValidator{
	private static Scanner scanner = new Scanner(System.in);
	private static int[] cardNumList = new int[16]; 
	private static String cardNum;
	private static int cardDigitLength;

	public static boolean lengthChecker(){
		
		boolean check = false;
		if(cardNum.length() >= 13 && cardNum.length() <= 16){
			check = true;
		}
		return check;
	}

	public static String cardTypeChecker(){
		
		String cardType;
		if(cardNumList[0] == 4){
			cardType = "Visa Card";
		}else
		
		if(cardNumList[0] == 5){
			cardType = "MasterCard";
		}else
		
		if(cardNumList[0] == 3 && cardNumList[1] == 7){
			cardType = "American Express Card";
		}else
	
		if(cardNumList[0] == 6){
			cardType = "Discover Card";
		}
		else{
			cardType = "Invalid Card";
		}

		return cardType;
	}

	public static void listConverter(){

		for(int i = 0; i < cardDigitLength ; i++){
			cardNumList[i] = Integer.parseInt(String.valueOf(cardNum.charAt(i)));
		}
		
		
	}

	public static int[] evenDoubleDigits(){
		int num1 = 0;
		int num2 = 0;
		int[] newArray = new int[cardDigitLength];
		for(int i = 0 ; i < newArray.length ; i+=2){

			newArray[i] = cardNumList[i] * 2;
			
		} 
		for(int i = 0 ; i < newArray.length ; i+=2){
			if(newArray[i] >= 10){
				num1 = newArray[i] / 10;
				num2 = newArray[i] % 10;
				newArray[i] = num1 + num2;
			}
			
		} 
		return newArray;
	}


	public static int[] oddDoubleDigits(){
		int[] newArray = new int[cardDigitLength];
		for(int i = 1 ; i < newArray.length ; i+=2){

			newArray[i] = cardNumList[i];
			
		} 
		return newArray;
	}

	public static int addSingleDigit(){
		int total = 0;
		int[] newArray = evenDoubleDigits();
		for(int i = 0 ; i < newArray.length ; i++){

			total += newArray[i];
			
		} 
		return total;
	}

	public static int sumTotal(){

		return addSingleDigit() + addOdd();
	}

	public static int addOdd(){
		int oddTotal = 0;
		int[] newArray = oddDoubleDigits();
		for(int i = 0 ; i < newArray.length ; i++){

			oddTotal += newArray[i];
			
		} 
		return oddTotal;
	}

	public static boolean validityCheck(){
	
		boolean check = false;
		if(sumTotal() % 10 == 0){
			check = true;
	
		}
		return check;
	}

	public static void outputDisplay(){


		System.out.println("***************************************");
		System.out.printf("**Credit Card Type: %s%n",cardTypeChecker());
		System.out.printf("**Credit Card Number: %s%n", cardNum);
		System.out.printf("**Credit Card Digit Length: %s%n", cardDigitLength);
		System.out.printf("**Credit Card Validity Status: %s%n",validityCheck() == true ? "Valid": "Invalid");
		System.out.println("***************************************");

	}

	public static void main(String[]args){
	
		System.out.println("Hello, Kindly Enter Card details to verify");
		cardNum = scanner.nextLine(); 	
		cardDigitLength = cardNum.length();
		
		while(cardDigitLength < 13 || cardDigitLength > 16){
			System.out.println("Hello, Please Kindly Enter Correct Card details to verify");
			cardNum = scanner.nextLine(); 
			cardDigitLength = cardNum.length();
			System.out.println("");
		}

		System.out.println("");
		System.out.println("");
		listConverter();
		evenDoubleDigits();
		oddDoubleDigits();
		addOdd();
		addSingleDigit();
		sumTotal();
		validityCheck();
		outputDisplay();


	}



}