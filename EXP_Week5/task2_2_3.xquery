xquery version "1.0";

let $old_m := doc("doubanMovie.xml")/MovieRank
let $new_m := doc("newCome.xml")/MovieRank
let $new_total := $old_m/@total+$new_m/@total
return
<MovieRank>
	{$old_m/Movie}
	{$new_m/Movie}
</MovieRank>

