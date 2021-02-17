int LED1 = 50;
int LED2 = 46;
int LED3 = 42;
int LED4 = 38;
int LED5 = 34;

void setup(){
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(LED4, OUTPUT);
  pinMode(LED5, OUTPUT);
}

void loop(){
  digitalWrite(LED1, HIGH);
  delay(100);
  digitalWrite(LED2, HIGH);
  delay(100);
  digitalWrite(LED3, HIGH);
  delay(100);
  digitalWrite(LED4, HIGH);
  delay(100);
  digitalWrite(LED5, HIGH);
  delay(100);
  digitalWrite(LED1, LOW);
  delay(100);
  digitalWrite(LED2, LOW);
  delay(100);
  digitalWrite(LED3, LOW);
  delay(100);
  digitalWrite(LED4, LOW);
  delay(100);
  digitalWrite(LED5, LOW);
  delay(100);
}
