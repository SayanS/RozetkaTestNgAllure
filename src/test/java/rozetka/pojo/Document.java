package rozetka.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Document {
     private String title;
     private String annotation;
     private String firstString;
     private String lastString;

     public Document(String title, String annotation, String firstString, String lastString){
         this.title=title;
         this.annotation=annotation;
         this.firstString=firstString;
         this.lastString=lastString;
     }

     public Document(){
     }

     public Integer getSimilarityLavelFor(Document document){
         Integer similarityLavel=0;
         if(this.title.equals(document.getTitle())){similarityLavel++;}
         if(this.annotation.equals(document.getAnnotation())){similarityLavel++;}
         if(this.firstString.equals(document.getFirstString())){similarityLavel++;}
         if(this.lastString.equals(document.getLastString())){similarityLavel++;}
         return similarityLavel;
     }



}
