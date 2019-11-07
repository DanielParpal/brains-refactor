import java.lang.Class;
import java.lang.reflect.*;
import java.util.HashMap;

abstract class Strategy {
  public Strategy() {}
  
  abstract void draw();
  abstract void move();
  abstract void somethingMore();
}

class HealthyStrategy extends Strategy {
  public HealthyStrategy() {}

  void draw() {
    System.out.println("draw like a healthy survivor");
  }

  void move() {
    System.out.println("move like a healthy survivor");
  }

  void somethingMore() {}
}


class InfectedStrategy extends Strategy {
  public InfectedStrategy() {}

  void draw() {
    System.out.println("draw like an infected survivor");
  }

  void move() {
    System.out.println("move like an infected survivor");
  }

  void somethingMore() {}
}

class InjuredStrategy extends Strategy {
  public InjuredStrategy() {}

  void draw() {
    System.out.println("draw like an injured survivor");
  }

  void move() {
    System.out.println("move like an injured survivor");
  }

  void somethingMore() {}
}

class DeadStrategy extends Strategy {
  public DeadStrategy() {}

  void draw() {
    System.out.println("draw like a dead survivor");
  }

  void move() {
    System.out.println("move like a dead survivor"); 
  }

  void somethingMore() {}
}


class Survivor {
  String type;
  Strategy strategy;

  final static String HEALTHY_TYPE = "healthy";
  final static String INFECTED_TYPE = "infected";
  final static String INJURED_TYPE = "injured";
  final static String DEAD_TYPE = "dead";

  HashMap<String, Class> strategiesClassHash = new HashMap<String, Class>() {{
    put(HEALTHY_TYPE, HealthyStrategy.class);
    put(INFECTED_TYPE, InfectedStrategy.class);
    put(INJURED_TYPE, InjuredStrategy.class);
    put(DEAD_TYPE, DeadStrategy.class);
  }};

  Survivor() {
    setInitialType();
    assignStrategy();
  }

  void assignStrategy() {
    try {
      Class strategyClass = this.strategiesClassHash.get(this.type);
      Constructor constructor = strategyClass.getDeclaredConstructor();
      this.strategy = (Strategy) constructor.newInstance();
    } catch (Exception e) {
      System.out.println("Issue class: " + e);
    }
  }

  void draw() {
    this.strategy.draw();
  }

  void move() {
    this.strategy.move();
  }

  void somethingMore() {
    this.strategy.somethingMore();
  }

  private void setInitialType() {
    double rand = Math.random();

    if (rand < 0.25) {
      this.type = HEALTHY_TYPE;
    } else if (rand < 0.5) {
      this.type = INFECTED_TYPE;
    } else if (rand < 0.75) {
      this.type = INJURED_TYPE;
    } else {
      this.type = DEAD_TYPE;
    }
  }
}
