{ n=0; while read x; do let n++; done; echo $n; }< news.txt
awk 'BEGIN{n=0} {n++} END{print n}' news.txt
perl -le '$n=0;while(<>){$n++}print $n' news.txt
