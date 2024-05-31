package dev.prognitio.cacao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.Nullable;

public class Course {

    public String courseName;
    public String teacher;
    public int semester;
    public double GPA;
    public double grade;

    public Course(String courseName, @Nullable String teacher, int semester, double GPA, double grade) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.semester = semester;
        this.GPA = GPA;
        this.grade = grade;
    }

    public String toString() {
        String result;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        result = gson.toJson(this);
        return result;
    }

    public static Course fromString(String str) {
        Course output;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        output = gson.fromJson(str, Course.class);
        return output;
    }







}
