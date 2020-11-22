import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;
import java.time.format.*;
public class Calculator{
	static int x=0,y=0;
    static Scanner reader = new Scanner(System.in);
    static long start = 0;
    static LocalDateTime startin = LocalDateTime.now();
    public static void main(String[] args){
    	System.out.println("Enter your name:");
    	String name = reader.next();
    	System.out.println("Enter your surname:");
    	String surname = reader.next();
        System.out.println("Welcome: " + name + " " + surname + " " +LocalDate.now());
        start = System.currentTimeMillis();
        Menu(); 
    }

    public static boolean TryParse(String value){
    	try{
    		Integer.parseInt(value);
    		return true;
    	}catch(NumberFormatException ex){
    		return false;
    	}
    }

    public static void Calculator(){
    	System.out.println("\nEnter First Number: ");
        var first = "";
        while(true){
        	first = reader.next();
        	if(TryParse(first)){
        		x = Integer.parseInt(first);
        		break;
        	}else{
        		System.out.println("Enter Valid Number");
        		first = "";
        	}
        }
        System.out.println("\nEnter Second Number: ");
        var second = "";
        while(true){
        	second = reader.next();
        	if(TryParse(second)){
        		y = Integer.parseInt(second);
        		break;
        	}else{
        		System.out.println("Enter Valid Number");
        		second = "";
        	}
        }

        System.out.println("Choose an operator:");
        System.out.println("1. Add");
        System.out.println("2. Subtract"); 
        System.out.println("3. Divide"); 
        System.out.println("4. Mulitiply"); 
        System.out.println("5. To the power"); 

        String operator = reader.next();
        double result = 0;
        String op = " ";
        switch(operator){
        	case "1":
        	    op = "+";
        		result = x + y;
        		break;
        	case "2":
        	    op = "-";
        		result = x - y;
        		break;
        	case "3":
        		op = "/";
        		result = x / y;
        		break;
        	case "4":
        		op = "*";
        		if (y == 2 || x == 2) {
        			result = (int)x<<1;
        		}else{
        			result = x * y;
        		}
        		break;
        	case "5":
        		op = "^";
        		result = Math.pow(x, y);
        		break;
        	default:
        		if(operator == null)
        			System.out.println("Invalid operator");
        		else
        			System.out.println("Invalid operator");
        		operator = reader.next();
        		break;
        }
        if(result != 0)
        	System.out.println((int)x+ " " + op + " " + (int)y + " " + " = "+ (int)result);

        Menu();
    }

    public static void Menu(){
    	System.out.println("\n-------Menu--------");
        System.out.println("1. Calculator");
        System.out.println("2. Exit");
        System.out.println("---------------------");
        var response = reader.next();

        var formatter = DateTimeFormatter.ofPattern("hh:mm:ss"); 
        var time = LocalDateTime.now();

        switch(response){
        	case "1":
        		Calculator();
        		break;

        	case "2":
        		System.out.print("Do you wish to exit? Y / N: ");
        		response = reader.next();
        		switch(response){
        			case "y":
        			case "Y":
        				var end = System.currentTimeMillis();
        				var duration = end - start;
        				 var formatTime = time.format(formatter);
        				System.out.println("\nThank you using the calculator");
        			    System.out.println("Time ended: " + formatTime );
        			    System.out.println("Time used: " + TimeUnit.MILLISECONDS.toSeconds(duration) + " seconds");
        				System.exit(0);
        				break;
        			case "n":
        			case "N":
        				Menu();
        				break;
        		}
        }
    }
}

        










        