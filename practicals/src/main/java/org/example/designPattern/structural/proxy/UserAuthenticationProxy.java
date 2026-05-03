package org.example.designPattern.structural.proxy;

public class UserAuthenticationProxy implements UserRepository{

    private final UserRepository repository;

    public UserAuthenticationProxy(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount getUserAccountByAccountNumber(String accnum) {
        // user authentication logic
        if (authenticateUser()){
           return repository.getUserAccountByAccountNumber(accnum);
        } else {
            return null;
        }
    }

    private boolean authenticateUser() {
        System.out.println("user authenticated!");
        return true;
    }
}
