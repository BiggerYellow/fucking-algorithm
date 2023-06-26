// LeetCode.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "LeetCode.h"
//#include "QuickSort.cpp"
//#include "mergeSort.cpp"
//include "treeTraverse.cpp"
#include "BinarySearch.cpp"

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

    //Solution b;
    //vector<int> nums = { 1,3,2,7,5 };
    //b.quickSort(nums, 0, nums.size());
    //for (auto i : nums)
    //{
    //    cout << i << endl;
    //}

    Solution b;
    vector<int> nums = { 1,3,4,5,7,9 };
    printf("%d", b.binarySearch(nums, 4));


        //Solution b;
        //TreeNode node1 = TreeNode(1);
        //TreeNode node2 = TreeNode(2);
        //TreeNode node3 = TreeNode(3);
        //TreeNode node4 = TreeNode(4);
        //TreeNode node5 = TreeNode(5);
        //TreeNode node6 = TreeNode(6);
        //TreeNode node7 = TreeNode(7);
        //node1.left = &node2;
        //node1.right = &node3;
        //node2.left = &node4;
        //node2.right = &node5;
        //node3.left = &node6;
        //node3.right = &node7;
        //vector<int> res = b.sortBFS(&node1);
        //for (auto i:res)
        //{
        //    cout << i << endl;
        //}

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
