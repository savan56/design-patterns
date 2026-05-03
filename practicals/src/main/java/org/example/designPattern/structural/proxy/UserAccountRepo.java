package org.example.designPattern.structural.proxy;

public class UserAccountRepo implements UserRepository{
    @Override
    public UserAccount getUserAccountByAccountNumber(String accnum) {
        if (!accnum.isEmpty()) {
            System.out.println("proceeding with fetching user related actual db details");
            return new UserAccount();
        } else {
            return null;
        }
    }
}
