#include <stdio.h>

int data = 0;
int readCount = 0;
int writeLock = 0;

void reader(int id){
    if (writeLock == 0){
        readCount++;
        printf("Reader %d is reading. Data = %d\n", id, data);
        readCount--;
    } 
    else{
        printf("Reader %d is waiting. Writer is writing.\n", id);
    }
}

void writer(int id) {
    if (readCount == 0 && writeLock == 0){
        writeLock = 1;
        data += 10;
        printf("Writer %d is writing. New Data = %d\n", id, data);
        writeLock = 0;
    } 
    else{
        printf("Writer %d is waiting. Readers or another writer active.\n", id);
    }
}

int main() {
    reader(1);
    writer(1);
    reader(2);
    writer(2);
    reader(3);
    reader(4);
    writer(3);
    return 0;
}
