PImage bg_imgfim, imgcont, bg_img, bg_img2, bg_img3, bg_img41, bg_img421, bg_img422, bg_img5, bg_img60, bg_img611, bg_img612, bg_img7,bg_img8,bg_img711, bg_img712, baixo, esq, dir;
PFont mono, mono2;

int tela = 0;

void setup() {
  bg_imgfim = loadImage("bgfim.jpg");
  imgcont = loadImage("cont.png");
  bg_img = loadImage("bg1.jpg");
  bg_img2 = loadImage("bg2.jpg");
  bg_img3 = loadImage("bg3.jpg");
  bg_img5 = loadImage("bg5.jpg");
  bg_img41 = loadImage("bg41.jpg");
  bg_img421 = loadImage("bg421.png");
  bg_img422 = loadImage("bg422.jpg");
  bg_img60 = loadImage("bg60.jpeg");
  bg_img611 = loadImage("bg611.jpg");
  bg_img612 = loadImage("bg612.jpg");
  bg_img7 = loadImage("bg7.jpg");
  bg_img711 = loadImage("bg711.jpg");
  bg_img712 = loadImage("bg712.jpg");
  bg_img8 = loadImage("bg8.jpg");
  baixo = loadImage("baixo.png");
  esq = loadImage("esq.png");
  dir = loadImage("dir.png");
  size(1280, 720);
}

void tela0() {
  background(0, 0, 0);
  textSize(48);
  fill(255);
  text("O controle sera feito pelas setas", 310, 130);
  textSize(28);
  text("Precione seta para baixo para continuar", 390, 170);
  image(esq, 170, 580, 100, 100);
  image(baixo, 580, 575, 100, 100);
  image(dir, 1000, 580, 100, 100);
}

void tela1() {
  clear();
  // Fundo1
  image(bg_img, 0, 0, 1280, 720);
  // Título
  textSize(128);
  mono = createFont("fast99.ttf", 108);
  textFont(mono);
  fill(255);
  text("Bikini Bottom Party", 120, 160);
  // Botão 1
  fill(25, 133, 224);
  stroke(25, 133, 224);
  rect(490, 560, 250, 100, 42);
  //Texto botão 1
  textSize(78);
  fill(255);
  mono2 = createFont("arial_narrow_7.ttf", 78);
  textFont(mono2);
  text("Jogar", 520, 630);
  // Se clicar
}

void tela2() {
  image(bg_img2, 0, 0, 1280, 720);
  fill(255);
  textSize(38);
  text("hoje vai ter festa na fenda do biquini!!! Como vai ser? só depende de você.", 70, 90);
  textSize(28);
  text("A partir de agora você será o responsável por ditar o rumo desta história, escolha com cautela.", 100, 120);
  text("precione para continuar", 480, 600);
  image(baixo, 580, 620, 40, 40);
}

void tela3() {
  image(bg_img3, 0, 0, 1280, 720);
  fill(255);
  textSize(68);
  text("Quem ira organizar a festa?", 280, 90);
  fill(120, 120, 120);
  stroke(120, 120, 120);
  rect(100, 650, 450, 100, 42);
  stroke(120, 120, 120);
  rect(740, 650, 450, 100, 42);
  fill(255);
  textSize(48);
  text("Bob Esponja", 190, 700);
  image(esq, 440, 665, 40, 40);
  text("Plankton", 860, 700);
  image(dir, 1040, 665, 40, 40);
}

void tela4_1() {
  image(bg_img41, 0, 0, 1280, 720);
  text("Bob Esponja convida todos para sua festa!!!", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela5() {
  image(bg_img5, 0, 0, 1280, 720);
  text("Aonde a festa deve ser?", 70, 90);
}

void tela4_2_1() {
  image(bg_img421, 0, 0, 1280, 720);
  text("Plankton convida todos para sua festa!!!", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}
void tela4_2_2() {
  image(bg_img422, 0, 0, 1280, 720);
  text("Infelizmente ninguém aparece...", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void telafim() {
  image(bg_imgfim, 0, 0, 1280, 720);
}

void tela61() {
  image(bg_img60, 0, 0, 1280, 720);
  text("O pessoal aparece!!!", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela611() {
  image(bg_img611, 0, 0, 1280, 720);
  textSize(38);
  text("Mas o Pratrick estava dormindo e não abriu a porta", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela62() {
  image(bg_img60, 0, 0, 1280, 720);
  text("O pessoal aparece!!!", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela612() {
  image(bg_img612, 0, 0, 1280, 720);
  textSize(38);
  text("Mas Lula Molusco não deixa rolar nenhuma festa", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela63() {
  image(bg_img60, 0, 0, 1280, 720);
  text("O pessoal aparece!!!", 70, 90);
  image(imgcont, 950, 20, 300, 100);
}

void tela7() {
  image(bg_img7, 0, 0, 1280, 720);
  image(imgcont, 950, 20, 300, 100);
}

void tela7_1() {
  image(bg_img8, 0, 0, 1280, 720);
}
void tela7_1_1(){
   image(bg_img711, 0, 0, 1280, 720);
   image(imgcont, 950, 20, 300, 100);
}

void tela7_1_2(){
  image(bg_img712, 0, 0, 1280, 720);
  image(imgcont, 950, 20, 300, 100);
}

void draw() {
  if (tela == 0) tela0();
  else if (tela == 999) telafim();
  else if (tela == 1) tela1();
  else if (tela == 2) tela2();
  else if (tela == 3) tela3();
  else if (tela == 41) tela4_1();
  else if (tela == 421) tela4_2_1();
  else if (tela == 422) tela4_2_2();
  else if (tela == 5) tela5();
  else if (tela == 61) tela61();
  else if (tela == 62) tela62();
  else if (tela == 63) tela63();
  else if (tela == 611) tela611();
  else if (tela == 612) tela612();
  else if (tela == 7) tela7();
  else if (tela == 71) tela7_1();
  else if (tela == 712) tela7_1_2();
  else if (tela == 711) tela7_1_1();

  println(tela);
}

void keyPressed() {
  if (key == CODED) {
    if (tela == 0) {
      if (keyCode == DOWN) tela = 1;
    } else if (tela == 1) {
      if (keyCode == DOWN) tela = 2;
    } else if (tela == 2) {
      if (keyCode == DOWN) tela = 3;
    } else if (tela == 3) {
      if (keyCode == LEFT) tela = 41;
      else if (keyCode == RIGHT) tela = 421;
    } else if (tela == 421) {
      if (keyCode == RIGHT) tela = 422;
    } else if (tela == 422 || tela == 611 || tela == 612 || tela == 712 || tela == 711) {
      if (keyCode == RIGHT) tela = 999;
    } else if (tela == 999) {
      if (keyCode == DOWN) tela = 1;
    } else if (tela == 41) {
      if (keyCode == RIGHT) tela = 5;
    } else if (tela == 5) {
      if (keyCode == LEFT) tela = 61;
      else if (keyCode == DOWN) tela = 62;
      else if (keyCode == RIGHT) tela = 63;
    } else if (tela == 61) {
      if (keyCode == RIGHT) tela = 611;
    } else if (tela == 62) {
      if (keyCode == RIGHT) tela = 612;
    } else if (tela == 63) {
      if (keyCode == RIGHT) tela = 7;
    } else if (tela == 7) {
      if (keyCode == RIGHT) tela = 71;
    } else if (tela == 71) {
      if (keyCode == RIGHT) tela = 711;
      else if (keyCode == LEFT) tela = 712;
    }
  }
}
