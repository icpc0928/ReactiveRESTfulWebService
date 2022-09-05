package com.example.reactiverestfulsebservice.domain.model;

public class Summer {

    private String result;

    public Summer(String result) {
        this.result = result;
    }

    public Summer(int a, int b){
        this.result = String.valueOf((a + b));
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
