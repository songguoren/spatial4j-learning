package com.leokok.spatial4j.learning;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.io.ShapeWriter;
import org.locationtech.spatial4j.shape.Circle;
import org.locationtech.spatial4j.shape.Rectangle;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.ShapeFactory;
import org.locationtech.spatial4j.shape.impl.BBoxCalculator;
import org.locationtech.spatial4j.shape.impl.CircleImpl;
import org.locationtech.spatial4j.shape.impl.PointImpl;
import org.locationtech.spatial4j.shape.impl.RectangleImpl;
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
import org.locationtech.spatial4j.shape.jts.JtsShapeFactory;

/**
 * 使用说明
 */
public class ShapeCreateTest {

    public static void main(String[] args) {

        //1.spatial4j创建工厂 SpatialContext GEO模式(通过球计算公式计算相关关系)
        SpatialContext sCtx = SpatialContext.GEO;
        ShapeFactory shapeFactory = sCtx.getShapeFactory();

        //2.spatial4j原生几何对象创建 circle、GeoCircle[-180,180]其它值将进行转换、Rectangle、PointImpl
        //2.1 方式一通过 shapeFactory
        ShapeFactory.LineStringBuilder lineStringBuilder = shapeFactory.lineString();
        Shape shapeLine = lineStringBuilder.pointXYZ(1,2,3).pointXYZ(2,3,4).build();

        //2.2方式二通过 impl实现类
        Circle circle = new CircleImpl(new PointImpl(0,0,sCtx),0.01,sCtx);
        Rectangle rectangle = new RectangleImpl(new PointImpl(3.0,4.0, sCtx), new PointImpl(7.0,8.0,sCtx),sCtx);
        Rectangle rectangle2 = new RectangleImpl(new PointImpl(5.0,2.0, sCtx), new PointImpl(10.0,7.0,sCtx),sCtx);


        //1.JTS对象创建 JtsSpatialContext
        //创建JtsSpatialContext
        JtsSpatialContext jtsCtx = JtsSpatialContext.GEO;
        JtsShapeFactory jtsShapeFactory = jtsCtx.getShapeFactory();

        //创建jts对象 Point LineString Polygon等
        GeometryFactory geometryFactory = jtsShapeFactory.getGeometryFactory();
        Coordinate coordinate = new Coordinate(0.0,1.1,1);
        Point point = geometryFactory.createPoint(coordinate);

        //JTS转shape
        JtsGeometry jtsPoint = jtsShapeFactory.makeShape(point);


        //shape转化为JTS对象
        Geometry circleGeo = jtsShapeFactory.getGeometryFrom(circle);
        System.out.println("shape circle to jts geometry:"+circleGeo.toText());
        Geometry rectangleGeo = jtsShapeFactory.getGeometryFrom(rectangle);
        System.out.println("shape rectangle to jts geometry:"+rectangleGeo.toText());
        Geometry rectangle2Geo = jtsShapeFactory.getGeometryFrom(rectangle2);
        System.out.println("shape rectangle2 to jts geometry:"+rectangle2Geo.toText());



        //计算多个shape的外边界
        BBoxCalculator bBoxCalculator = new BBoxCalculator(sCtx);
        bBoxCalculator.expandRange(rectangle);
        bBoxCalculator.expandRange(rectangle2);
        Rectangle rectangleBBox = bBoxCalculator.getBoundary();

        Geometry rectangleBBoxGeo = jtsShapeFactory.getGeometryFrom(rectangleBBox);
        System.out.println("shape rectangleBBox to jts geometry:"+rectangleBBoxGeo.toText());



    }

}
