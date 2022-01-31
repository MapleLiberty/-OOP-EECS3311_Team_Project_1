package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.*;
import model.players.*;
import java.awt.*;

public class modeltest {
	
	@Test
	public void strikerNameTest() {
		Striker s = new Striker("Striker", Color.blue);
		assertEquals("Striker", s.getPlayerName());
	}
	
	@Test
	public void strikerColorTest() {
		Striker s = new Striker("Striker", Color.blue);
		assertTrue("OK", s.getPlayerColor().equals(Color.blue)); // assert strikers color is blue
		assertEquals(Color.blue, s.getPlayerColor());

	}
	
	@Test
	public void strikerPointTest() {
		Point p = new Point(100, 300);
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerPosition(new Point(100, 300)); 
		assertEquals(p, s.getPlayerPosition());
	}
	
	@Test
	public void strikerLeftTest() {
		Striker s = new Striker("Striker", Color.blue);
		Point p = new Point(95, 300);
		s.setPlayerPosition(new Point(100, 300));
		s.moveLeft(); // move left
		assertEquals(p, s.getPlayerPosition()); // assert that striker moved to new position
		
		s.setPlayerPosition(new Point(5, 300));
		Point p1 = new Point(5, 300);
		s.moveLeft(); // should not change strikers position because X coordinate is invalid 
		assertEquals(p1, s.getPlayerPosition()); // check if striker position remains the same
	}
	
	@Test
	public void strikerRightTest() {
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerPosition(new Point(100, 300));
		Point p = new Point(105, 300);
		s.moveRight(); // move right
		assertEquals(p, s.getPlayerPosition()); // assert that striker moved to new position
		
		s.setPlayerPosition(new Point(595, 300));
		Point p1 = new Point(595, 300);
		s.moveRight(); // should not change strikers position because X coordinate is invalid 
		assertEquals(p1, s.getPlayerPosition()); // check if striker position remains the same
	}
	
	@Test
	public void strikerUpTest() {
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerPosition(new Point(100, 300));
		Point p = new Point(100, 295);
		s.moveUp(); // move up
		assertEquals(p, s.getPlayerPosition()); // assert that striker moved to new position
		
		s.setPlayerPosition(new Point(100, 201));
		Point p1 = new Point(100, 201);
		s.moveUp(); // should not change strikers position because Y coordinate is invalid
		assertEquals(p1, s.getPlayerPosition()); // check if striker position remains the same
	}
	
	@Test
	public void strikerDownTest() {
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerPosition(new Point(100, 300));
		Point p = new Point(100, 305);
		s.moveDown(); // move down
		assertEquals(p, s.getPlayerPosition()); // assert that striker moved to new position
		
		s.setPlayerPosition(new Point(100, 499)); 
		Point p1 = new Point(100, 499);
		s.moveDown(); // should not change strikers position because Y coordinate is invalid
		assertEquals(p1, s.getPlayerPosition()); // check if striker position remains the same
	}
	
	@Test
	public void strikerStringTest() {
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerStatistics(5); // set striker goal to 5
		assertEquals("Striker scored 5 goals", s.toString());
	}
	
	@Test
	public void strikerGetStatTest() {
		Striker s = new Striker("Striker", Color.blue);
		s.setPlayerStatistics(5);
		assertTrue("OK", s.getPlayerStatistics().equals(5));
	}
	
	@Test
	public void strikerTestCompareTo() {
		Striker s1 = new Striker("Striker1", Color.blue);
		Striker s2 = new Striker("Striker2", Color.blue);
		s1.setPlayerStatistics(5);
		s2.setPlayerStatistics(5);
		assertEquals(0, s1.compareTo(s2));
	}
	
	@Test
	public void strikerShootBall() {
		Striker s = new Striker("Striker", Color.blue);
		Point p = new Point(100, 200);
		s.setPlayerPosition(p);
		SoccerBall.getSoccerBall().setPosition(p);
		s.shootBall();
	}
	
	@Test
	public void strikerGrabBall() {
		Striker s = new Striker("Striker", Color.blue);
		Point p = new Point(100, 200);
		Point p1 = new Point(84, 200);
		s.setPlayerPosition(p);
		SoccerBall.getSoccerBall().setPosition(p1);
		s.grabsBall();
		
		Point p2 = new Point(115, 200);
		SoccerBall.getSoccerBall().setPosition(p2);
		s.grabsBall();
		
	}

	@Test
	public void goalkeeperMoveRandomlyTest() {
		Goalkeeper g = new Goalkeeper("Goalkeeper", Color.yellow);
		for (int i = 0; i < 5; i++)
			g.moveRandomly();
	}
	
