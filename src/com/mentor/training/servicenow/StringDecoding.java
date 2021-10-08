package com.mentor.training.servicenow;

import java.util.Stack;

public class StringDecoding
{
	//Given an encoded string, return its decoded string.
	//
	//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
	//
	//You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
	//
	//
	//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
	//
	//Example 1:
	//	Input: s = "3[a]2[bc]"
	//	Output: "aaabcbc"
	//
	//
	//Example 2:
	//	Input: s = "3[a2[c]]"
	//	Output: "accaccacc"
	//
	//Example 3:
	//	Input: s = "2[abc]3[cd]ef"
	//	Output: "abcabccdcdcdef"
	//
	//Example 4:
	//	Input: s = "abc3[cd]xyz"
	//	Output: "abccdcdcdxyz"

	public static void main(String[] args)
	{
		StringDecoding sol = new StringDecoding();
		String input = "3[a2[c]]";
		System.out.println(sol.decodeString(input));
	}

	private String decodeString(String input)
	{
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> charStack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (currChar >= '1' && currChar <= '9') {
				numStack.push(currChar - '0');
			}
			else {
				if (currChar == ']') {
					StringBuilder sb = new StringBuilder();
					while (charStack.peek() != '[') {
						sb.append(charStack.pop());
					}
					charStack.pop();
					String internalString = sb.reverse().toString();
					int freq = numStack.pop();
					StringBuilder repeatedString = new StringBuilder();
					for (int j = 0; j < freq; j++) {
						repeatedString.append(internalString);
					}
					for (int j = 0; j < repeatedString.length(); j++) {
						charStack.push(repeatedString.charAt(j));
					}
				}
				else {
					charStack.push(currChar);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		while (!charStack.isEmpty()) {
			result.append(charStack.pop());
		}
		return result.reverse().toString();
	}
}

