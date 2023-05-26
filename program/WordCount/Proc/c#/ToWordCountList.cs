using System;
using System.Collections.Generic;

class ToWordCountList {
	static void Main() {
		string word;
		var dic=new Dictionary<string,int>();
		while ((word=Console.ReadLine())!=null) {
			if (!dic.ContainsKey(word)) {
				dic.Add(word, 0);
			}
			dic[word]++;
		}
		foreach (var pair in dic) {
			Console.WriteLine("{0} {1}",pair.Value,pair.Key);
		}
	}
}
