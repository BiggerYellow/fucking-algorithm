// LeetCode.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "LeetCode.h"
//#include "QuickSort.cpp"
//#include "mergeSort.cpp"
#include "radixSort.cpp"

using namespace std;
//extern int findMaxForm(vector<string>& strs, int m, int n);
//extern void bubbleSort1(vector<int>& nums);

int main()
{
    //Solution b;
    //printf("res %d", b.hammingDistance1(1, 4));
    //Solution b;
    //vector<int> nums = { 1,2,3,1 };

    //vector<string> strs = { "10", "0001", "111001", "1", "0" };
   // printf("%d", findMaxForm(strs, 3,4));

    Solution b;
    vector<int> nums = { 31,14,76,54,24,123,534 };
    b.radixSort(nums, 3);
    for (auto i : nums)
    {
        cout << i << endl;
    }
  /*  vector<int> nums = { 3,1,2,6,4 };
    b.quickSort(nums, 0, nums.size()-1);
    for (auto i:nums)
    {
        cout << i << endl;
    }*/
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
