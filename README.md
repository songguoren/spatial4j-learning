# spatial4j-learning

## 介绍
Spatial4j是一款java编写的空间计算开源库，支持ASL开源协议，支持地理空间计算。<br>
Spatial4j主要有三个主要功能：<br>
1）支持基于平面几何或地理空间的若干图形；<br>
2）支持距离计算和形状的计算：计算边界框、面积、图形间的关系等<br>
3）解析WKT、GeoJSON等空间描述标准格式<br>
Spatial4j利用了部分JTS的能力（JTS是最流行的java空间计算库），例如多边形是基于JTS实现的。相比与JTS，spatial4j还支持了圆以及地理空间计算。用JTS，通常用多边形近似替代了圆的计算，对结果会造成一定误差，而Spatial4j支持了圆；另外，地理空间计算的应用现在十分广泛，用spatial4j会更加方便。

## 项目结构
1）context  几何工厂，负责创建相关几何对象<br>
2）distance 相关计算包 <br>
3）exception  <br>
4）io  输入输出:geoJson WKT WKB 等 <br>
5）shape 几何形状，处理对象实体  <br>
## 使用说明
[shape几何结构说明](docs/shape/shape.md)<br>
[shape几何创建](docs/shape/shape-create.md)<br>
[平面坐标系与空间坐标系下面的几何关系](docs/shape/shape-relate.md)<br>
[Spatial距离计算](docs/shape/spatial4j-distance.md)<br>
[Spatial WKT格式解析](docs/shape/wktreadwrite.md)<br>
[Spatial GeoJSON格式解析](docs/shape/geojson.md)<br>
## 安装教程
```xml
<dependency>
    <groupId>org.locationtech.spatial4j</groupId>
    <artifactId>spatial4j</artifactId>
    <version>0.8</version>
</dependency>
<dependency>
    <groupId>org.noggit</groupId>
    <artifactId>noggit</artifactId>
    <version>0.8</version>
    <optional>true</optional>
</dependency>

<!-- Used for optional Jackson support -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.10.8</version>
    <optional>true</optional>
</dependency>

<!-- JTS is essentially only used for polygons. -->
<dependency>
    <groupId>org.locationtech.jts</groupId>
    <artifactId>jts-core</artifactId>
    <version>1.18.1</version>
    <optional>true</optional>
</dependency>
```
## 代码类库地址
[spatial4j GitHub](https://github.com/locationtech/spatial4j)
