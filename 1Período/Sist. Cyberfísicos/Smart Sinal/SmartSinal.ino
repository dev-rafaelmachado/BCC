

int ledVerm = 9;
int ledAmar = 8;
int ledVerd = 7;
int ledVerm2 = 11;
int ledVerd2 = 10;
int UtSom = 6;
int piezo = 3;
float vDistancia;
float vUltimoMovimento;

void fMedirDistancia()
{
  pinMode(UtSom, OUTPUT);

  digitalWrite(UtSom, HIGH);
  delayMicroseconds(5);
  digitalWrite(UtSom, LOW);
  pinMode(UtSom, INPUT);
  vDistancia = pulseIn(UtSom, HIGH);

  //Converte o tempo em distância (cm)
  vDistancia = vDistancia / 2;
  vDistancia = round(vDistancia * 0.034029);
}
void fecharSinal(){
  	digitalWrite(ledVerd, LOW);
  	//
	digitalWrite(ledAmar, HIGH);
  	delay(2000);
  	digitalWrite(ledAmar, LOW);
  	digitalWrite(ledVerm2, LOW);
  	//
  	digitalWrite(ledVerm, HIGH);
  	digitalWrite(ledVerd2, HIGH);
  	// Toque piezo
  	tone(piezo, 1000);
  	delay(400);
  	tone(piezo, 2500);
  	delay(200);
  	noTone(piezo);
  	delay(5000);
  	digitalWrite(ledVerd2, LOW);
  	for(int i = 0; i < 5; i++){
  		digitalWrite(ledVerm2, HIGH);
  		tone(piezo, 2000);
      	delay(500);
      	digitalWrite(ledVerm2, LOW);
      	noTone(piezo);
      	delay(500); 
  	}
  	digitalWrite(ledVerm2, HIGH);
  	tone(piezo, 2000);
  	delay(1500);
  	digitalWrite(ledVerm, LOW);
	noTone(piezo);
}

void setup()
{
  pinMode(ledVerm, OUTPUT);
  pinMode(ledAmar, OUTPUT);
  pinMode(ledVerd, OUTPUT);
  pinMode(ledVerm2, OUTPUT);
  pinMode(ledVerd2, OUTPUT);
  pinMode(piezo, OUTPUT);
  Serial.begin(9600);
}

void loop()
{
  	fMedirDistancia();
    Serial.println(vDistancia);
	digitalWrite(ledVerd, HIGH);
  	digitalWrite(ledVerm2, HIGH);
 	if (vDistancia < 100){
    	delay(4999);
      	fMedirDistancia();
      if (vDistancia < 100){
      	 fecharSinal();
      }
    }
}

