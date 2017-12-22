package designpatterns23.singleton;

/**
 * 单例模式
 * 保证所属程序只有一个实例
 * 以下方法属于与饿汉式,因为类在初始化的时候就加载了
 * 思路:1.将类在初始化时直接进行加载,使用关键字static
 * 2.不能再外部new这个对象,所以将构造方法修改为private
 * 3.提供一个获取这个类的静态方法
 * Created by lizhen on 2017/12/20.
 */
public class Cat {
    private String red;
    private String green;
    public  static  final  Cat cat = new Cat();
    private Cat(){

    }
    public  static Cat getCat(){
        return cat;
    }
    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "red='" + red + '\'' +
                ", green='" + green + '\'' +
                '}';
    }
}
