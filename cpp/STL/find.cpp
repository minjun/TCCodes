#include <iostream>
#include <algorithm>

// Output the content of an array
void OutputVector(int* pArray, int count)
{
    std::cout << "The content of the array:" << std::endl;
    
    for(int i = 0; i < count; i++)
    {
        std::cout << pArray[i] << " ";
    }
	std::cout<<std::endl;
}

int main()
{
    int array[5] = {1,2,3,4,5};
    OutputVector(array, 5);
    
    int valueToFind = 4; 
    
    int* position = std::find(array, array + 5, valueToFind);
    
    bool exists = (position != (array + 5));
    
    if (exists)
    {
        std::cout << "Found it." << std::endl;
        
        std::cout << "The value is " << *position << std::endl;
    }
    else
    {
        std::cout << "Can't fount it." << std::endl;
    }
    
    return 0;
}