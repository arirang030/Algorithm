#include <iostream>

using namespace std;

int main() {
	int kg;
	cin >> kg;
	int res = 0;
	int kg_3 = -1;
	while (kg > 0) {
		if (kg % 3 == 0) // 3의 배수인 지점 기억하기
			kg_3 = kg;
		kg -= 5;
		++res;
	}
	if (kg < 0) {
		while (kg_3 > 0 && kg != kg_3) {
			kg += 5;
			--res;
		}
		while (kg > 0) {
			kg -= 3;
			++res;
		}
	}
	res = (kg != 0) ? -1 : res;
	cout << res << endl;
}