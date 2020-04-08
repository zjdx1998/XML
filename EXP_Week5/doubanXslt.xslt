<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
	<head>
		<title>DoubanMoviesRankingList</title>
	</head>
	<body>
		<time><xsl:value-of select="MovieRank/Retrieve/@time"/></time>

		<xsl:for-each select="MovieRank/Movie">
			<hr/>
			<rank><xsl:value-of select="@Rank"/>
				<xsl:text>:&#160;&#160;&#160;</xsl:text>
			</rank>	
			<name style="font-size:30px">	
				<xsl:value-of select="Name/StandardName"/>
			</name>
			<br/>
			<derector>
				导演:
				<xsl:value-of select="Director"/>
				&#160;
			</derector>
			<actor>
				主演:
				<xsl:value-of select="ActorList/Actor"/>
				
			</actor>
			<br/>
			<category>
				类型:
			</category>
			<p>评分:
			<rating style ="color:#e7e708"><xsl:value-of select="Rating"/></rating>
			</p>
		</xsl:for-each>
	
	
	</body>

</html>

</xsl:template>
<!--
<xsl:template match="Category">
<xsl:for-each select="MovieRank/Movie/Category">
<xsl:value-of select="Category/@type">/</xsl:value-of>
</xsl:for-each>
</xsl:template>-->
</xsl:stylesheet>
