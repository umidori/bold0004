cat news.txt | wc -l | xargs
cat news.txt | grep -c ^
cat news.txt | sed '$=;d' 
cat -n news.txt | tail -1 | cut -f1 | xargs
cat -n news.txt | awk 'END{print $1}'
awk 'END{print NR}' news.txt
perl -le 'print scalar@{[<>]}' news.txt
cat news.txt | sed 's/.*/1/' | xargs | tr ' ' + | bc
