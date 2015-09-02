package StringCache;
/**
 * @author Nidhi Sharma
 * Date: 2 september,2015
 * Description: CacheString takes string and returns the number of unique characters in the string. If same string is passed again
 * then it should take not consume time in calculating again but should store the previous result in itself.
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CacheString
{
	private static HashMap<String, Integer> stringList = new HashMap<String, Integer>();	//hashmap storing strings as key and number of unique characters as value
	//Main
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		//Scanner class
		do
		{
			System.out.println("1. To add string");
			System.out.println("2. To Display map");
			System.out.println("3. To Exit");
			int choice = sc.nextInt();			//to hold user's choice of operation
			switch(choice)
			{
			// To add string
			case 1:
				System.out.println("Enter String without spaces");
				String string = sc.next();
				Integer numberOfUniqueCharacters = stringCache(string);
				stringList.put(string, numberOfUniqueCharacters);
				break;
			//To Display map
			case 2:
				Set<String> key = stringList.keySet();
				for(String str : key)
				{
					System.out.println(str + "\t" + stringList.get(str));
				}
				break;
			//To Exit
			case 3:
				System.exit(0);
				break;
			//Default case
			default:
					System.out.println("Invalid Option");
					break;
			}
		}while(true);
	}
	
	/*************************************
	 * Taking string as input and returning
	 * number of unique characters in that
	 * string
	 * @param input string
	 * @return number of unique characters
	 *************************************/
	private static Integer stringCache(String input)
	{
		int flag =-1;			//to indicate repeated character
		Integer count = 0;		//holding number of unique characters
		//if string is blank
		if(input.length() == 0)
		{
			System.out.println("String Empty");
			return count;
		}
		//if list is not empty comparing with all available strings and if similar string found returning its value of number of unique characters
		else if(!stringList.isEmpty())
		{
			Set<String> key = stringList.keySet();		//holding set of keys
			for(String str : key)
			{
				if(input.equalsIgnoreCase(str))		//comparing strings
				{
					count = stringList.get(str);		//if string found retaining its value of number of unique characters
					System.out.println("Number of unique characters in string : "+count);
					return count;		//returning retained number of unique characters
				}
			}
		}
		//if string not found in list calculating number os unique characters
		else if(count==0)
		{
			int characterIndex=0;		//holding each character of string one by one
			while(characterIndex < input.length())
			{
				for(int carry = characterIndex ; carry >= 0; carry--)
				{
					if(characterIndex !=carry && input.charAt(characterIndex)==input.charAt(carry))
					{
						flag =1;
						break;
					}		
				}
				if(flag!=1)		//if character not reapeating increase count by 1
					count++;
				characterIndex++;
				flag = 0;
			}
		}	
		System.out.println("Number of unique characters in strig : "+count);
		return count;		//returning number of unique characters
	}
}
