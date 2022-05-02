package com.leokok.spatial4j.learning;

import org.locationtech.spatial4j.distance.DistanceUtils;

/**
 * 距离计算
 */
public class DistanceTest {

    public static void main(String[] args) {
        //余玄定理，平面计算DistanceUtils.distLawOfCosinesRAD
        double lat1 = DistanceUtils.toRadians(0.0);
        double lon1 = DistanceUtils.toRadians(0.0);
        double lat2 = DistanceUtils.toRadians(4.0);
        double lon2 = DistanceUtils.toRadians(3.0);

        /*double lat1 = DistanceUtils.toRadians(20.0);
        double lon1 = DistanceUtils.toRadians(110.0);
        double lat2 = DistanceUtils.toRadians(23.0);
        double lon2 = DistanceUtils.toRadians(114.0);*/

        double distLawOfCosinesRad = DistanceUtils.distLawOfCosinesRAD(lat1,lon1,lat2,lon2);

        //弧度转换为角度
        double distLawOfCosinesDegrees = DistanceUtils.toDegrees(distLawOfCosinesRad);
        System.out.println("余玄定理,距离(度):"+distLawOfCosinesDegrees);

        //椭球模型DistanceUtils.distVincentyRAD
        double distVincentyDegree = DistanceUtils.toDegrees(DistanceUtils.distVincentyRAD(lat1,lon1,lat2,lon2));
        System.out.println("椭球模型,距离(度):"+distVincentyDegree);

        //球模型DistanceUtils.distHaversineRAD
        double distHaversineDegree = DistanceUtils.toDegrees(DistanceUtils.distHaversineRAD(lat1,lon1,lat2,lon2));
        System.out.println("球模型,距离(度):"+distHaversineDegree);

        //DistanceUtils.dist2Degrees(double dist, double radius) 距离(KM)转换为度
        double radius = DistanceUtils.EARTH_MEAN_RADIUS_KM; //地球平均半径
        //1KM大约等于多少度
        double kmToDegree = DistanceUtils.dist2Degrees(1, radius);
        System.out.println("1KM大约等于="+kmToDegree+"度");
        //1KM大约等于=0.008993203677616636度

        //1度大约等于多少千米
        double degreeToKm = DistanceUtils.degrees2Dist(1,radius);
        System.out.println("1度大约等于="+degreeToKm+"KM");
        //1度大约等于=111.19507973436875KM

        //1弧度大约等于多少千米
        double radiansToKm = DistanceUtils.radians2Dist(1,radius);
        System.out.println("1弧度大约等于="+radiansToKm+"KM");
        //1弧度大约等于=6371.0087714KM

        //1KM大约等于多少弧度
        double kmToRadians = DistanceUtils.dist2Radians(1,radius);
        System.out.println("1Km大约等于="+kmToRadians+"弧度");
        //1Km大约等于=1.5696101447687296E-4弧度


    }
}
