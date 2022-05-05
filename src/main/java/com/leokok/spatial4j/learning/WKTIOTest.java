package com.leokok.spatial4j.learning;

import org.locationtech.jts.io.ParseException;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.io.WKTReader;
import org.locationtech.spatial4j.io.WKTWriter;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.ShapeFactory;
import java.io.IOException;

/**
 * WKT文件IO 读取/输出
 */
public class WKTIOTest {

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
}
