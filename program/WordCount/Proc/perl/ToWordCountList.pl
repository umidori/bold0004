while(<>) {
    chomp;
    $words{$_}++;
}
while(@_=each %words) {
    printf("%d %s\n",$_[1],$_[0]);
}