	@Test
	public void goalkeeperMoveUpTest() {
		Goalkeeper g = new Goalkeeper("Goalkeeper", Color.yellow);
		Point p = new Point(280, 70);
		Point p1 = new Point(280, 65);
		g.moveUp();
		assertEquals(p1, g.getPlayerPosition());

		Point p2 = new Point(280, 4);
		g.setPlayerPosition(p2);
		g.moveUp();
		assertEquals(p2, g.getPlayerPosition());
	}
	
	@Test
	public void goalkeeperMoveDownTest() {
		Goalkeeper g = new Goalkeeper("Goalkeeper", Color.yellow);
		Point p = new Point(280, 70);
		Point p1 = new Point(280, 75);
		g.moveDown();
		assertEquals(p1, g.getPlayerPosition());
		
		Point p2 = new Point(280, 299);
		g.setPlayerPosition(p2);
		g.moveDown();
		assertEquals(p2, g.getPlayerPosition());

	}
	
	@Test
	public void goalkeeperShootBallTest() {
		Goalkeeper g = new Goalkeeper("Goalkeeper", Color.yellow);
		Point p = new Point(100, 200);
		g.setPlayerPosition(p);
		SoccerBall.getSoccerBall().setPosition(p);
		g.shootBall();
	}
	
	@Test
	public void goalkeeperToStringTest() {
		Goalkeeper g = new Goalkeeper("Goalkeeper", Color.yellow);
		assertEquals("Goalkeeper caught 0 balls", g.toString());
	}
	
	@Test
	public void testGame() {
		Striker s = new Striker("Striker", Color.blue);
		PlayerCollection pc = new PlayerCollection();
		pc.add(s);
		Point p = new Point(280, 40);
		SoccerGame sg = new SoccerGame();
		sg.automateGoalkeeper();
		sg.setGoal(5);
		sg.setTimeRemaining(45);
		sg.setOver(true);
		sg.setPaused(true);
		SoccerBall.getSoccerBall().setPosition(p);
		sg.automateGoalkeeper();
		sg.getGamePlayers();
		
		assertEquals("Striker", sg.getGamePlayers().getGamePlayer(0).getPlayerName());
		assertTrue(sg.getGoal().equals(5));
		assertTrue(sg.getTimeRemaining().equals(45));
		assertTrue(sg.isOver().equals(true));
	
	}
	
	@Test
	public void playerCollectionGetTest() {
		PlayerCollection pc = new PlayerCollection();
		Striker s = new Striker("Striker", Color.blue);
		Goalkeeper g = new Goalkeeper("John", Color.yellow);
		pc.add(s);
		assertFalse(pc.get("Goalkeeper").equals(g));
		assertEquals(s, pc.get("Striker"));
	}
	
	@Test
    public void StatTest() {

        PlayerStatistics stats = new PlayerStatistics();
        int stat = 2;
        stats.setStatistics(stat);
        assertEquals(stat, (int) stats.getStatistics());

    }

    @Test
    public void StringStatTest() {

        PlayerStatistics stats = new PlayerStatistics();
        int stat = 2;
        stats.setStatistics(stat);
        String s = stats.toString();
        assertEquals("2", stats.toString());

    }
    
    @Test
    public void playerCollectionSortTest() {
    	
		PlayerCollection pc = new PlayerCollection();
		Striker s1 = new Striker("s1", Color.blue);
		Striker s2 = new Striker("s2", Color.blue);
		Striker s3 = new Striker("s3", Color.blue);
		Striker s4 = new Striker("s4", Color.blue);
		Striker s5 = new Striker("s5", Color.blue);
		
		s1.setPlayerStatistics(1);
		s2.setPlayerStatistics(2);
		s3.setPlayerStatistics(3);
		s4.setPlayerStatistics(4);
		s5.setPlayerStatistics(5);
		
		pc.add(s4);
		pc.add(s1);
		pc.add(s2);
		pc.add(s3);
		pc.add(s5);
		
		pc.sort();
				
		assertEquals(s5, pc.getGamePlayer(0));
		assertEquals(s4, pc.getGamePlayer(1));
		assertEquals(s3, pc.getGamePlayer(2));
		assertEquals(s2, pc.getGamePlayer(3));
		assertEquals(s1, pc.getGamePlayer(4));
		assertTrue(pc.contains(s5));
		assertTrue(pc.contains(s4));
		assertTrue(pc.contains(s3));
		assertTrue(pc.contains(s2));
		assertTrue(pc.contains(s1));
		assertEquals(5, pc.size());
    }
    
