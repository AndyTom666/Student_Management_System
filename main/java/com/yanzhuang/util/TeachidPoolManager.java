package com.yanzhuang.util;
import java.util.*;


import javax.servlet.http.HttpSession;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.serviceimpl.TeacherServiceImpl;
public class TeachidPoolManager
{
    private static Hashtable<String,TeachidNode> teachidpools=
            new Hashtable<>();
    public static int max=-1;
    private String changeTeachid()
    {
        max++;
        if(max<10) return "teach0000"+max;
        if(max<100) return "teach000"+max;
        if(max<1000) return "teach00"+max;
        return "teach"+max;
    }
    synchronized
    public String getTeachid(String sessionID)
    {
        TeachidNode node=teachidpools.get(sessionID);
        long current=System.currentTimeMillis();
        //1、避免恶意刷号
        if(node!=null&&(current-node.allocateTime)<5*60*1000)
        {
            node.allocateTime=current;
            return node.teachid;
        }
        //2、利用已失效的学号
        Iterator<String> keys=teachidpools.keySet().iterator();
        while(keys.hasNext())
        {
            TeachidNode node2=teachidpools.get(keys.next());
            if((current-node2.allocateTime)>5*60*1000)
            {
                node2.session=sessionID;
                node2.allocateTime=current;
                return node2.teachid;
            }
        }
        //上述都不行就创建一个新的学号节点
        String teachid=changeTeachid();
        TeachidNode p=new TeachidNode(sessionID, teachid, current);
        teachidpools.put(sessionID, p);
        return teachid;
    }

    synchronized
    public boolean removeTeachid(String sessionID)
    {
        return teachidpools.remove(sessionID)!=null;
    }
}
