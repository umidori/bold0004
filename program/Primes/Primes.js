Object.values(
    [100].flatMap(n=>[...Array(Math.trunc(Math.sqrt(n))).keys()]
        .map(x=>x+1)
        .flatMap(x=>[...Array(Math.trunc(n/x-1)).keys()]
            .map(y=>x*(y+2))))
    .reduce((x,y)=>{x[y]=x[y]??[];x[y].push(y);return x},{}))
.filter(x=>x.length==1)
.flat()
.forEach(x=>console.log(x))
