public static int count2DShapes(Shape[] shapes) {
    int counter = 0;
    for (Shape item : shapes) {
        if (Shape2D.class.isInstance(item) && item.getClass() != Shape2D.class) {
            counter++;
        }
    }
    return counter;
}