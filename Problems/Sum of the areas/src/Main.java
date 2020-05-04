public static int sumOfAreas(Shape[] array) {
    int totalArea = 0;
    for (Shape item : array) {
        if (item.getClass() == Square.class) {
            Square conctereItem = (Square) item;
            totalArea += conctereItem.getSide() * conctereItem.getSide();
        } else if (item.getClass() == Rectangle.class) {
        Rectangle conctereItem = (Rectangle) item;
            totalArea += conctereItem.getWidth() * conctereItem.getHeight();
        }
    }
    return totalArea;
}