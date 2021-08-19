package com.example.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/7/6 9:27
 * @description
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：orders = [["David","3","Ceviche"],
 *                ["Corina","10","Beef Burrito"],
 *                ["David","3","Fried Chicken"],
 *                ["Carla","5","Water"],
 *                ["Carla","5","Ceviche"],
 *                ["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
 *       ["3","0","2","1","0"],
 *       ["5","0","1","0","1"],
 *       ["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 *
 * 输入：orders = [["James","12","Fried Chicken"],
 *                ["Ratesh","12","Fried Chicken"],
 *                ["Amadeus","12","Fried Chicken"],
 *                ["Adam","1","Canadian Waffles"],
 *                ["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],
 *       ["1","2","0"],
 *       ["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 *
 * 输入：orders = [["Laura","2","Bean Burrito"],
 *                ["Jhon","2","Beef Burrito"],
 *                ["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],
 *       ["2","1","1","1"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class displayTable {
    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        List<String> order = new ArrayList<>();
        order.add("James");
        order.add("12");
        order.add("Fried Chicken");
        List<String> order1 = new ArrayList<>();
        order1.add("Ratesh");
        order1.add("12");
        order1.add("Gried Chicken");
        List<String> order2 = new ArrayList<>();
        order2.add("Ratesh");
        order2.add("12");
        order2.add("Aried Chicken");
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        System.out.println(displayTable(orders));
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        PriorityQueue<String> queue = new PriorityQueue<String>((o1, o2) -> {
            if (o1.charAt(0) - o2.charAt(0)>0){
                return 1;
            }
            return -1;
        });

        Map<Integer, Map<String,Integer>> map = new HashMap<>();
        Set<String> food = new HashSet<>();
        Set<Integer> table = new HashSet<>();
        for (List<String> order:orders){
            Integer tableIndex = Integer.valueOf(order.get(1));
            String foodName = order.get(2);
            food.add(foodName);
            table.add(tableIndex);

            Map<String, Integer> temp = map.getOrDefault(tableIndex, new HashMap<>());
            Integer num = temp.getOrDefault(foodName, 0);
            temp.put(foodName, num+1);
            map.put(tableIndex, temp);
        }
        queue.addAll(food);

        String[] tableArr = new String[table.size()+1];
        String[] tableArrs = table.toArray(tableArr);
        Arrays.sort(tableArrs);
        String[] strings = new String[queue.size()];
        String[] sortedFoods = queue.toArray(strings);

        List<List<String>> res = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();
        foodNames.add("Table");
        foodNames.addAll(Arrays.asList(sortedFoods));
        res.add(foodNames);
        for (int i=0;i<tableArrs.length;i++){
            List<String> resTemp = new ArrayList<>();
            resTemp.add(tableArrs[0]);
            for (int j=0;j<sortedFoods.length;j++){
//                resTemp.add(map.get(tableArrs[i]).getOrDefault(sortedFoods[j], 0));
            }
        }

        return null;
    }
}
