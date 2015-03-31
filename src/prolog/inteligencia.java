/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;

/**
 *
 * @author Kev
 */

import java.util.Hashtable;
import jpl.*;
import jpl.Query;

public class inteligencia {
    
    public void iniciar()
    {
        String t1 = "consult('nuevo.pl').";
        //Query q1 = new Query(t1);
        //System.out.println(t1 + " " + q1.hasSolution());
        
        String t2 = "progenitor(clara, X), progenitor(X, jose).";
        Query q2 = new Query(t2);
        System.out.println(t2 + " " + q2.hasSolution());
    }
    
}
