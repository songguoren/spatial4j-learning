# org.locationtech.spatial4j.shape使用说明
spatial4j提供的核心几何对象
## 类结构图
![shape.png](../images/shape.png)<br>
## 说明
Shape底层，提供了共用接口方法:relate、getBoundingBox、hasArea、getArea、getCenter、getBuffered、isEmpty、getContext等方法<br/>
Circle圆形几何结构<br/>
Rectangle矩形结构<br/>
point、linestring等通过jts来支持
