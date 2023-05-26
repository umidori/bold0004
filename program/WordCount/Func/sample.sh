cat news.txt | tr A-Z a-z | tr -d '!,.()-'\' | xargs -n1 | sort | uniq -c | sort -nr | head | xargs -n2
