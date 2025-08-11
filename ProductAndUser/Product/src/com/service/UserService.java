package com.service;

import com.entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    List<Users> users = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addUser () {
        Users u = new Users();
        System.out.println("Enter user Id: ");
        u.setId(sc.nextInt());
        System.out.println("Enter user name: ");
        u.setName(sc.next());
        users.add(u);
        System.out.println("User Added");
    }
    public void updateUser () {
        System.out.println("Enter User Id: ");
        int id = sc.nextInt();
        System.out.println("Enter User Name: ");
        String name = sc.next();
        for (Users u : users) {
            if (u.getId() == id) {
                u.setName(name);
                System.out.println("User Updated");
            }
        }
    }
    public void removeUser () {
        System.out.println("Enter User Id: ");
        int id = sc.nextInt();
        for (Users u : users) {
            if (u.getId() == id) {
                users.remove(u);
                System.out.println("User Removed");
            }
        }
    }
    public void getUsers () {
        for (Users u : users) {
            System.out.println(u);
        }
    }

}
