package com.leokok.spatial4j.learning;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.context.jts.JtsSpatialContextFactory;
import org.locationtech.spatial4j.shape.Circle;
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.shape.ShapeFactory;
import org.locationtech.spatial4j.shape.impl.PointImpl;

public class Demo {

    public static void main(String[] args) {
        SpatialContext ctx = SpatialContext.GEO;
        ShapeFactory shapeFactory = ctx.getShapeFactory();
        Circle circle = shapeFactory.circle(new PointImpl(0.0,0.0,ctx),1);



        JtsSpatialContextFactory jtsCtxFactory = new JtsSpatialContextFactory();
        JtsSpatialContext jtsCtx = jtsCtxFactory.newSpatialContext();
        GeometryFactory geometryFactory = jtsCtxFactory.getGeometryFactory();
        Point point = geometryFactory.createPoint();//empty
        Shape shape = jtsCtx.getShapeFactory().makeShapeFromGeometry(point); // don't throw

    }
}
