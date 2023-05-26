using System;
using System.IO;
using System.Linq; 
using System.Text.RegularExpressions;

class Top10WordList {
   static void Main() {
	   File.ReadAllLines("news.txt")
		   .Select(line=>Regex.Replace(line.ToLower(),"[.,!'()-]",""))
		   .SelectMany(line=>Regex.Split(line," +"))
		   .GroupBy(word=>word)
		   .Select(group=>(Word:group.Key,Count:group.Count()))
		   .OrderByDescending(tuple=>tuple.Count)
		   .ThenBy(tuple=>tuple.Word)
		   .Take(10)
		   .ToList()
		   .ForEach(tuple=>Console.WriteLine("{0} {1}",tuple.Count,tuple.Word));
    }
}

