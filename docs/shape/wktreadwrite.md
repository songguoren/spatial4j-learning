# Spatial WKT格式解析
对WKT格式的数据的输入输出操作，WKT(Well-known text)是一种文本标记语言，用于表示矢量几何对象、空间参照系统及空间参照系统之间的转换。<br/>
WKT可以表示的几何对象包括：点，线，多边形，TIN（不规则三角网）及多面体。可以通过几何集合的方式来表示不同维度的几何对象。<br/>
几何物体的坐标可以是2D(x,y),3D(x,y,z),4D(x,y,z,m),加上一个属于线性参照系统的m值。<br/><br/>
以下为几何WKT字串样例：<br/>
POINT(6 10) //点<br/>
LINESTRING(3 4,10 50,20 25)//线<br/>
POLYGON((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)) //面<br/>
MULTIPOINT(3.5 5.6, 4.8 10.5)//多点<br/>
MULTILINESTRING((3 4,10 50,20 25),(-5 -8,-10 -8,-15 -4))//多线<br/>
MULTIPOLYGON(((1 1,5 1,5 5,1 5,1 1),(2 2,2 3,3 3,3 2,2 2)),((6 3,9 2,9 4,6 3)))//多面<br/>
GEOMETRYCOLLECTION(POINT(4 6),LINESTRING(4 6,7 10))//复杂几何<br/>
POINT EMPTY<br/>
MULTIPOLYGON EMPTY<br/>
[OGC标准Simple Feature Access - Part 1: Common Architecture](https://www.ogc.org/standards/sfa) <br>
## WKT文件读取
```
public static void main(String[] args) throws IOException, java.text.ParseException {
        SpatialContext ctx = SpatialContext.GEO;
        ShapeFactory shapeFactory = ctx.getShapeFactory();

        //输入
        WKTReader wktReader = (WKTReader) ctx.getFormats().getWktReader();
        //注意，WKTReader对z未处理，读取后原始wkt带z会忽略解析
        Shape shape = wktReader.read("LINESTRING Z (115.74182468575002 39.53281458633649 83.649979,115.741691446562 39.5324920164886 83.47871099999999)");

        //输出
        WKTWriter wktWriter = (WKTWriter) ctx.getFormats().getWktWriter();
        System.out.println(wktWriter.toString(shape));
        
 }
```