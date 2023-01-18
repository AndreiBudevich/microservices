package com.mytt.authorizationservice;

public interface HasIdAndEmail extends HasId {
    String getEmail();
}