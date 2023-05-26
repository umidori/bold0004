import Data.List

main =
    putStr
        $ unlines
        $ map (\x->show $ head x)
        $ filter (\x->length x == 1)
        $ group
        $ sort
        $ (\n->concatMap (\x->[2*x,3*x..n])
            [1..truncate $ sqrt $ fromInteger n])
        100 
