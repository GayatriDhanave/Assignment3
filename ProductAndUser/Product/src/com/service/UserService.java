package com.service;

import com.entity.Users;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    static List<Users> users = new ArrayList<>();
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
        users.stream()
                .filter(u -> u.getId() == id)
                .findFirst().ifPresent(u -> u.setName(name));
        System.out.println("User Updated");
    }
    public void removeUser () {
        System.out.println("Enter User Id: ");
        int id = sc.nextInt();
        users.removeIf(u -> u.getId() == id);
        System.out.println("User Removed");
    }
    public void printUsers () {
        users.forEach(System.out::println);
    }
    public List<Users> getUsers () {
        return users;
    }

}
