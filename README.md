# ImageTest

* It's a test ImageView with bottom rounded bitmap corners. The main task is not to draw bitmap with image source, but is to cut it using a created shape. 

# Algorithm
1. Initiate your shape within init() method using Canvas, Bitmap and Paint.
2. In onDraw() method use superclass onDraw() to draw your target image, also you need to specify Paint mode depends on how you want your image to interract with drawn shape.
3. After that, you must draw your shape by drawBitmap(...).

Note: your shape must be behind the image, that's for we need setLayerType(LAYER_TYPE_HARDWARE, paint);

# Advantages
If you draw image using Bitmap, you have to correct scale somehow, because bitmap will fill View window.
To avoid that problem and unnecessary code, let built-in interfaces do the job for you.
super.onDraw() reads scaleType, so it won't be a problem to change scaleType right in XML.
