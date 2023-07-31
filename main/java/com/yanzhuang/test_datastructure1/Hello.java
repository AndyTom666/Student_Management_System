package com.yanzhuang.test_datastructure1;

class User
{
    String name;
    public void setName(String str)
    {
        name=str;
    }
    public String getName()
    {
        return name;
    }
}

public class Hello {
        public static void main(String[] args) {
            Hello hello = new Hello();
            User user2 = new User();
            user2.setName("li");
            hello.pass2(user2);
            System.out.println("main:"+user2.getName());
        }

        public void pass2(User user) {
            //user = new User();
            user.setName("java new");
            System.out.println("The name is :" + user.getName());
        }

    }

