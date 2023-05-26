echo 100 | { read n; seq $(dc -e ${n}vp) | while read x; do seq $((x*2)) $x $n; done; } | sort -n | uniq -u
