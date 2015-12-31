StreetView
=======

Google Street View Image API Android Library

<p align="center">
    <img src="https://lh3.googleusercontent.com/50-i3khy6z44n6xQsiJKx6WqLWK4zeb6IyXJYW2qZJGBE_2QvWSI5an09m-H7WgMlRqQ=w300-rw" alt="Google Street View"/>
</p>

[![License](http://img.shields.io/badge/License-Apache%202-brightgreen.svg?style=flat)](https://github.com/ihsanbal/StreetView/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/ihsanbal/ObjectBee.svg?branch=master)](https://travis-ci.org/ihsanbal/StreetView)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-StreetView-green.svg?style=flat)](http://android-arsenal.com/details/1/2041)


Download
--------

Download [the latest AAR][2] or grab via Gradle:
```groovy
repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
	
dependencies {
	         compile 'com.github.ihsanbal:StreetView:1.0.0'
	}
```
or Maven:
```xml
<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>

<dependency>
	    <groupId>com.github.ihsanbal</groupId>
	    <artifactId>StreetView</artifactId>
	    <version>1.0.0</version>
</dependency>
```

##[ScreenShot](https://github.com/ihsanbal/StreetView/blob/master/images/device-istanbul_view.png)

StreetView use the [Retrofit](https://github.com/square/retrofit) 

Pic form [istanbul](https://www.google.com.tr/maps/place/%C4%B0stanbul/@41.02881,28.946502,3a,75y,90t/data=!3m8!1e2!3m6!1s87258476!2e1!3e10!6s%2F%2Flh6.googleusercontent.com%2Fproxy%2FJOnyZ62VmmGhlqtu5FwscwAxSc9rCB0ptWdxKyF47Cs9wpPRZ6U8rfLgweSv3eU8sZsKK-9SOGISndy3eyX44SbQwBSC-w%3Dw139-h86!7i4704!8i2900!4m2!3m1!1s0x14caa7040068086b:0xe1ccfe98bc01b0d0!6m1!1e1?hl=tr)

<p align="center">
    <img src="https://github.com/ihsanbal/StreetView/blob/master/images/device-istanbul_view.png" alt="İSTANBUL" height="800" width="420"/>
</p>

Usage
--------

```java

                StreetView streetView = new StreetView.Builder("AIzaSyDJwAJBnh_N5cJ0mNU9hspD9S55oJGmijo")
                            .pitch("-0.76")
                            .heading("80.0")
                            .size("600x400")
                            .build();
                            
                streetView.getStreetView(new LatLng(41.0421119, 29.0379787), new CallBack() {
                    @Override
                    public void onResponse(Response<ResponseBody> response, Retrofit retrofit, Bitmap bitmapStreetView) {
                        streetViewContainer.setImageBitmap(bitmapStreetView);
                    }
                         
                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });

```

Licence
--------------
Copyright [2015] [İHSAN BAL]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Author
--------------
[İHSAN BAL](https://github.com/ihsanbal)
