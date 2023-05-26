open(FILE,"< news.txt");
while (<FILE>) {
    chomp;
    tr/A-Z/a-z/;
    tr/.,!'()-//d;
    for (split / +/) {
        print $_,"\n";
    }
}
close(FILE);
