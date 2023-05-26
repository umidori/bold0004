open List;;

let () = print_endline (
    String.concat "\n" (
        map (fun x->string_of_int x)
            (concat
                (filter (fun x->(length x)==1)
                    (fold_right (fun x y->if (length (hd y))==0 || mem x (hd y)
                        then (x::(hd y))::(tl y)
                        else [x]::y)
                        (sort (fun x y->if x<y then -1 else 1)
                            ((fun n->concat_map
                                (fun x->map (fun y->(x*(y+1))) (init (n/x-1) succ))
                                (init (truncate (sqrt (float_of_int n))) succ)
                                ) 100)) [[]])))));;
