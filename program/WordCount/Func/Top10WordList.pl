use List::Util (reduce);

open(FILE,"< news.txt");
printf("%d %s\n",$_->[1],$_->[0]) for
grep {$i++<10}
sort {$b->[1]<=>$a->[1] or $a->[0] cmp $b->[0]}
map {@{$_}}
reduce {($n=@{$a})==0?[[$b,1]]:$a->[$n-1]->[0] ne $b ? [@{$a},[$b,1]] : [@{$a}[0..$n-2],[$b,$a->[$n-1]->[1]+1]]}
[], sort {$a cmp $b}
map {chomp;tr/A-Z/a-z/;tr/.,!'()-//d;split}
<FILE>;
close(FILE);
