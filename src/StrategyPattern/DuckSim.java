package StrategyPattern;


interface FlyingBehaviour {
    public void fly();
}

interface QuackingBehaviour {
    public void quack();
}

class FlyNoWay implements FlyingBehaviour {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}

class FlyRocketPowered implements FlyingBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}

class FlyWithWings implements FlyingBehaviour {
    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}

class MuteQuack implements QuackingBehaviour {
    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }
}

class Squeak implements QuackingBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

class Quack implements QuackingBehaviour{
    @Override
    public void quack() {
        System.out.println("quack");
    }
}


abstract class Duck {
    FlyingBehaviour flyingBehaviour;
    QuackingBehaviour quackingBehaviour;

    public Duck() {
    }

    public void performFly() {
        flyingBehaviour.fly();
    }

    public void performQuack() {
        quackingBehaviour.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys");
    }

    public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
    }

    public void setQuackingBehaviour(QuackingBehaviour quackingBehaviour) {
        this.quackingBehaviour = quackingBehaviour;
    }
}


class MallardDuck extends Duck {
    MallardDuck() {
        quackingBehaviour = new Quack();
        flyingBehaviour = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real mallard duck");
    }
}

class ModelDuck extends Duck {
    public ModelDuck() {
        flyingBehaviour = new FlyNoWay();
        quackingBehaviour = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}

public class DuckSim {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.setFlyingBehaviour(new FlyWithWings());
        mallardDuck.setQuackingBehaviour(new Quack());

        Duck prototype = new ModelDuck();
        prototype.performFly();
        prototype.setFlyingBehaviour(new FlyWithWings()); //
        prototype.performFly();
        prototype.setFlyingBehaviour(new FlyRocketPowered()); //
        prototype.performFly();
    }
}
