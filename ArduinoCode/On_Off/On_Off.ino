int input;

void setup(){
  pinMode(50, OUTPUT);
  Serial.begin(9600);
}

void loop(){
  if(Serial.available() > 0){
    input = Serial.read();
    if(input == '1'){
      digitalWrite(50, HIGH);
    }
    else{
      digitalWrite(50, LOW);
    }
  }
}
