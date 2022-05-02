package com.leokok.spatial4j.learning;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.context.SpatialContextFactory;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
import org.locationtech.spatial4j.context.jts.JtsSpatialContextFactory;

public class ShapeCreateNoGeoTest {

    public static void main(String[] args) {
        SpatialContextFactory spatialContextFactory = new SpatialContextFactory();
        spatialContextFactory.geo = false;
        SpatialContext spatialContext = spatialContextFactory.newSpatialContext();

        JtsSpatialContextFactory jtsSpatialContextFactory = new JtsSpatialContextFactory();
        jtsSpatialContextFactory.geo = false;
        JtsSpatialContext jtsSpatialContext = jtsSpatialContextFactory.newSpatialContext();
    }
}
