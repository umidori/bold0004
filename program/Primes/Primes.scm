(use gauche.collection)

(print
  (string-join
    (map (lambda (x) (x->string x))
	 (apply append
		(filter (lambda (x) (= (length x) 1))
			(group-collection
			  (apply append
				 ((lambda (n)
				    (map (lambda (x)
					   (map (lambda (y) (* x (+ y 2)))
						(iota (- (truncate (/ n x)) 1))))
					 (map (lambda (x) (+ x 1))
					      (iota (truncate (sqrt n))))
					 )) 100)))))) "\n"))
