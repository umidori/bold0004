[100].flat_map{|n|
	(1..Math.sqrt(n).to_i)
	.flat_map{|x|(2..n/x)
		.map{|y|x*y}}}
.group_by{|x|x}
.filter{|k,v|v.size==1}
.map{|k,v|k}
.each{|x|puts x}
