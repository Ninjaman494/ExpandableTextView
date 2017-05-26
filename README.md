# ExpandableTextView
An expandable TextView based off the Google Play Store description. Each section of the View can contain different text and be
independently styled.

<img src="http://imgur.com/92LEi3t.gif" width=360 height=640 />

View is split into two portions,blurb and description. The blurb portion is
displayed when the View is collapsed or expanded. The description portion is only shown when the View is expanded. Each section is a TextView,
this means that each portion can be independtly stylized just like a TextView. See the sample code for an example.

## Setup
Add the following dependecy to your app's build.gradle
```groovy

dependencies {
    compile 'ninjaman494:expandable-textview:1.1.1'
}

```

## Usage
Simply add the View to the Activity or Fragment's XML.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:animateLayoutChanges="true"
    android:weightSum="1">

    <ninjaman494.expandabletextview.ExpandableTextView
        android:id="@+id/expandable"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Expand"/>

</LinearLayout>
```
The rest must be done programmatically, but this is very easy. Simply get the TextViews for the blurb and description portions and then style them
like you would a regular TextView. All TextView methods should work, but I have only tested the ones below.
```java
  //Styling blurb portion
  TextView blurb = etv.getBlurbView();
  blurb.setGravity(Gravity.CENTER);
  blurb.setTypeface(null, Typeface.BOLD);
  blurb.setTextSize(16);

  //Styling description portion
  TextView desp = etv.getDespView();
  desp.setTextSize(16);
```

There are also ExpandableTextView specific methods that you can use.
```java
  etv.setBlurbText(blurbExample); \\ Sets the Blurb text to String blurbExample
  etv.setDespText(despExample);   \\ Sets the Description text to String despExample
  etv.startExpanded(true);        \\ Starts the View in expanded form instead of collapsed. Default is false
  etv.setAnimSpeed(150);          \\ Sets the animation speed to 150 miliseconds. Default is 375 ms
  etv.setCollapsedLineCount(4);   \\ Sets the number of lines in the blurb portion to 4. Default is 3
  etv.isExpanded();               \\ Returns true if the View is currently expanded, false if collapsed
```

In order to expand or collapse the view call the ``` toggle() ``` method. This is usally done in an onClickListener.
```java
  Button btn = (Button)findViewById(R.id.btn);
  btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      etv.toggle();
      if(etv.isExpanded()){
        ((Button)v).setText("Collapse");
      }else{
        ((Button)v).setText("Expand");
      }
    }
  });
```

## Requirments
Minimum SDK is 16


## License
```
Copyright 2017 Akash Eldo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
