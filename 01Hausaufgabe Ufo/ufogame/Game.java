package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener {
	

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();

	private Ship ship;
	
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	private int score = 0;
    private Message scoreDisplay = new Message("Score: " + score, 750, 650, 30, new Color(255,255,255));
	

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.addMessage(scoreDisplay);
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("ProgrammierenS20\\01Vorlesung\\assets\\space.jpg"));
		
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"ProgrammierenS20\\01Vorlesung\\assets\\ufo20.png");
		frameWork.addGameObject(ship); 

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 4,
				"ProgrammierenS20\\01Vorlesung\\assets\\ufo.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
		// create a projectile
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
				"ProgrammierenS20\\01Vorlesung\\assets\\Geschoss.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

		
		// Hausaufgabe 1, entfernen der Geschosse aus dem Array
		if(projectiles.get(0).getY()  > screenHeight) {
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}
		
	

	}
	//Hausaufgabe 2 - Die Methode
	public boolean checkCollided() {

	
	int XPunkt=ship.getX() + ship.getWidth()/4;
	int BreiteUfo=screenWidth/10;
	int HöheUfo=screenWidth/19;
		
		for(Ufo u: ufos) {
			if(((XPunkt-BreiteUfo+10)<u.getX())& (u.getX()<XPunkt)) {
				for(Projectile p: projectiles) {
					if((p.getY()<u.getY()+HöheUfo-10) &(p.getY()>u.getY())) {
						
						//Hausaufgabe 3, Objekte verschwinden und Spielstand erhöht sich
					p.setCollided(true);
					u.setCollided(true);
					frameWork.removeGameObject(p);
					frameWork.removeGameObject(u);
					projectiles.remove(p);
					ufos.remove(u);
					return true;
					
				
				}
			}
		
		}
	}
		return false;
	}
	
	@Override
	public void tick(long elapsedTime) {
		
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
            p.move();
         
            
        }
	//	checkCollided();
		if (checkCollided()==true) {
			System.out.println("AHHHHHHHHHHHHH");
            score += 1;
            scoreDisplay.setMessage("Score: " + score);
            frameWork.addMessage(scoreDisplay);
        }

		
		}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
