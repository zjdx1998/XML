xquery version "1.0";

declare function local:filter(
								$rkmin as xs:integer?,
								$rkmax as xs:integer,
								$lenmin as xs:string?,
								$lenmax as xs:string
							  )
{
	for $movie in doc("doubanMovie.xml")/MovieRank/Movie
		where $movie[@Rank<=$rkmax] and $movie[Length<=$lenmax] and $movie[@Rank>=$rkmin] and $movie[Length>=$lenmin]  
	return $movie
};

<Movie>{local:filter(50,60,130,150)}</Movie>