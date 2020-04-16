xquery version "1.0";

<Movie>{
let $rk := (
	for $x in doc("doubanMovie.xml")/MovieRank/Movie
	where $x[@Rank<=60] and $x[@Rank>=50]
	return $x
)
return
	for $x in $rk
	where $x[Length<=130] and $x[Length>=120]
	return $x
}
</Movie>