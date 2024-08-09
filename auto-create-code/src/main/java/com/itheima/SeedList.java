package com.itheima;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

public class SeedList {

    public static void main(String[] args) {
        Map<String,Object> seedMap = new HashMap<>();
        List<String> list = new ArrayList<String>();
        int n= 10;
        for (int i=0;i<n;i++){
            list.add(i+"");
        }
        seedMap.put("list",list);
        System.out.println(seedMapFilterLogic(seedMap,5));
    }
    /**
     *
     * 根据种子事件覆盖事件记录条数过滤逻辑
     * 将种子事件覆盖记录条数小于等于 filterCount值的记录从seedMap 中移除
     * @param seedMap
     * @param filterCount
     * @author Herman
     * @Date   2024.04.19
     * @return
     */
    public static Map<String,Object> seedMapFilterLogic(Map<String,Object> seedMap, int filterCount){
        if( seedMap==null ||seedMap.isEmpty() || filterCount<=0) {
            return new HashMap();
        }
        Iterator<Map.Entry<String, Object>> iterator = seedMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            List seedCoveredValueList =  (List)entry.getValue();
            if(seedCoveredValueList ==null || seedCoveredValueList.size()<=filterCount) {
                iterator.remove();
            }
        }
        return seedMap;
    }
}
