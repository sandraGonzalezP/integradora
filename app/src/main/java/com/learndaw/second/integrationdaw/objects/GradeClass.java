package com.learndaw.second.integrationdaw.objects;

public class GradeClass {
    private int unit_one;
    private int unit_two;
    private int unit_three;
    private int unit_four;
    private int unit_five;
    private String usuarios_id;


    public GradeClass() {
    }

    public GradeClass(int unit_one, int unit_two, int unit_three, int unit_four, int unit_five, String usuarios_id) {
        this.unit_one = unit_one;
        this.unit_two = unit_two;
        this.unit_three = unit_three;
        this.unit_four = unit_four;
        this.unit_five = unit_five;
        this.usuarios_id = usuarios_id;
    }

    public int getUnit_one() {
        return unit_one;
    }

    public void setUnit_one(int unit_one) {
        this.unit_one = unit_one;
    }

    public int getUnit_two() {
        return unit_two;
    }

    public void setUnit_two(int unit_two) {
        this.unit_two = unit_two;
    }

    public int getUnit_three() {
        return unit_three;
    }

    public void setUnit_three(int unit_three) {
        this.unit_three = unit_three;
    }

    public int getUnit_four() {
        return unit_four;
    }

    public void setUnit_four(int unit_four) {
        this.unit_four = unit_four;
    }

    public int getUnit_five() {
        return unit_five;
    }

    public void setUnit_five(int unit_five) {
        this.unit_five = unit_five;
    }

    public String getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(String usuarios_id) {
        this.usuarios_id = usuarios_id;
    }
}
