package com.example.travelbilawas;

public class ModelClass {
    private int image;
    private String category;
    private String seats;
    private int amount;
    private String time;
    private String status;

    private int sits;

    ModelClass(int image,String category,String seats,int amount,String time,String status){
        this.image=image;
        this.category=category;
        this.seats=seats;
        this.amount=amount;
        this.time=time;
        this.status=status;
        this.sits=getSits();
    }

    public int getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getSeats() {
        return seats;
    }

    public int getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

//    public int getSits(){
//        return 5;
//    }

    public int getSits() {
        if (seats == null || seats.isEmpty()) {
            return 0;
        }

        String numericString = seats.replaceAll("[^0-9]", ""); // Remove non-numeric characters

        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
        }
        return 0;
    }

}
