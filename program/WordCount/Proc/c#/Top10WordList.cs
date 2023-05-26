using System;
using System.Collections.Generic;

class Top10WordList {
	static void Main() {
		string line;
		var list=new List<ValueTuple<string,int>>();
		while ((line=Console.ReadLine())!=null) {
			var arr=line.Split(" ");
			list.Add((arr[1],int.Parse(arr[0])));
		}
		int comp;
		list.Sort((a,b)=>((comp=b.Item2-a.Item2)!=0)?comp:a.Item1.CompareTo(b.Item1));
		for (var i=0;i<list.Count && i<10;i++) {
			Console.WriteLine("{0} {1}",list[i].Item2,list[i].Item1);
		}
	}
}
