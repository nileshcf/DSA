package com.dsa.IBM;

import java.util.HashMap;
import java.util.Map;

public class CompressString {

	String solve(String str)
	{
		Map<Character,Integer> map = new HashMap<>();

		for (int i=0;i<str.length();i=i+2)
		{
			if(!map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i),Integer.parseInt(String.valueOf(str.charAt(i+1))));
			}
		}

		StringBuilder ans = new StringBuilder();
		for(Map.Entry entry : map.entrySet())
		{
			for (int i = 0; i < entry.getValue().hashCode(); i++) {
				ans.append(entry.getKey());
			}

		}

		return ans.toString();
	}
}
