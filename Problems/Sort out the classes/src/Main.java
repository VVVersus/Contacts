public static void sortShapes(Shape[] array,
                              List<Shape> shapes,
                              List<Polygon> polygons,
                              List<Square> squares,
                              List<Circle> circles) {
    for (Shape item : array) {
        if (item.getClass() == Shape.class) {
                shapes.add(item);
        } else if (item.getClass() == Polygon.class) {
            polygons.add((Polygon) item);
        } else if (item.getClass() == Square.class) {
            squares.add((Square) item);
        } else if (item.getClass() == Circle.class) {
            circles.add((Circle) item);
        }
        }
}