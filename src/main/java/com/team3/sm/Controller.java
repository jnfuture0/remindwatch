package com.team3.sm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

abstract class Controller {
    List<Pair<String, String>> cursorList;
    private int currentCursor;
    private String storageName;
    HashMap<String, Integer> data = new HashMap<>();

    void moveCursor(){
        if(currentCursor+1 < cursorList.size()){
            this.currentCursor += 1;
        }
        else{
            this.currentCursor = 0;
        }
    }

    HashMap<String, Integer> getData(){
        return this.data;
    }

    void increaseValue(){
        Pair<String, String> current = cursorList.get(currentCursor);
        Integer prev = data.get(current.left);
        if (prev == null) {
            prev = 0;
        }
        switch (current.right) {
            case "inc": {
                this.data.put(current.left, this.increaseElement(current.left, prev));
                break;
            }
            case "set": {
                this.data.put(current.left, this.setUnsetValue(current.left, prev));
                break;
            }
            case "zero":
                this.data.put(current.left, this.setZero(current.left, prev));
                break;
            default:
                System.out.println("[ERROR] not implemented function");
                break;
        }
    }

    private int setZero(String name, int prev){
        return 0;
    }
    private int setUnsetValue(String name, int prev){
        return prev ^ 1;
    }
    protected Integer increaseElement(String name, int prev){
        return prev + 1;
    }

    void printElement(){
        System.out.println("[LOG] Data elements:");
        for (String key: this.data.keySet()){
            String value = this.data.get(key).toString();
            System.out.print(key + " " + value + " ");
        }
        System.out.println();
    }

    void clearData(){
        this.data.clear();
    }

    void setStorageName(String storageName){
        this.storageName = storageName;
    }

    void loadData() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(storageName));

        for (String key : properties.stringPropertyNames()) {
            this.data.put(key, Integer.parseInt(properties.get(key).toString()));
        }
    }

    void saveData() throws IOException {
        Properties properties = new Properties();

        for (String key : this.data.keySet()) {
            properties.put(key, this.data.get(key).toString());
        }
        properties.store(new FileOutputStream(storageName), null);
    }
}
