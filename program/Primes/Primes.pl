use List::Util (reduce);

print $_->[0],"\n" for
grep {@{$_}==1}
map {@{$_}}
reduce {$len=@{$a};$len==0?[[$b]]:$a->[$len-1]->[0]!=$b?[@{$a},[$b]]:[@{$a}[0..$len-2],[@{$a->[$len-1]},$b]]}
[],sort {$a <=> $b}
map {$n=$_;map {$x=$_;map{$x*$_}(2..$n/$x)} 1..sqrt($n)}
100;
