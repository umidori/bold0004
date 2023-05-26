use std::collections::BTreeMap;

fn main() {
     vec![100]
     .into_iter()
     .flat_map(move|n|(1..(n as f64).sqrt() as i32+1)
               .flat_map(move|x|(2..n/x+1).map(move|y|x*y)))
     .fold(BTreeMap::new(),|mut t:BTreeMap<i32,Vec<i32>>,e|{t.entry(e).or_insert_with(Vec::new).push(e);t})
     .iter()
     .filter(|x|x.1.len()==1)
     .map(|x|x.0)
     .for_each(|x|println!("{}", x));
}
