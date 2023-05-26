using System;
using System.IO;
using System.Text.RegularExpressions;

class ToWordList {
	static void Main() {
		using (var sr=new StreamReader("news.txt")) {
			string line;
			while ((line=sr.ReadLine())!=null) {
				line=Regex.Replace(line.ToLower(),"[.,!'()-]","");
				foreach (var word in Regex.Split(line," +")) {
					Console.WriteLine(word);
				}
			}
		}
	}
}
