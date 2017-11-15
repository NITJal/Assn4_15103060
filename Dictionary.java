package ques2;

import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary 
{
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("this");
		list.add("is");
		list.add("the");
		list.add("Program");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input : ");
		String line = sc.nextLine();
		sc.close();
		String[] input = line.split(" ");
		String output ="";
		int i,j,count,flag;
		for(String str1 : input)
		{
			flag=0;
			count=0;
			String str = str1.toLowerCase();
			if( list.contains(str) )
			{
				output += str1 + " ";
			}
			else
			{
				for( i=0; i<list.size() ; i++ )
				{
					String word = list.get(i);
					for( j=0 ; j<word.length() && j<str.length() ; j++ )
					{
						if( str.charAt(j) == word.charAt(j) )
							count++;
					}
					if( count >= (str.length()/2) )
					{
						output += word+ " ";
						flag=1;
						break;
					}
				}
				if( flag==0 )
					list.add(str1);
			}
		}
		System.out.println(output);
	}
}
