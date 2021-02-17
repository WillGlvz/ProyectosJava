const int puesto_verde1 = 13;
const int puesto_rojo1 = 12;
const int puesto_verde2 = 11;
const int puesto_rojo2 = 10;
const int puesto_verde3 = 9;
const int puesto_rojo3 = 8;
const int puesto_verde4 = 7;
const int puesto_rojo4 = 6;
const int puesto_rojo5 = 50;
const int puesto_verde5 = 48;
const int puesto_rojo6 = 46;
const int puesto_verde6 = 44;
const int puesto_rojo7 = 42;
const int puesto_verde7 = 40;
const int puesto_rojo8 = 38;
const int puesto_verde8 = 36;
int byte_entrada = 0;

void setup(){
  Serial.begin(9600);
  pinMode(puesto_verde1, OUTPUT);
  pinMode(puesto_rojo1, OUTPUT);
  pinMode(puesto_rojo2, OUTPUT);
  pinMode(puesto_verde2, OUTPUT);
  pinMode(puesto_rojo3, OUTPUT);
  pinMode(puesto_verde3, OUTPUT);
  pinMode(puesto_rojo4, OUTPUT);
  pinMode(puesto_verde4, OUTPUT);
  pinMode(puesto_rojo5, OUTPUT);
  pinMode(puesto_verde5, OUTPUT);
  pinMode(puesto_rojo6, OUTPUT);
  pinMode(puesto_verde6, OUTPUT);
  pinMode(puesto_rojo7, OUTPUT);
  pinMode(puesto_verde7, OUTPUT);
  pinMode(puesto_rojo8, OUTPUT);
  pinMode(puesto_verde8, OUTPUT);
  digitalWrite(puesto_verde1, LOW);
  digitalWrite(puesto_rojo1, LOW);
  digitalWrite(puesto_verde2, LOW);
  digitalWrite(puesto_rojo2, LOW);
  digitalWrite(puesto_verde3, LOW);
  digitalWrite(puesto_rojo3, LOW);
  digitalWrite(puesto_verde4, LOW);
  digitalWrite(puesto_rojo4, LOW);
  digitalWrite(puesto_verde5, LOW);
  digitalWrite(puesto_rojo5, LOW);
  digitalWrite(puesto_verde6, LOW);
  digitalWrite(puesto_rojo6, LOW);
  digitalWrite(puesto_verde7, LOW);
  digitalWrite(puesto_rojo7, LOW);
  digitalWrite(puesto_verde8, LOW);
  digitalWrite(puesto_rojo8, LOW);
}

void loop(){
  if(Serial.available() > 0){
    byte_entrada = Serial.read();
    if(byte_entrada == '0'){
      digitalWrite(puesto_verde1, LOW);
    }
    else if(byte_entrada == '1'){
      digitalWrite(puesto_verde1, HIGH);
    }
    else if(byte_entrada == '2'){
      digitalWrite(puesto_rojo1, LOW);
    }
    else if(byte_entrada == '3'){
      digitalWrite(puesto_rojo1, HIGH);
    }
    else if(byte_entrada == '4'){
      digitalWrite(puesto_rojo2, LOW);
    }
    else if(byte_entrada == '5'){
      digitalWrite(puesto_rojo2, HIGH);
    }
    else if(byte_entrada == '6'){
      digitalWrite(puesto_verde2, LOW);
    }
    else if(byte_entrada == '7'){
      digitalWrite(puesto_verde2, HIGH);
    }
    else if(byte_entrada == '8'){
      digitalWrite(puesto_rojo3, LOW);
    }
    else if(byte_entrada == '9'){
      digitalWrite(puesto_rojo3, HIGH);
    }
    else if(byte_entrada == '10'){
      digitalWrite(puesto_verde3, LOW);
    }
    else if(byte_entrada == '11'){
      digitalWrite(puesto_verde3, HIGH);
    }
    else if(byte_entrada == '12'){
      digitalWrite(puesto_rojo4, LOW);
    }
    else if(byte_entrada == '13'){
      digitalWrite(puesto_rojo4, HIGH);
    }
    else if(byte_entrada == '14'){
      digitalWrite(puesto_verde4, LOW);
    }
    else if(byte_entrada == '15'){
      digitalWrite(puesto_verde4, HIGH);
    }
    else if(byte_entrada == '16'){
      digitalWrite(puesto_rojo5, LOW);
    }
    else if(byte_entrada == '17'){
      digitalWrite(puesto_rojo5, HIGH);
    }
    else if(byte_entrada == '18'){
      digitalWrite(puesto_verde5, LOW);
    }
    else if(byte_entrada == '19'){
      digitalWrite(puesto_verde5, HIGH);
    }
    else if(byte_entrada == '20'){
      digitalWrite(puesto_rojo6, LOW);
    }
    else if(byte_entrada == '21'){
      digitalWrite(puesto_rojo6, HIGH);
    }
    else if(byte_entrada == '22'){
      digitalWrite(puesto_verde6, LOW);
    }
    else if(byte_entrada == '23'){
      digitalWrite(puesto_verde6, HIGH);
    }
    else if(byte_entrada == '24'){
      digitalWrite(puesto_rojo7, LOW);
    }
    else if(byte_entrada == '25'){
      digitalWrite(puesto_rojo7, HIGH);
    }
    else if(byte_entrada == '26'){
      digitalWrite(puesto_verde7, LOW);
    }
    else if(byte_entrada == '27'){
      digitalWrite(puesto_verde7, HIGH);
    }
    else if(byte_entrada == '28'){
      digitalWrite(puesto_rojo8, LOW);
    }
    else if(byte_entrada == '29'){
      digitalWrite(puesto_rojo8, HIGH);
    }
    else if(byte_entrada == '30'){
      digitalWrite(puesto_verde8, LOW);
    }
    else if(byte_entrada == '31'){
      digitalWrite(puesto_verde8, HIGH);
    }
  }
}
