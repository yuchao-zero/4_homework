package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class PointUtils{

  /**
   * 返回具有最大Y值的点。如果存在多个这样的点，则只需选择一个即可。
   */
  public static Point highestPoint(List<Point> points) {//保存Point类对象的集合
    /* 这等效于实验室中提到的初始化步骤。 */
    Iterator<Point> pointIterator = points.iterator();

    Point max = points.get(0);
    // TODO 使用迭代器完成此方法!
    while (pointIterator.hasNext()){
      Point temp = pointIterator.next();
      if(temp.getY() > max.getY()){
        max = temp;
      }
    }
    return max;
  }

  /**
   * 返回一个新点，新点的X值是所有给定点的X值的平均值，Y值是所有给定点的Y值的平均值。
   */
  public static Point centroid(List<Point> points) {
    Iterator<Point> pointIterator = points.iterator();
    // TODO 使用迭代器完成此方法!
    int averageX = 0;
    int averageY = 0;
    int size = points.size();
    while(pointIterator.hasNext()){
      Point flag = pointIterator.next();
      averageX += flag.getX();
      averageY += flag.getY();
    }
    return new Point(averageX/size,averageY/size);
  }

  @Test
  public void test() {
    List<Point> points = new LinkedList<>();
    points.add(new Point(1, 1));
    points.add(new Point(1, 3));
    points.add(new Point(3, 1));
    points.add(new Point(3, 3));

    /* 应该是Point [x = 3，y = 3]或Point [x = 1，y = 3] */
    //System.out.println(highestPoint(points));
    // TODO 编写一个单元测试
    //Assert.assertEquals(highestPoint(points).getY(),3);
    // assert 结果是[x = 3，y = 3] 或  [x = 1，y = 3]中的一个
    //Assert.assertEquals(highestPoint(points).getX(),1);
    Assert.assertEquals(3,highestPoint(points).getY());
    Assert.assertEquals(1,highestPoint(points).getX());


    // 应该是Point[x=2,y=2]
    //System.out.println(centroid(points));
    Assert.assertEquals(centroid(points).getX(),2);
    Assert.assertEquals(centroid(points).getY(),2);
    // TODO 编写一个单元测试测试结果

    points = new LinkedList<Point>();
    points.add(new Point(1, 1));
    points.add(new Point(1, -1));
    points.add(new Point(-1, 1));
    points.add(new Point(-1, -1));

    /* 应该是Point[x=1,y=1] 或[x=-1,y=1] */
    //System.out.println(highestPoint(points));
    Assert.assertEquals(1,highestPoint(points).getY());
    Assert.assertEquals(1,highestPoint(points).getX());

    // TODO 编写一个单元测试
    // assert 结果是[x=1,y=1] 或  [x=-1,y=1]中的一个

    Assert.assertEquals(0,centroid(points).getY());
    Assert.assertEquals(0,centroid(points).getX());

    // 应该是[x=0,y=0]
    //System.out.println(centroid(points));
    // TODO 编写一个单元测试测试结果
  }
}
