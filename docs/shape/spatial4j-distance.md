# Spatial距离计算
## 1.距离计算工具类DistanceUtils
测试点数据选取点符合(勾三股四玄五)
### 1.1 DistanceUtils.distLawOfCosinesRAD
本计算式理论模型为余玄定理,平面计算通过三角函数,误差较大,入参返回(单位弧度)
```
double lat1 = DistanceUtils.toRadians(0.0);
double lon1 = DistanceUtils.toRadians(0.0);
double lat2 = DistanceUtils.toRadians(4.0);
double lon2 = DistanceUtils.toRadians(3.0);
//余玄定理，平面计算DistanceUtils.distLawOfCosinesRAD
double distLawOfCosinesRad = DistanceUtils.distLawOfCosinesRAD(lat1,lon1,lat2,lon2);

//弧度转换为角度
double distLawOfCosinesDegrees = DistanceUtils.toDegrees(distLawOfCosinesRad);
System.out.println("距离(度):"+distLawOfCosinesDegrees);
```
### 1.2 DistanceUtils.distVincentyRAD
本计算式理论模型为椭球模型，计算时会多次迭代，理论计算精度较高,入参返回(单位弧度)
```
//椭球模型DistanceUtils.distVincentyRAD
double distVincentyDegree = DistanceUtils.toDegrees(DistanceUtils.distVincentyRAD(lat1,lon1,lat2,lon2));
System.out.println("椭球模型,距离(度):"+distVincentyDegree);
```
### 1.3 DistanceUtils.distHaversineRAD
本计算式选取地球模型为球模型，以赤道半径为基准，故计算时纬度越高误差会越大，但胜在快速,入参返回(单位弧度)
```
//球模型DistanceUtils.distHaversineRAD
double distHaversineDegree = DistanceUtils.toDegrees(DistanceUtils.distHaversineRAD(lat1,lon1,lat2,lon2));
System.out.println("球模型,距离(度):"+distHaversineDegree);
```
输出结果：
```
余玄定理,距离(度):4.998536879937023
椭球模型,距离(度):4.998536879936981
球模型,距离(度):4.998536879936979
```
远离赤道的一组测试值:
```
double lat1 = DistanceUtils.toRadians(20.0);
double lon1 = DistanceUtils.toRadians(110.0);
double lat2 = DistanceUtils.toRadians(23.0);
double lon2 = DistanceUtils.toRadians(114.0);
```
输出结果
```
余玄定理,距离(度):4.779689871912692
椭球模型,距离(度):4.779689871912726
球模型,距离(度):4.7796898719127245
```
### 1.4 单位转换
实现弧度，度，距离的转换
### 1.4.1 DistanceUtils.toDegrees 弧度转换为度
### 1.4.2 DistanceUtils.toRadians 度转换为弧度
### 1.4.3 DistanceUtils.dist2Degrees(double dist, double radius) 距离(KM)转换为度
1KM大约等于=0.008993203677616636度
```
double radius = DistanceUtils.EARTH_MEAN_RADIUS_KM; //地球平均半径
//1KM大约等于多少度
double kmToDegree = DistanceUtils.dist2Degrees(1, radius);
System.out.println("1KM大约等于="+kmToDegree+"度");
//1KM大约等于=0.008993203677616636度
```
### 1.4.4 DistanceUtils.degrees2Dist(double dist, double radius) 度转换为距离(KM)
1度大约等于=111.19507973436875KM
```
//1度大约等于多少千米
double degreeToKm = DistanceUtils.degrees2Dist(1,radius);
System.out.println("1度大约等于="+degreeToKm+"KM");
//1度大约等于=111.19507973436875KM
```
### 1.4.5 DistanceUtils.radians2Dist(double dist, double radius) 弧度转换为(KM)
1弧度大约等于=6371.0087714KM
```
//1弧度大约等于多少千米
double radiansToKm = DistanceUtils.radians2Dist(1,radius);
System.out.println("1弧度大约等于="+radiansToKm+"KM");
//1弧度大约等于=6371.0087714KM
```
### 1.4.6 DistanceUtils.dist2Radians(double dist, double radius) 距离(KM)转换为弧度
1Km大约等于=1.5696101447687296E-4度
```
//1KM大约等于多少弧度
double kmToRadians = DistanceUtils.dist2Radians(1,radius);
System.out.println("1Km大约等于="+kmToRadians+"弧度");
//1Km大约等于=1.5696101447687296E-4弧度
```

## 2.辅助类
### 2.1 CartesianDistCalc平面公式辅助类
### 2.2 GeodesicSphereDistCalc球面模型辅助类
