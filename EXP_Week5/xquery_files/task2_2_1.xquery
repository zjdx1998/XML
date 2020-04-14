xquery version "1.0";

declare function local:groupby($category as xs:string)
{
	if($category="Length") then(
		for $movie in doc("doubanMovie.xml")/MovieRank/Movie
		order by $movie/Length 
		return $movie
	)
	else (
		if($category="Category") then(
			for $movie in doc("doubanMovie.xml")/MovieRank/Movie
			order by $movie/Category 
			return $movie
		)
		else (
			if($category="Date") then(
			for $movie in doc("doubanMovie.xml")/MovieRank/Movie
			order by $movie/Date 
			return $movie
		)
			else ()
		)
	)
};

<Movie>{local:groupby("Date")}</Movie>
