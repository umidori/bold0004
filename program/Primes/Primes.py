import math;
import itertools;

for x in [k for k, g in itertools.groupby(
          sorted([x*y for n in [100]
                  for x in range(1,int(math.sqrt(n))+1)
                  for y in range(2,n//x+1)]))
          if len(list(g))==1]:
    print(x)
