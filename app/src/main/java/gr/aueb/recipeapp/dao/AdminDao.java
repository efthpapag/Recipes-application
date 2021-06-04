package gr.aueb.recipeapp.dao;

import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.Ingredient;

public class AdminDao {

    public static ArrayList<Admin> allAdmins = new ArrayList<Admin>(Arrays.asList(new Admin[]{new Admin("username", "password"), new Admin("Koytsioykiadis", "password"), new Admin("Kakatsinos", "password"), new Admin("Papaefthymiou", "password")}));


}
