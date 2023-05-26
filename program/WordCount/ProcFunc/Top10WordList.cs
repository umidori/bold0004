using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Collections.Generic;

class Top10WordList {
	static void Main() {
		foreach (var s in GetTop10WordList(GetWordCountList(GetWordList()))) {
			Console.WriteLine(s);
		}
	}

	static IEnumerable<string> GetWordList() {
		using (var sr=new StreamReader("news.txt")) {
			string line;
			while ((line=sr.ReadLine())!=null) {
				line=Regex.Replace(line.ToLower(),"[.,!'()-]","");
				foreach (var word in Regex.Split(line," +")) {
					yield return word;
				}
			}
		}
	}

	static IEnumerable<ValueTuple<string,int>> GetWordCountList(IEnumerable<string> list) {
		var dic=new Dictionary<string,int>();
		foreach (var word in list) {
			if (!dic.ContainsKey(word)) {
				dic.Add(word,0);
			}
			dic[word]++;
		}
		foreach (var pair in dic) {
			yield return (pair.Key, pair.Value);
		}
	}

	static IEnumerable<string> GetTop10WordList(IEnumerable<ValueTuple<string,int>> list) {
        var mutList=new List<ValueTuple<string,int>>(list);
        int comp;   
        mutList.Sort((a,b)=>((comp=b.Item2-a.Item2)!=0)?comp:a.Item1.CompareTo(b.Item1));
        for (var i=0;i<mutList.Count && i<10;i++) {
            yield return $"{mutList[i].Item2} {mutList[i].Item1}";
        }
	}
}
