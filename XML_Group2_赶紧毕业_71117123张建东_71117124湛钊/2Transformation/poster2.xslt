<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
    <html>
        <head>
            <title>海报展示2</title>
            <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
            <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport"/>
            <link rel='stylesheet' href = 'poster2.css' type = 'text/css'/>
        </head>
        <body class="main">
            <h2 style="font-size:35px;color:DarkGreen;">海报展示页:</h2>
            <xsl:apply-templates/>
            <p style="text-align:right;font-size:20px;">检索时间:<xsl:value-of select="MovieRank/Retrieve/@time"/></p>
       
        </body>
    </html>
    </xsl:template>

    <xsl:template match="/MovieRank/Movie">
        <div class="border">
            <div class="headpart">
                <table border="2" align="center">
                    <tr bgcolor="#9acd32" align="center">
                        <td>名称</td><td><xsl:value-of select="Name/StandardName"></xsl:value-of></td>
                    </tr>
                    <tr align="center">
                        <td>排名</td><td><xsl:value-of select="@Rank"/></td>
                    </tr>
                    <tr bgcolor="#9acd32" align="center">
                        <td>评分</td><td><xsl:value-of select="Rating"/></td>
                    </tr>
                    <tr align="center">
                        <td>导演</td><td><xsl:value-of select="Director"/></td>
                    </tr>
                    <tr bgcolor="#9acd32" align="center">
                        <td>编剧</td>
                        <td>                        
                            <xsl:for-each select="ScriptWriter">
                                <xsl:value-of select="." /><xsl:text> </xsl:text>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr align="center">
                        <td>演员</td>
                        <td>
                            <xsl:for-each select="ActorList/Actor[position() &lt; 6]">
                                <xsl:value-of select="." />
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr bgcolor="#9acd32" align="center">
                        <td>分类</td>
                        <td>
                            <xsl:for-each select="Category">
                                <xsl:value-of select="@type" /><xsl:text> </xsl:text>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr align="center">
                        <td>上映日期</td><td><xsl:value-of select="Date"/></td>
                    </tr>
                    <tr bgcolor="#9acd32" align="center">
                        <td>时长</td>
                        <td><xsl:value-of select="Length"/></td>
                    </tr>
                    <tr align="center">
                        <td>别名</td>
                        <td>
                            <xsl:for-each select="Name/OtherName" >
                                <xsl:value-of select="." disable-output-escaping="yes"/><xsl:text> </xsl:text>
                            </xsl:for-each>
                        </td>
                    </tr>
                </table>
                <p></p>
            </div>
            <div class="photopart">
                <img src="./PIC.png"  height="150%" />
            </div>
        </div>
        <br/>
        <br/>
        <br/>
        <smallTitle>简要介绍</smallTitle>
        <div class="intro-css">
            <br/>
            <Intro><xsl:value-of select="/MovieRank/Movie/Intro"/></Intro>
        </div>
        <br/>
        <smallTitle>获奖情况</smallTitle>
        <xsl:apply-templates select="/MovieRank/Movie/AwardList"/>
        <br/>
        <br/>
        <br/>
        <br/>
    </xsl:template>

    <xsl:template match="/MovieRank/Movie/AwardList">
        <div>
            <table border="3" align="left">
            <xsl:for-each select="Award" >
                <tr align="center" >
                    <td>
                        <xsl:value-of select="."/>
                    </td>
                </tr>
            </xsl:for-each>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>