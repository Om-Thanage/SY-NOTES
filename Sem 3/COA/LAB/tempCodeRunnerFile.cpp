#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int m;

    do
    {
        cout << "Enter the number of your choice:" << endl;
        cout << "1: Direct Mapping" << endl;
        cout << "2: Two way Set Associative Mapping" << endl;
        cout << "3: Fully Associative Mapping" << endl;
        cout << "4: Exit" << endl;
        cin >> m;

        if (m == 1)
        {
            int cacheBlocks, wordSize, totalMainMemBlocks, d, e = 0, totalAddSize = 0, g = 0, h = 0, i = 0, j = 0, k;
            cout << "Enter the number of cache blocks: ";
            cin >> cacheBlocks;
            cout << "Enter the word size of each block: ";
            cin >> wordSize;
            cout << "Enter the total number of main memory blocks: ";
            cin >> totalMainMemBlocks;
            d = totalMainMemBlocks * wordSize;

            while (e != d)
            {
                totalAddSize = totalAddSize + 1;
                e = pow(2, totalAddSize);
            }
            cout << "The total addressing size is " << totalAddSize << " bits" << endl;

            while (g != cacheBlocks)
            {
                h = h + 1;
                g = pow(2, h);
            }

            while (i != cacheBlocks)
            {
                j = j + 1;
                i = pow(2, j);
            }
            k = totalAddSize - h - j;
            cout << "Tag  Block  Line  Word" << endl;
            cout << " " << k << "     " << h << "      " << j << endl;
        }
        else if (m == 2)
        {
            int cacheBlocks, wordSize, totalMainMemBlocks, d, e = 0, totalAddSize = 0, g = 0, i = 0, j = 0, k;
            cout << "Enter the number of cache blocks: ";
            cin >> cacheBlocks;
            cout << "Enter the word size of each block: ";
            cin >> wordSize;
            cout << "Enter the total number of main memory blocks: ";
            cin >> totalMainMemBlocks;
            d = totalMainMemBlocks * wordSize;

            while (e != d)
            {
                totalAddSize = totalAddSize + 1;
                e = pow(2, totalAddSize);
            }
            cout << "The total addressing size is " << totalAddSize << " bits" << endl;

            while (i != wordSize)
            {
                j = j + 1;
                i = pow(2, j);
            }
            k = totalAddSize - j;
            cout << "Tag  Word" << endl;
            cout << " " << k << "     " << j << endl;
        }
        else if (m == 3)
        {
            int cacheBlocks, wordSize, totalMainMemBlocks, d, e = 0, totalAddSize = 0, g = 0, h = 0, i = 0, j = 0, k, l, n;
            cout << "Enter the number of cache blocks: ";
            cin >> cacheBlocks;
            cout << "Enter the word size of each block: ";
            cin >> wordSize;
            cout << "Enter the total number of main memory blocks: ";
            cin >> totalMainMemBlocks;
            cout << "Enter the set number: ";
            cin >> l;
            d = totalMainMemBlocks * wordSize;

            while (e != d)
            {
                totalAddSize = totalAddSize + 1;
                e = pow(2, totalAddSize);
            }
            cout << "The total addressing size is " << totalAddSize << " bits" << endl;
            n = cacheBlocks / l;

            while (g != n)
            {
                h = h + 1;
                g = pow(2, h);
            }

            while (i != wordSize)
            {
                j = j + 1;
                i = pow(2, j);
            }
            k = totalAddSize - h - j;
            cout << "Tag  Set  Word" << endl;
            cout << " " << k << "     " << h << "    " << j << endl;
        }
        else
        {
            cout << "Invalid input" << endl;
        }
    } while (m != 4);
    return 0;
}
