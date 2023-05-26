use strict;

print $_,"\n" for getTop10WordList(getWordCountList(getWordList()));

sub getWordList {
    my @list;
    open(FILE,"< news.txt");
    while(<FILE>){
        chomp;
        tr/A-Z/a-z/;
        tr/.,!'()-//d;
        push @list,split / +/
    }
    close(FILE);
    @list;
}

sub getWordCountList {
    my @list;
    my %words;
    for (@_) {
        $words{$_}++;
    }
    while(my @wc=each %words) {
        push @list,[@wc];
    }
    @list;
}

sub getTop10WordList {
    my @list;
    my @strList;
    my @list=sort {$b->[1]<=>$a->[1] or $a->[0] cmp $b->[0]} @_;
    my $count=@list;
    for (my $i=0;$i<$count && $i<10;$i++) {
        push @strList,sprintf("%d %s",$list[$i]->[1],$list[$i]->[0]);
    }
    @strList;
}
