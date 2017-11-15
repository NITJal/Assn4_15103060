package ques3;

import java.util.Scanner;

public class TextEditor
{
	
	public static StringBuffer textEditor(String input)
	{
		StringBuffer output = new StringBuffer("");
		int index=0,flag=0;
		String str;
		for( int i=0 ; i<input.length(); i++ )
		{
			Character ch = input.charAt(i);
			switch( ch )
			{
			case '^' :   index = output.lastIndexOf("\n", index-1);
							break;
			case '<' :	index = index-1;
							break;
			case '>' :	break;
			case '?' :	index = output.indexOf("\n", index+1);
							if(index == -1)
								index = output.length();
							break;
			case '@' :	
							if( flag==0 )
								flag=1;
							else
								flag=0;
							break;
			case '$' :	output.insert(index++, "\n");
							break;
			case '#' :	output.deleteCharAt(--index);
							break;
			case ' ' :	output.insert(index++, " ");
							break;
			default : 	
							if( flag==1 )
							{
								str = ch.toString().toUpperCase();
								output.insert(index++, str);
							}
							else
							{
								str = ch.toString().toLowerCase();
								output.insert(index++, str);
							}
							break;
			}
		}
		return output;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Input : ");
		String input = sc.nextLine();
		sc.close();
		System.out.println("Output : ");
		System.out.print(textEditor(input));
	}

}
