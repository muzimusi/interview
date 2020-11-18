package concept;

public class ClassLoadOrder {
    public static void main(String[] args) {
        MyThis myThis = new MyThis();
    }
}

class MySuper {
    static {
        System.out.println("父类静态代码块");
    }

    public MySuper() {
        System.out.println("父类构造函数");
    }

    {
        System.out.println("父类普通代码块");
    }
}

class MyThis extends MySuper {
    static {
        System.out.println("子类静态代码块");
    }

    public MyThis() {
        super();
        System.out.println("子类构造函数");
    }

    {
        System.out.println("子类普通代码块");
    }
}


