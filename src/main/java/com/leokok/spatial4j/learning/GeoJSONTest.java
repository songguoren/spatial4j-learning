package com.leokok.spatial4j.learning;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.io.GeoJSONReader;
import org.locationtech.spatial4j.io.GeoJSONWriter;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.jts.JtsShapeFactory;
import java.io.IOException;
import java.text.ParseException;

public class GeoJSONTest {

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
}
