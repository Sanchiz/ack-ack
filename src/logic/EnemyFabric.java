package logic;

import java.util.ArrayList;
import java.util.Random;

import entity.Enemy;

public class EnemyFabric implements Runnable {
	ArrayList<Enemy> enemies;
	Thread t;
	public EnemyFabric(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while(true) {
			Random rand = new Random();
			try {
				Thread.sleep(500 + rand.nextInt(1500));
					enemies.add(new Enemy(-100, rand.nextInt(200), 1 + rand.nextInt(4)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
