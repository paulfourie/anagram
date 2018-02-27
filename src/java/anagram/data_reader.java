/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package anagram;


/**
 *
 * @author paulf
 */

import java.net.URL ;
import java.net.HttpURLConnection ;
import java.net.ConnectException ;

import java.io.IOException ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.StringReader ;

//import java.util.HashSet ;
//import java.util.Scanner;
//import java.util.Set;

import java.util.Arrays;



public class data_reader {
    
    
    
//    String   p_service_url ;
//    String   p_service_query ;
    
    String   p_wordlist_data ;
    String   p_answer ;
    
   
        
    
    public void read_data(){
        
       
        
        String    l_url_string  = "http://static.abscond.org/wordlist.txt" ;        
        String    l_url_query   = "" ;        
               
        
        String    l_user_agent  = "Mozilla/5.0" ;
        int       l_responseCode ;
        String    l_inputLine;
        
        String    l_wordlist_data = null ;
        
               
//        System.out.println( "reader invoked" ) ;
        
        
        try 
        {
            
            
            URL url_obj = new URL( l_url_string + l_url_query );
            
            HttpURLConnection con_obj = ( HttpURLConnection ) url_obj.openConnection() ;
            
            con_obj.setRequestMethod( "GET" );

            con_obj.setRequestProperty( "User-Agent", l_user_agent );         
            
            l_responseCode = con_obj.getResponseCode();
 
            
            
            BufferedReader inBuffer = new BufferedReader( new InputStreamReader( con_obj.getInputStream() ) );
            
            StringBuffer http_response = new StringBuffer();

            
            
            while (( l_inputLine = inBuffer.readLine()) != null) {
                    http_response.append( l_inputLine + "\n" );
            }
            inBuffer.close();
             
            
            // successful response 
            l_wordlist_data = http_response.toString() ;
            
 //           System.out.println( l_wordlist_data ) ;
            
            
            
        }
        catch ( ConnectException  e )
        {
        
            l_url_string = e.getMessage() ;
            
            System.out.println( l_url_string ) ;         
            
        }    
        catch ( IOException  e )
        {
           
            l_url_string = e.getMessage() ;
            
            System.out.println( l_url_string ) ;
            
        }
        catch ( Exception  e )  
        {
            
            l_url_string = e.getMessage() ;
            
            System.out.println( l_url_string ) ;    
            
        }
               
        
        p_wordlist_data = l_wordlist_data ;
        
        
    }    
    

  
    public void build_hashset( String S_answer ){
            
        int       answer_count ;
        String    s_sorted_data ;
        String    s_sorted_query ;
        
       
        
        try{
            
        
            
        answer_count = 0 ;
        
//        sorted_answer = S_answer.trim() ;
        
//        sorted_answer = S_answer.trim() ;
                
        char[] c_sort_answer = S_answer.toCharArray();
        
        Arrays.sort(c_sort_answer) ;
       
        s_sorted_query = new String(c_sort_answer).toLowerCase().trim() ;
        
//        System.out.println( c_sort_answer ) ;
        System.out.println( "query " + s_sorted_query ) ;
               
        
        for (String anagram_word : p_wordlist_data.split("\\n")){
            
            
            char[] c_anagram = anagram_word.toCharArray() ;
            
            Arrays.sort( c_anagram ) ;

            s_sorted_data = new String( c_anagram ).toLowerCase().trim() ;
            
            
//            System.out.println( "data" + s_sorted_data + "pad" ) ;
            
            
            if ( s_sorted_query.equals(s_sorted_data) ) {
            
                System.out.println( s_sorted_query + "=" + anagram_word ) ;
            // found anagram
                answer_count++ ;
                
                p_answer += anagram_word + s_sorted_query ;
        
            } 
            else
            {
//                System.out.println( s_sorted_query + "!=" + s_sorted_data ) ;
               
            }
                       
            
        }
        
        p_answer = p_answer + answer_count ;
        
//        p_answer = sorted_answer ;
     
        
//        p_answer = p_wordlist_data ;
        
        
        
        }
        catch ( Exception e )
        {
            
//            p_answer = e.getMessage() ;
            p_answer = "error" ;
            
        }
        

    }
    
    
    
    
    
    
    

    
}

