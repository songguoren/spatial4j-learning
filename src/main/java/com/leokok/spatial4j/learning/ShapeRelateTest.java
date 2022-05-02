package com.leokok.spatial4j.learning;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.context.SpatialContextFactory;
import org.locationtech.spatial4j.shape.Circle;
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.spatial4j.shape.impl.CircleImpl;
import org.locationtech.spatial4j.shape.impl.PointImpl;

/**
 * 平面坐标系与空间坐标系下面几何关系
 */
public class ShapeRelateTest {

    public static void main(String[] args) {
        SpatialContextFactory nonGeoContextFactory = new SpatialContextFactory();
        nonGeoContextFactory.geo = false;
        SpatialContext nonGeoContext = nonGeoContextFactory.newSpatialContext();

        // 平面坐标系中的圆
        Point pointLeft = new PointImpl(-179, 0, nonGeoContext);
        Point pointRight = new PointImpl(179, 0, nonGeoContext);
        Circle circleLeft = new CircleImpl(pointLeft, 10, nonGeoContext);
        Circle circleRight = new CircleImpl(pointRight, 10, nonGeoContext);
        System.out.println("平面坐标系下面圆的关系: " + circleLeft.relate(circleRight));

        // 地理空间中的圆
        Point geoCenterWest = new PointImpl(-179, 0, SpatialContext.GEO);
        Point geoCenterEast = new PointImpl(179, 0, SpatialContext.GEO);
        Circle geoCircleWest = new CircleImpl(geoCenterWest, 10, SpatialContext.GEO);
        Circle geoCircleEast = new CircleImpl(geoCenterEast, 10, SpatialContext.GEO);
        System.out.println("地理空间中的圆的关系: " + geoCircleWest.relate(geoCircleEast));

        //结果
//        平面坐标系下面圆的关系: DISJOINT
//        地理空间中的圆的关系: INTERSECTS
    }


}
