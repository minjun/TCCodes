#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main() {
	vector<string> vs;
	auto allocator = vs.get_allocator();
	string *sp = allocator.allocate(3);
	allocator.construct(&sp[0],"hello world1");
	allocator.construct(&sp[1],"hello world2");
	allocator.construct(&sp[2],"hello world3");
	cout << sp[0] << endl;
	cout << sp[1] << endl;
	cout << sp[2] << endl;
	count << "have allocated " << allocator.max_size() << " strings\n";
	for (size_t i = 0;i < 3;i++) {
		allocator.destroy(sp+i);
	}
	allocator.deallocate(sp,3);
}
