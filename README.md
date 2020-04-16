# XML Readme

<div align="center">
组长: 71117123 张建东
    <br/>
组员: 71117124 湛钊
    <br/>
    2020.2.24 - 2020.4.16
</div></div>

## Source Code Content
1. EXP_Week_1_3 1-3周实验存档
   1. `GroupInfo.xml` 小组信息和成员名片的xml文件
   2. `lesson3(2020_3_2).xml` 基本的电影详细信息xml文件
   3. `MoveRank.dtd` 基本的dtd验证文件
2. EXP_Week4: Schema+爬虫批量导入
   1. `crawltop.py` 之前写的豆瓣爬虫
   2. `generate_data.py` 生成xml的爬虫文件
   3. `douban.txt` 爬虫record
   4. `dbMovie.xml` 生成的xml文件
   5. `dbMovie_All.xml` 含25个数据的xml文件
   6. `DoubanMovie.dtd` 完整的dtd文件
   7. `DoubanMovie.xsd` 完整的Schema文件
   8. `DoubanMovie.xml` 含1个数据的xml文件
3. EXP_Week5: xlsx + css + xquery
   1. xquery_files: 三个XQuery实验
      1. `task2_2_1.xquery`: 利用函数, 参数化进行分组查询
      2. `task2_2_2.xquery`: 利用函数, 参数化进行区间简单逻辑与查询
      3. `task_2_2_cur.xquery`: 利用嵌套, 进行区间逻辑与查询
      4. `task2_2_3.xquery`: xml的拼接
   2. `GroupInfo.css/xml/xslt`: 小组名片
   3. `movieDetail.css/xml/xslt`: 海报1
   4. `doubanMovie.css/xml/xslt/xsd/dtd`: 电影信息主列表
      1. `doubanMovie.xml` 包含100个电影信息的xml数据文件
      2. `doubanMovie.xslt` 用于展示电影列表信息的xslt文件
      3. `doubanMovie.css` 电影列表信息的样式表
      4. `doubanSchema.xsd` 电影数据的Schema验证文件
      5. `DoubanMovie.dtd` 电影数据的DTD验证文件
   5. `poster2.css/xml/xslt`: 海报2 特点是css使用丰富，且有开场动画
4. EXP_Week8: DOM + SAX
   1. Dom文件夹下, index.css/index.html/index.js/load.js 为新增文件
      1. `load.js` 创建xmldom对象的脚本文件
      2. `index.js` 主页面的控制脚本
      3. `index.css` 更新后的主页的样式表
      4. `index.html` 主页的html文件
   2. SAX文件夹包含SAX程序的源代码和数据
      1. `doubanMovie.xml` 全部电影的xml数据文件
      2. `DoubanMovieSax.java` 主方法，创建一个java图形化程序来调用解析
      3. `MovieDetail.java` 储存电影信息的类
      4. `PickMovieHandler.java` 提供根据电影名查询电影的句柄
      5. `RandomMovieHandler.java` 提供随机查看电影信息的句柄
## *Final-Submited Materials*

1. 1InformationModel 基本的信息模型
   
   1. `DoubanMovie.xml` 包含一个电影信息数据的xml文件
   2. `DoubanMovie.dtd` 对电影数据的dtd验证文件
   3. `doubanSchema.xsd` 对电影数据的Schema验证文件
   
2. 2Transformation 利用xsl来展示xml数据信息
   
   1. `doubanMovie.css/xml/xslt/xsd/dtd`: 电影信息主列表
      1. `doubanMovie.xml` 包含100个电影信息的xml数据文件
      2. `doubanMovie.xslt` 用于展示电影列表信息的xslt文件
      3. `doubanMovie.css` 电影列表信息的样式表
      4. `doubanSchema.xsd` 电影数据的Schema验证文件
      5. `DoubanMovie.dtd` 电影数据的DTD验证文件
   2. `GroupInfo.css/xml/xslt`: 小组名片
   3. `movieDetail.css/xml/xslt`: 电影海报1
   
1. 3Query  三个XQuery实验
   
   1. `task2_2_1.xquery`: 利用函数, 参数化进行分组查询
   2. `task2_2_2.xquery`: 利用函数, 参数化进行区间简单逻辑与查询
   3. `task_2_2_cur.xquery`: 利用嵌套, 进行区间逻辑与查询
   4. `task2_2_3.xquery`: xml的拼接
   5. `doubanMovie.xml` 电影信息xml数据文件
   6. `newCome.xml` 新加入的补充电影信息数据xml文件
   
4. 4DomSax

    > Dom文件夹下, index.css/index.html/index.js/load.js 为新增文件

    1. `load.js` 创建xmldom对象的脚本文件
    2. `index.js` 主页面的控制脚本
    3. `index.css` 更新后的主页的样式表
    4. `index.html` 主页的html文件

    > SAX文件夹包含SAX程序的源代码和数据

    1. `doubanMovie.xml` 全部电影的xml数据文件
    2. `DoubanMovieSax.java` 主方法，创建一个java图形化程序来调用解析
    3. `MovieDetail.java` 储存电影信息的类
    4. `PickMovieHandler.java` 提供根据电影名查询电影的句柄
    5. `RandomMovieHandler.java` 提供随机查看电影信息的句柄
    
5. materials: 包含本文档的pdf版本, 演示视频

## Example

Please visit the [website](zjdx1998.com/xmlexp).

> Remark:
>
> 实验总分工比为1:1
