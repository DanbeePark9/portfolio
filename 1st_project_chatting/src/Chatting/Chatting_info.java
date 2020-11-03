package Chatting;

public class Chatting_info {
   
   private String id;
   private String pass;
   private String charar;
   private String gendar;
   
   public Chatting_info( String id, String pass, String charar, String gendar ) {
      
      this.id = id;
      this.pass = pass;
      this.charar = charar;
      this.gendar = gendar;
   }
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPass() {
      return pass;
   }
   public void setPass(String pass) {
      this.pass = pass;
   }
   public String getCharar() {
      return charar;
   }
   public void setCharar(String charar) {
      this.charar = charar;
   }
   public String getGendar() {
      return gendar;
   }
   public void setGendar(String gendar) {
      this.gendar = gendar;
   }
   
   @Override
   public String toString() {
      return "\nID : " + id +"\npass : " + pass +"\ncharacter : " + charar +"\ngendar : " + gendar;
   }
}