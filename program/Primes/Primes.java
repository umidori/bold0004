import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Primes {
    public static void main(String[] args) {
        Stream.of(100)
            .flatMap(n->IntStream.range(1,(int)Math.sqrt(n)+1)
                    .boxed()
                    .flatMap(x->IntStream.range(2,n/x+1)
                        .boxed()
                        .map(y->x*y)))
        .collect(Collectors.groupingBy(x->x))
        .entrySet()
        .stream()
        .filter(x->x.getValue().size()==1)
        .map(x->x.getKey())
        .forEach(x->System.out.println(x));
    }
}
