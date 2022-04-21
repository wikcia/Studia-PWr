#include <iostream>
#include <string>
#include <exception>
using namespace std;

class PrimeNumbers {
    int* tab;
    int* tab2;
    int p;
    int counter = 0;
public:
    explicit PrimeNumbers(int n) {
        if (n < 2) throw std::string ("Invalid number");

        tab = new int[n];

        for (int i = 2; i <= n; i++) {
            p = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    p = 1;
                    break;
                }
            }
            if (p == 0) {
                tab[counter] = i;
                counter++;
            }
        }
        tab2 = new int[counter];
        for(int i = 0; i< counter; i++) tab2[i]=tab[i];
    }

    int number(int m) {
        if(m < 0 || m >= sizeof(tab2))
            throw std::string ("Number out of range");
        return tab2[m];
    }
    ~PrimeNumbers(){
        delete[] tab;
        delete[] tab2;
    }
};

int main(int argc, char* argv[]) {
    int n, k;
    try {
        n = stoi(argv[1]);
        auto* primeNumbers = new PrimeNumbers(n); // we are using auto when initializing with new to avoid duplicating the type name

        for(int i = 2; i < argc; i++) {
            try {
                k = stoi(argv[i]);
                cout <<  argv[i] << " = " << primeNumbers->number(k) << endl;
            }
            catch (const invalid_argument &ia){
                cout << argv[i] <<  " - invalid data" << endl;
            }
            catch (string &e) {
                cout<< e <<endl;
            }
        }
        delete primeNumbers;
    }
    catch (const invalid_argument &ia){
        cout << argv[1] <<  " - invalid data" << endl;
    }
    catch (string &e) {
        cout<< e <<endl;}
}