package com.twomonth.pattern;

/**
 * 1.抽象组建：需要装饰的抽象对象（接口或者抽象类）
 * 2.具体组件：需要被装饰的组件（实现类）
 * 3。抽象装饰类：包含了对抽象组件的引用以及装饰着共同方法
 * 4.具体装饰类：被装饰的对象
 */

public class DecorateTest {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milkeCoffee = new Milk(coffee);
        System.out.println(milkeCoffee.info()+"--->"+milkeCoffee.cost());
        Drink suggerCoffee = new Sugger(coffee);
        System.out.println(suggerCoffee.info()+"--->"+suggerCoffee.cost());

        Drink sugger = new Sugger(milkeCoffee);
        System.out.println(sugger.info()+"--->"+sugger.cost());
    }
}

//抽象组建
interface Drink{
    double cost();//费用
    String info();
}

//具体组件
class Coffee implements Drink{

    private String name = "原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

//抽象装饰类
abstract class Decorate implements Drink{

    //对抽象组建的引用
    private Drink drink;
    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

//具体的装饰类
class Milk extends Decorate{
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"+牛奶";
    }
}

//具体的装饰类
class Sugger extends Decorate{
    public Sugger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()+2;
    }

    @Override
    public String info() {
        return super.info()+"+糖";
    }
}