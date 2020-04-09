<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html xmlns="http://www.w3.org/1999/xhtml">
			<head>
				<title>GroupInfo</title>
				<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
				<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport"/>
				<link rel='stylesheet' href = 'GroupInfo.css' type = 'text/css'/>
			</head>
			<body>
				<h2 style="font-size:40px">GroupInfo</h2>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="group">
		<p>
			<xsl:apply-templates select="groupname"/>
			<svg width = "100%" height = "35%" version = "1.1"
			xmlns = "http://www.w3.org/2000/svg">
				<rect x="50" y = "20" rx = "150" ry ="50" width = "200"
				height = "150" style = "fill:#333333;
				stroke:#000000;stroke-width:2"/>
				<polygon points = "0,50 150,0 300,50 150,100"
				style = "fill:#333333;
				stroke:#000000;stroke-width:2"/>
				<polygon points = "270,50 270,150 260,170 290,170 280,150 280,50"
				style = "fill:#333333"/>
				<text id = "Groupname" x = "50" y = "220" 
				style = "font-family:cursive; font-size : 50">HurryToGraduate
				</text>
			</svg>
			<xsl:apply-templates select="members"/>
			<hr/>
			<members>Projects:<br/></members>
			<project>
			<a href="doubanMovie.xml">豆瓣电影排行榜</a>
			</project>
		</p>
	</xsl:template>
	
	<xsl:template match="groupname">
		<groupname style="font-size:30px">
			<xsl:value-of select="."/>
		</groupname>
	</xsl:template>
	
	<xsl:template match="members">
	<hr/>
	<members>Members:</members>
	<br/>
		<xsl:for-each select="member">
			<name>
			<xsl:value-of select="name"/>
			</name>
			<br/>
			<email>
			<xsl:value-of select="Contact"/>
			</email>
			<br/>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
