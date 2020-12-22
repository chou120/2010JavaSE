#include<stdio.h>
#include<stdlib.h>

typedef struct Elephant {
  int heightInCM;
} Elephant;

typedef struct Fridge {
  int heightInCM;
  Elephant* storage;
} Fridge;

Elephant* createElephant(int heightInCM){
  printf("创建一个%d厘米高的大象！\n", heightInCM);
  Elephant* elephant = (Elephant*)calloc(sizeof(Elephant),1);
  elephant->heightInCM = heightInCM;
  return elephant;
}

Fridge* createFridge(int heightInCM){
  printf("创建一个%d厘米高的冰箱！\n", heightInCM);
  Fridge* fridge = (Fridge*)calloc(sizeof(Fridge),1);
  fridge->heightInCM = heightInCM;
  return fridge;
}

void printFridgeInfo(Fridge* fridge){
  printf("%d厘米高的冰箱中，保存了一个%d厘米高的大象\n",fridge->heightInCM, fridge->storage->heightInCM);
}


int main(){
  Elephant* e1 = createElephant(300);
  Fridge* f1 = createFridge(400);

  printf("把%d厘米高的大象，装进%d厘米高的冰箱！\n", e1->heightInCM,f1->heightInCM);
  f1->storage = e1;
  printFridgeInfo(f1);
  Elephant* e2 = createElephant(400);
  f1->storage = e2;
  printFridgeInfo(f1);

  f1->storage->heightInCM = 30;
  printFridgeInfo(f1);
  printf("大象的高度=%d",e2->heightInCM);

//  Elephant e2 = {350};
//  Fridge f2 = {500, NULL};
//  f2.storage = &e2;

}