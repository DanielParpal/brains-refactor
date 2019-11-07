final int QTY_SURVIVORS = 2;
Survivor[] survivors;

void setup() {
  setupSurvivors();
}

void draw() {
  frameRate(1);
  updateSurvivors();
  println("=====");
}

void setupSurvivors() {
  survivors = new Survivor[QTY_SURVIVORS];

  for (int i = 0; i < QTY_SURVIVORS; i++) {
    Survivor s = new Survivor();
    survivors[i] = s; 
  }
}

void updateSurvivors() {
  for (int i = 0; i < QTY_SURVIVORS; i++) {
    survivors[i].draw(); 
    survivors[i].move(); 
    survivors[i].somethingMore(); 
  }
}
