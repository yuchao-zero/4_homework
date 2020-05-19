package club.banyuan;

public class RectangleMeasurer<T> implements Measurer<Rectangle> {
  @Override
  public double measure(Rectangle anObject) {
    return anObject.width * anObject.height;
  }

  //  @Override
//  public double measure(Object anObject) {
//    if (anObject instanceof Rectangle) {
//      Rectangle rectangle = (Rectangle) anObject;
//      return rectangle.width * rectangle.height;
//    }
//    throw new IllegalArgumentException("不是矩形类");
//  }
}
