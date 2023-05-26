while (<>) {
    chomp;
    push @words,[split " "];
}
@words=sort {$b->[0]<=>$a->[0] or $a->[1] cmp $b->[1]} @words;
$count=@words;
for ($i=0;$i<$count && $i<10;$i++) {
    printf("%d %s\n",$words[$i]->[0],$words[$i]->[1]);
}
