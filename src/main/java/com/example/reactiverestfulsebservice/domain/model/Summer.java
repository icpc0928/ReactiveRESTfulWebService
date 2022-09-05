package com.example.reactiverestfulsebservice.domain.model;

public class Summer {

    private String result;

    public Summer(String result) {
        this.result = result;
    }

    public Summer() {
    }

    public void setResult(String result) {
        this.result = result;
    }



    public String getResult(){
        return this.result;
    }

    @Override
    public String toString() {
        return "Summer{" +
                "result='" + result + '\'' +
                '}';
    }
}
