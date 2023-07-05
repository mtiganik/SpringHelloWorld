package com.example.SpringHelloWorld;

public class SqlSyntaxes {
    static final String QUERY_GET_PERSONS = "select Personid,LastName,FirstName,Age from sys.persons";
    static final String QUERY_GET_POSTS = "SELECT concat_ws(' ', persons.FirstName, persons.LastName) AS Author_Name, Post, posts.ts FROM Persons Inner join posts on persons.PersonId = posts.PersonId";

    public static String GetAllPersons(){
        return QUERY_GET_PERSONS;
    }

    public static String GetAllPosts(){
        return QUERY_GET_POSTS;
    }

    public static String GetPostsByAuthorId(int PersonId){
        return QUERY_GET_POSTS + " Where posts.PersonId = " + String.valueOf(PersonId);
    }
}
