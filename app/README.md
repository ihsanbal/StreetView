ObjectBee
=======

A simple data transporte library

[![Join the chat at https://gitter.im/ihsanbal/ObjectBee](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ihsanbal/ObjectBee?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![License](http://img.shields.io/badge/License-Apache%202-brightgreen.svg?style=flat)](https://github.com/ihsanbal/ObjectBee/blob/master/LICENSE)
[![Build Status](https://travis-ci.org/ihsanbal/ObjectBee.svg?branch=master)](https://travis-ci.org/ihsanbal/ObjectBee)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ObjectBee-green.svg?style=flat)](http://android-arsenal.com/details/1/2041)


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
	        compile 'com.github.ihsanbal:ObjectBee:1.1.0'
	}
```
or Maven:
```xml
<dependency>
   <groupId>com.github.ihsanbal</groupId>
   <artifactId>ObjectBee</artifactId>
   <version>1.1.0</version>
</dependency>
```
TODO
--------
Change object cache algorithm,maybe use a good library
And reload this README file with a proper english :)

Usage
--------
You must to create data model extends BeeModel
```java
package ihsan.bal.library.base;

import java.io.Serializable;

/**
 * Created by ihsan on 23/05/15.
 */
public class BeeModel implements Serializable {

    public boolean deletepullobject;

    public String referencesname;
    /*
    * default ok_response code 100
    * error_response code 99
    * */
    public int responsecode = 100;

    public String responsemessage;

    public BeeModel(String referencesname){
        if (referencesname!=null)
        this.referencesname = referencesname;
    }

}
```
Example Data Model
```java

public class ViewModel extends BeeModel {

    public String title;

    public String name;

    public String age;

    public ViewModel(String tag) {
        super(tag);
    }

    //default constructor without tag property
    public ViewModel() {
    }

    //constructor with tag property
    public ViewModel(String tagPref) {
        super(tagPref);
    }
}
```

If you want do save data and start activity
```java

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
