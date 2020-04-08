<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
	<head>
		<title>DoubanMoviesRankingList</title>
		<link rel='stylesheet' href = 'doubanMovie.css' type = 'text/css'/>
	</head>
	<body>
		<time><xsl:value-of select="MovieRank/Retrieve/@time"/></time>

		<xsl:for-each select="MovieRank/Movie">
			<hr/>
			<rank><xsl:value-of select="@Rank"/>
				<xsl:text>:&#160;&#160;&#160;</xsl:text>
			</rank>	
			<name>
				<xsl:attribute name="xlink:type">simple</xsl:attribute>
				<xsl:attribute name="xlink:href">
					movieDetail.xml#xpointer(Rank('<xsl:value-of select="@Rank"/>'))
				</xsl:attribute>	
				<xsl:value-of select="Name/StandardName"/>
			</name>
			<br/>
			<director>
				导演:
				<xsl:value-of select="Director"/>
				<br/>
			</director>
			<actor>
				主演:
				<xsl:value-of select="ActorList/Actor[1]"/>
				&#160;
				<xsl:value-of select="ActorList/Actor[2]"/>
				&#160;
				<xsl:value-of select="ActorList/Actor[3]"/>

				
			</actor>
			<br/>
			<category>
				类型:
				<xsl:value-of select="Category[1]/@type"/>
				&#160;

				<xsl:value-of select="Category[2]/@type"/>
				&#160;

				<xsl:value-of select="Category[3]/@type"/>
			</category>
			<div>评分:
			<rating><xsl:value-of select="Rating"/></rating>
			</div>
		</xsl:for-each>
	
	
	</body>

</html>

</xsl:template>

</xsl:stylesheet>
