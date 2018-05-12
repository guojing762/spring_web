package com.lixiaodong.service;

import com.lixiaodong.dao.Test2Dao;
import com.lixiaodong.dao.TestDao;
import com.lixiaodong.db.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Service
public class TestServiceNew {
    @Autowired
    TestDao testDao;
    @Autowired
    Test2Dao test2Dao;
    public List<String> getName(){
        String name =  testDao.getOne();
        String name2 =  test2Dao.getOne();
        //list
        List list = new ArrayList();
        list.add(name);
        list.add(name2);

        return list;
    }

    public static void main(String[] args) {

        String name =  "limeng";
        String name2 =  "lixiaodong";
        //  集合 list set map

//        1,list集合
        List arrayList = new ArrayList();
        arrayList.add(name);
        arrayList.add(name2);



        List<String> linkedList = new LinkedList();
//        List linkedList = new LinkedList();
//        linkedList.add(1);
//        linkedList.add(true);
        linkedList.add(name);
        linkedList.add(name);
        linkedList.add(name2);
//        linkedList.remove(name2);
        for(int i=0;i<linkedList.size();i++){
//            System.out.println(linkedList.get(i));
        }
//        System.out.println("===================");
//        for(String curName : linkedList){
//            System.out.println(curName);
//        }
//        System.out.println(linkedList.size());

        //2,set
//        Set<String> set1 = new HashSet<>();
//        set1.add(name);
//        set1.add(name);
//        set1.add(name2);

//        for(int i=0;i<set1.size();i++){
////            System.out.println(set1.);
//////        }
//        for(String cur : set1){
//            System.out.println(cur);
//        }

//        Iterator iterator = set1.iterator();
//        while (iterator.hasNext()){
//            String cur = (String)iterator.next();
//            System.out.println(cur);
//        }

//        System.out.println(set1.size());
//
//
//        set2.add(name);
//        set2.add(name);
//        set2.add(name2);
        //3 map 实现了 set
        Map<String,String> map = new HashMap();
        Set<String> set1 = new HashSet<>();
        map.put("w", name);
        map.put("n", name2);
        map.put("w", name2);


        for(Map.Entry<String,String> entry : map.entrySet()){
            String key = entry.getKey();
            String v = entry.getValue();
            System.out.println(v);
        }


        Map map2 = new TreeMap();
        Set<String> set2 = new TreeSet<>();


        System.out.println(name.hashCode());
        System.out.println(name2.hashCode());
    }
}
