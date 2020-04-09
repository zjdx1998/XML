<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="Movie">
<html>
	<head>
		<title>MovieDetail</title>
		<link rel='stylesheet' href = 'movieDetail.css' type = 'text/css'/>
	</head>
	<body>
        <standardname>
            <xsl:value-of select="Name/StandardName"/>
        </standardname>
		<hr/>
		<othername>
			<tag>别名:</tag>
			<othernamediv>
			<xsl:for-each select="Name/OtherName">
				<xsl:value-of select="."/>&#160;
			</xsl:for-each>
			</othernamediv>
			<br/>	
		</othername>
		<rating>
			<tag>评分:</tag>
			<ratingdiv>
				<xsl:value-of select="Rating"/>
			</ratingdiv>
			<br/>
		</rating>
		<category>
			<tag>分类:</tag>
			<categorydiv>
				<xsl:for-each select="Category">
					<xsl:value-of select="@type"/>&#160;
				</xsl:for-each>
			</categorydiv>
			<br/>
		</category>
		<intro>
			<tag>简介:</tag>
			<introdiv>
				<xsl:value-of select="Intro"/>
			</introdiv>
			<br/>
		</intro>
		<date>
			<tag>上映日期:</tag>
			<datediv>
				<xsl:value-of select="Date"/>
			</datediv>
			<br/>
		</date>
		<director>
			<tag>导演:</tag>
			<directordiv>
				<xsl:value-of select="Director"/>
			</directordiv>
			<br/>
		</director>
		<scriptwriter>
			<tag>编剧:</tag>
			<scriptwriterdiv>
				<xsl:for-each select="ScriptWriter">
					<xsl:value-of select="."/>&#160;
				</xsl:for-each>
			</scriptwriterdiv>
			<br/>
		</scriptwriter>
		<actorlist>
			<tag>演员:</tag>
			<actorlistdiv>
				<xsl:for-each select="ActorList/Actor">
					<xsl:value-of select="."/>&#160;
				</xsl:for-each>
			</actorlistdiv>
			<br/>
		</actorlist>
	</body>

</html>

</xsl:template>

</xsl:stylesheet>
