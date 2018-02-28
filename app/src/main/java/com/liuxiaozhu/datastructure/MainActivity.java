package com.liuxiaozhu.datastructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * 测试数据结构的demo（链表）
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试单链表
//        testSingleList();

        //测试双链表
//        testLinkedList();
    }


    /**
     * 测试单链表
     */
    private void testSingleList() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(0);
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);

        //指定位置插入数据
//        singleLinkedList.add(0, 5);

        //删除指定数据
//        singleLinkedList.remove(1);

        //链表逆置
//        singleLinkedList.inverse();
        singleLinkedList.inverses();
        for (int i = 0; i < singleLinkedList.size; i++) {
            Log.e("取值", "i" + singleLinkedList.get(i));
        }
    }

    /**
     * 测试双链表
     */
    private void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);


        //指定位置插入数据
//        linkedList.add(2, 10);
        //替换
//        linkedList.set(2,10);
        //删除指定位置的元素
        linkedList.remove(2);
        for (int i = 0; i < linkedList.size; i++) {
            Log.e("取值", "i" + linkedList.get(i));
        }
    }
}
