# Spatial4j geoJson格式操作
GeoJson 是一种使用 JSON 编码（RFC7159）对各种地理数据结构进行编码的格式。 GeoJson 对象可以表示一个空间区域(Geometry)、一个空间有界实体(Feature)或一系列特征集合(FeatureCollection)。 GeoJson 支持以下几何类型: Point、 LineString、 Polygon、 MultiPoint、 MultiLineString、 MultiPolygon和 GeometryCollection。 特征包含一个 Geometry 对象和其他属性，而特征集合包含一个特征列表。

这种格式从最广泛的意义上讲与地理数据有关，任何具有地理空间界限的特性的东西都可能是一个特征，不管它是否是一个物理结构。 GeoJson 中的概念并不新鲜，它们来自于先前存在的开放地理信息系统标准，并且已经进行了简化，以更好地适应使用 JSON 的 WEB 应用程序开发。

GeoJson 包含了在 OpenGIS 的简单特征实现规范中定义的七种具体的几何类型: 0 维是 Point 和 MultiPoint;1 维曲线 LineString 和 MultiLineString; 2 维曲面 Polygon 和 MultiPolygon;异构的 GeometryCollection。 这些几何类型的 GeoJSON 实例类似于在同一规范中描述的二进制(WKB)和文本(WKT)。

GeoJson 还包含类型 Feature 和 FeatureCollection。 GeoJson 中的 Feature 对象包含一个 Geometry 对象，该对象具有上述几何类型之一和其他属性。 FeatureCollection 对象包含一个 Feature 对象数组。

[geoJSON规范](https://geojson.org/) <br>

# 操作示例
```
public static void main(String[] args) throws IOException, ParseException {
        JtsSpatialContext jtsSpatialContext = JtsSpatialContext.GEO;
        JtsShapeFactory jtsShapeFactory = jtsSpatialContext.getShapeFactory();

        //读取 丢失z
        GeoJSONReader geoJSONReader = (GeoJSONReader) jtsSpatialContext.getFormats().getGeoJsonReader();
        Shape shape = geoJSONReader.read("{\n" +
                "         \"type\": \"Polygon\",\n" +
                "         \"coordinates\": [\n" +
                "             [\n" +
                "                 [100.0, 0.0, 2],\n" +
                "                 [101.0, 0.0, 3],\n" +
                "                 [101.0, 1.0, 4],\n" +
                "                 [100.0, 1.0, 5],\n" +
                "                 [100.0, 0.0, 6]\n" +
                "             ]\n" +
                "         ]\n" +
                "     }");

        Geometry geometry = jtsShapeFactory.getGeometryFrom(shape);

        //输出
        GeoJSONWriter geoJSONWriter = (GeoJSONWriter) jtsSpatialContext.getFormats().getGeoJsonWriter();
        System.out.println(geoJSONWriter.toString(shape));
    }
```