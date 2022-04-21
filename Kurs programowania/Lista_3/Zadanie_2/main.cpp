#include <iostream>
#include <string>
#include <exception>
#include <list>

using namespace std;

class PascalTriangleRow {

    int* triangle;
public:
    explicit PascalTriangleRow(int n) {
        triangle = new int[n + 1];
        triangle[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0; j--)
                triangle[j] = triangle[j] + triangle[j - 1];
        }
    }

    int number(int m) {
        if(m < 0 || m >= sizeof(triangle))
            throw std::invalid_argument("Number out of range");
        return triangle[m];
    }
    ~PascalTriangleRow(){
        delete[] triangle;
    }
};

int main(int argc, char* argv[]) {
    int n, k;
    try {
        n = stoi(argv[1]);
        auto* primeNumbers = new PascalTriangleRow(n); // we are using auto when initializing with new to avoid duplicating the type name

        for(int i = 2; i < argc; i++) {
            try {
                k = stoi(argv[i]);
                cout <<  argv[i] << " - " << primeNumbers->number(k) << endl;
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
