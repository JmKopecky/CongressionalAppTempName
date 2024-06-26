package dev.prognitio.cacao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.Nullable;

public class Course {

    public String courseName;
    public String teacher;
    public int semester;
    public double GPA;
    public int grade;

    public Course(String courseName, @Nullable String teacher, int semester, double GPA, int grade) {

        if (teacher.contains("^")) {
            teacher = teacher.replace("^", ",");
        }

        this.courseName = courseName;
        this.teacher = teacher;
        this.semester = semester;
        this.GPA = GPA;
        this.grade = grade;
    }


    public double calculateGPA() {
        double output = -1;

        output = GPA - ((100 - grade) * 0.1);

        return output;
    }

    public String getSemesterAsString() {
        String output = "ERROR";
        output = semester % 2 == 0 ? "Spring" : "Fall";
        return output;
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
