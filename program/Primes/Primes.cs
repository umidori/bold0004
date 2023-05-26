using System;
using System.Linq;
using System.Collections.Generic;

class Primes {
	static void Main() {
		new List<int>{100}
		.SelectMany(n=>Enumerable.Range(1,(int)Math.Sqrt(n))
				.SelectMany(x=>Enumerable.Range(2,n/x-1)
					.Select(y=>x*y)))
			.GroupBy(x=>x)
			.Where(x=>x.Count()==1)
			.Select(x=>x.Key)
			.ToList()
			.ForEach(x=>Console.WriteLine(x));
	}
}
