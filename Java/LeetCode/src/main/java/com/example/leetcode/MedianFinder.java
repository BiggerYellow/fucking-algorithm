package com.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangchunchen
 * @date 2021/8/27 9:09
 * @description
 */
public class MedianFinder {

    /** initialize your data structure here. */

     int[] array;
     int usedLen;
    public MedianFinder() {
        array = new int[16];
        usedLen=0;
    }

    public void addNum(int num) {
        if (array.length == usedLen){
            resize();
        }
        if (usedLen== 0){
            array[0]= num;
        }else {
            int index = binartSearch(num);
            for (int i=usedLen-1;i>=(index<0?0:index);i--){
                array[i+1] = array[i];
            }
            array[index+1] = num;
        }
        usedLen++;
    }

    public int binartSearch(int num){
        int left =0;
        int right = usedLen-1;
        while (left<=right){
            int mid = left+ (right-left)/2;
            if (array[mid] == num){
                return mid;
            }else if (array[mid]<num){
                left = mid+1;
            }else {
                right=mid-1;
            }
        }
        return right;
    }

    public void resize(){
        int[] temp = new int[array.length+array.length/2];
        System.arraycopy(array, 0, temp, 0, usedLen);
        array = temp;
    }

    public double findMedian() {
        if (usedLen%2 ==0 ){
            return (array[usedLen/2]+array[usedLen/2-1])/2.0;
        }else {
            return array[usedLen/2];
        }
    }

    /**
     * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
     * [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
     *
     * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
     * [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
     *
     * [null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,null,6.00000,null,6.00000,null,4.50000,null,3.00000]
     * [null,null,6.0,null,8.0,null,6.0,null,6.0,null,6.0,null,5.5,null,6.0,null,5.5,null,5.0,null,4.0,null,3.0]
     * @param args
     */
    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(-1);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-3);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian());
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());

    }
}