    @Test
    public void playerCollectionRemoveAllTest() {
    	PlayerCollection pc = new PlayerCollection();
		Striker s1 = new Striker("s1", Color.blue);
		Striker s2 = new Striker("s2", Color.blue);
		Striker s3 = new Striker("s3", Color.blue);
		Striker s4 = new Striker("s4", Color.blue);
		Striker s5 = new Striker("s5", Color.blue);
		pc.add(s4);
		pc.add(s1);
		pc.add(s2);
		pc.add(s3);
		pc.add(s5);
		
		pc.removeAll(pc);
		
		assertTrue(pc.isEmpty());
    }
    
    @Test
    public void playerCollectionClearTest() {
    	PlayerCollection pc = new PlayerCollection();
		Striker s1 = new Striker("s1", Color.blue);
		Striker s2 = new Striker("s2", Color.blue);
		Striker s3 = new Striker("s3", Color.blue);
		Striker s4 = new Striker("s4", Color.blue);
		Striker s5 = new Striker("s5", Color.blue);
		pc.add(s4);
		pc.add(s1);
		pc.add(s2);
		pc.add(s3);
		pc.add(s5);
		
		pc.clear();
		
		assertTrue(pc.isEmpty());
    }
    
    @Test
    public void playerCollectionRemoveTest() {
    	PlayerCollection pc = new PlayerCollection();
		Striker s4 = new Striker("s4", Color.blue);
		Striker s5 = new Striker("s5", Color.blue);
		pc.add(s4);
		pc.add(s5);
		
		pc.remove(s5);
		assertFalse(pc.contains(s5));
    }
    
    @Test
    public void playerCollectionRetainAllTest() {
    	PlayerCollection pc = new PlayerCollection();
    	PlayerCollection pc1 = new PlayerCollection();
		Striker s1 = new Striker("s1", Color.blue);
		Striker s2 = new Striker("s2", Color.blue);
		Striker s3 = new Striker("s3", Color.blue);
		Striker s4 = new Striker("s4", Color.blue);
		Striker s5 = new Striker("s5", Color.blue);
		pc.add(s4);
		pc.add(s1);
		pc.add(s2);
		pc.add(s3);
		pc.add(s5);
		pc1.add(s1);
		pc1.add(s3);
		
		pc.retainAll(pc1);
		assertFalse(pc.contains(s2));
		assertFalse(pc.contains(s4));
		assertFalse(pc.contains(s5));
		assertTrue(pc.contains(s1));
		assertTrue(pc.contains(s3));
		assertTrue(pc.containsAll(pc1));
		
		pc.removeAll(pc);
		pc.addAll(pc1);
		
		assertTrue(pc.containsAll(pc1));
    }
    
    @Test
    public void playerColletionNextTest() {
    	PlayerCollection pc = new PlayerCollection();
		Striker s1 = new Striker("s1", Color.blue);

		assertEquals(null ,pc.iterator().next());
		
		pc.add(s1);
		
		assertEquals(s1, pc.iterator().next());
    }
    
    @Test
    public void playerFactoryNullTest() {
    	PlayerFactory pf = new PlayerFactory();
    	
    	assertEquals(null, pf.getPlayer("john"));
    	assertEquals(null, pf.getPlayer(null));
    }
    
    @Test
    public void soccerBallColorTest() {
    	assertEquals(Color.white, SoccerBall.getSoccerBall().getColor());
    }
    
    @Test
    public void soccerGamePauseTest() {
    	SoccerGame sg = new SoccerGame();
    	assertFalse(sg.isPaused());
    }
    
    @Test
    public void soccerGameGetActivePlayerTest() {
    	SoccerGame sg = new SoccerGame();
    	assertEquals("Striker", sg.getActivePlayer().getPlayerName());
    }
    
    @Test
    public void soccerGameIsScoredTest() {
    	SoccerGame sg = new SoccerGame();
    	assertFalse(sg.isScored());
    }
    
    @Test
    public void playerCollectionToArrayTest() {
    	PlayerCollection pc = new PlayerCollection();
    	Striker s1 = new Striker("s1", Color.blue);
		Striker s2 = new Striker("s2", Color.blue);
		Striker s3 = new Striker("s3", Color.blue);
    	GamePlayer[] a = new GamePlayer[5];
    	
    	pc.add(s1);
    	pc.add(s2);
    	pc.add(s3);
    	
    	pc.toArray(a);

    	assertEquals(s1, a[0]);
    	assertEquals(s2, a[1]);
    	assertEquals(s3, a[2]);
    }
}
