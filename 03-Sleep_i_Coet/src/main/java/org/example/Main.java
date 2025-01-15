package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DormAleatori pep = new DormAleatori("pep");
        pep.start();
        DormAleatori joan = new DormAleatori("joan");
        joan.start();
    }
}