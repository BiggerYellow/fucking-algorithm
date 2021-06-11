from typing import List



def search(self, nums: List[int], target: int) -> bool:
    if not nums:
        return False

    n = len(nums)
    if n==1:
        return nums[0]==target

    start,end =0,len-1
    while start<=end:
        mid = (start+end)//2
        if nums[end] ==nums[start]:
            ++start
            continue
        if nums[start] <= nums[mid]:
            if nums[start] <= target and nums[mid] > target:
                end = mid-1
            else:
                start = mid+1
        else:
            if nums[mid] < target and nums[len-1] >= target:
                start = mid+1
            else:
                end = mid-1

    return False


def main():
    nums = [2,5,6,0,0,1,2]
    print(search(nums, 0))

if __name__ == '__main__':
        main()
