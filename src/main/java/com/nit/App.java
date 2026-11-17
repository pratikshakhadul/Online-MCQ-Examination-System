package com.nit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Main.ConnectionEstablisher;

public class App 
{
    public static void main( String[] args )
    {
        Question question=new Question();
        question.setQuestions("What is Hibernate");
        
        Answers answer1=new Answers();
        answer1.setAnswers("Hibernate is an ORM");
        answer1.setQuestion(question);
        
        Answers answer2=new Answers();
        answer2.setAnswers("Hibernate follows JPA Rules");
        answer2.setQuestion(question);
        
        Answers answer3=new Answers();
        answer3.setAnswers("Hibernate is a Framework");
        answer3.setQuestion(question);
        
        List<Answers> data=new ArrayList<>();
        data.add(answer1);
        data.add(answer2);
        data.add(answer3);
        
        question.setAnswer(data);
        
        Session currentSession= ConnectionEstablisher.getConnection().openSession();
        
        Transaction transaction=currentSession.beginTransaction();
        
        currentSession.persist(question);
        currentSession.persist(answer1);
        currentSession.persist(answer2);
        currentSession.persist(answer3);
        
        System.out.println("Fetching the data");
        
        Question reference=currentSession.getReference(Question.class,1);
        System.out.println(reference.getQuestions());
        reference.getAnswer().stream().forEach(System.out::println);
        
        transaction.commit();
        currentSession.close();
     }
}
