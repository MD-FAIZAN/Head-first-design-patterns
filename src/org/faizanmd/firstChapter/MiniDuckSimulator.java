package org.faizanmd.firstChapter;

import org.faizanmd.firstChapter.Ducks.Duck;
import org.faizanmd.firstChapter.Ducks.MallardDuck;
import org.faizanmd.firstChapter.flyBehaviors.FlyWithWings;
import org.faizanmd.firstChapter.quackBehaviors.Quack;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck mallardDuck = new MallardDuck();
		mallardDuck.setFlyBehavior(new FlyWithWings());
		mallardDuck.setQuackBehavior(new Quack());
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
	}

}
