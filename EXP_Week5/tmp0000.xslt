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
		<br/>
		<othername>
			别名:
			<othernamediv>
			<xsl:for-each select="Name/OtherName">
				<xsl:value-of select="OtherName"/>&#160;
			</xsl:for-each>
			</othernamediv>
			<br/>	
		</othername>
		<rating>
			评分:
			<ratingdiv>
				<xsl:value-of select="Rating"/>
			</ratingdiv>
			<br/>
		</rating>
		<category>
			分类:
			<categorydiv>
				<xsl:for-each select="Category">
					<xsl:value-of select="@type"/>&#160;
				</xsl:for-each>
			</categorydiv>
			<br/>
		</category>
		<intro>
			简介:
			<introdiv>
				<xsl:value-of select="Intro"/>
			</introdiv>
			<br/>
		</intro>
		<date>
			上映日期:
			<datediv>
				<xsl:value-of select="Date"/>
			</datediv>
			<br/>
		</date>
		<director>
			导演:
			<directordiv>
				<xsl:value-of select="Director"/>
			</directordiv>
			<br/>
		</director>
		<scriptwriter>
			编剧:
			<scriptwriterdiv>
				<xsl:for-each select="ScriptWriter">
					<xsl:value-of select=".">&#160;</xsl:value-of>
				</xsl:for-each>
			</scriptwriterdiv>
			<br/>
		</scriptwriter>
		<actorlist>
			演员:
			<actorlistdiv>
				<xsl:for-each select="ActorList/Actor">
					<xsl:value-of select=".">&#160;</xsl:value-of>
				</xsl:for-each>
			</actorlistdiv>
			<br/>
		</actorlist>
	</body>

</html>

</xsl:template>

</xsl:stylesheet>
